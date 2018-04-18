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
        
        /**
         * ArrayList<List<Game>> arrayOfgameLists = new ArrayList<List<Game>>();
         * for(int i = 0; i < seasonIds.size(); i++){
         * GetAllGamesFromSeasonService getGames =
         * getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonIds.get(i));
         * getGames.init(getBrokerFactory());
         * arrayOfgameLists.add(getGames.execute()); }
         *
         * List<Game> conGameList = new ArrayList<Game>(); for(List<Game> list :
         * arrayOfgameLists){ conGameList = Stream.concat(conGameList.stream(),
         * list.stream()).collect(Collectors.toList()); }
         *
         * ArrayList<List<Team>> arrayOfTeamLists = new ArrayList<List<Team>>();
         *
         * for(int i = 0; i < seasonIds.size(); i++){
         * arrayOfTeamLists.add(getBrokerFactory().getSeasonBroker()
         * .getAllTeamsFromSeasonId(seasonIds.get(i))); }
         *
         * List<Team> conTeamList = new ArrayList<Team>();
         *
         * for (List<Team> teamList: arrayOfTeamLists){ for(Team team: teamList)
         * { boolean contains = false; long teamId = team.getDao().getLongId();
         *
         * for(Team addedTeam :conTeamList) { long addedTeamId =
         * addedTeam.getDao().getLongId(); contains = contains || (addedTeamId
         * == teamId); } if (!contains){ conTeamList.add(team); } } }
         */

        return new MakeTableFromGameList(listOfGames, listOfTeams).execute();
    }

}
