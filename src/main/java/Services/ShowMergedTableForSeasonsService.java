/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.MakeTableFromGameList;
import Domain.Game;
import Domain.Season;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Simon
 */
public class ShowMergedTableForSeasonsService extends Service {

    List<Long> seasonIds;

    public ShowMergedTableForSeasonsService(List<Long> seasonIds) {
        this.seasonIds = seasonIds;
        if (seasonIds == null) {
            throw new ServiceException("seasonIds cannot be null");
        }
    }

    @Override
    public String execute() {
        for (Long id : seasonIds) {
            if (!getBrokerFactory().getSeasonBroker().seasonExists(id)) {
                throw new ServiceException("no season with given id");
            }
        }
        List<Game> listOfGames = seasonIds.stream().map(id
                -> {
            GetAllGamesFromSeasonService getGames = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(id);
            getGames.init(getBrokerFactory());
            return getGames.execute();
        }).flatMap(gameList -> gameList.stream())
                .collect(Collectors.toList());
        
        List<Team> listOfTeams = Stream.concat(
                listOfGames.stream().map(game -> ((Game) game).getHomeTeam()), 
                listOfGames.stream().map(game -> ((Game) game).getAwayTeam()))
                .map(team -> (long) team.getId())
                .distinct()
                .map(id -> getBrokerFactory().getTeamBroker().findTeamById(id))
                .collect(Collectors.toList());
        
        return new MakeTableFromGameList(listOfGames, listOfTeams).execute();
    }

}
