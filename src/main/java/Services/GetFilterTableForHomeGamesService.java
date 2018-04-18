/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.MakeTableFromGameList;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class GetFilterTableForHomeGamesService extends Service{
    private final Long seasonId;
    List<Team> listOfTeams;
    List<Game> listOfGames;
    List<Team> homeTeams;
    List<Game> homeGames;
    Game game;
    Team team;
    Result result;

    public GetFilterTableForHomeGamesService(Long seasonId) {
        this.seasonId = seasonId;
        if(seasonId == null){
            throw new ServiceException("seasonId cannot be null");
        }
    }

    @Override
    public String execute() {
        listOfTeams = new ArrayList<>();
        listOfGames = new ArrayList<>();
        homeTeams = new ArrayList<>();
        homeGames = new ArrayList<>();
        
        if(getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId) == null){
            throw new ServiceException("no season with given id");
        }
        
        GetAllGamesFromSeasonService getGames = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
        getGames.init(getBrokerFactory());
        listOfGames = getGames.execute();
        listOfTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        
        for(int i = 0; i<listOfGames.size(); i++){
            game = listOfGames.get(i);
           
            
            
        }
        
        for(Team team : listOfTeams){
            boolean contains = false;
            long teamId = (long) team.getDao().getLongId();
            
            for(Team addedTeam : homeTeams){
                long addedTeamId = (long) addedTeam.getDao().getLongId();
                contains = contains || (addedTeamId == teamId);
            }
            if(!contains){
                homeTeams.add(team);
            }
        }
        return new MakeTableFromGameList(homeGames, homeTeams).execute();    
    }
}
