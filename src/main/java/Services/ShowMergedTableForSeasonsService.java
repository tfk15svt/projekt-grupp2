/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.GetTeamsFromListOfGames;
import AssistantClasses.MakeTableFromGameList;
import AssistantClasses.MakeTableFromGameList.TableRow;
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
    public List<TableRow> execute() {
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
        
        GetTeamsFromListOfGames getTeams = new GetTeamsFromListOfGames(listOfGames);
        getTeams.init(getBrokerFactory());
        List<Team> listOfTeams = getTeams.execute();
        boolean[] conditions = new boolean[2];
        conditions[0] = true;
        conditions[1] = true;
        return new MakeTableFromGameList(listOfGames, listOfTeams, conditions).execute();
    }

}
