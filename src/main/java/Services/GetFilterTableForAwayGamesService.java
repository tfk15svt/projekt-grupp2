/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.MakeAwayGameTable;
import Domain.Game;
import Domain.Team;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class GetFilterTableForAwayGamesService extends Service{
    private final Long seasonId;
    List<Team> listOfTeams;
    List<Game> listOfGames;
    List<Team> awayTeams;

    public GetFilterTableForAwayGamesService(Long seasonId) {
        this.seasonId = seasonId;
        if(seasonId == null){
            throw new ServiceException("seasonId cannot be null");
        }
    }
    

    @Override
    public String execute() {
        listOfTeams = new ArrayList<>();
        listOfGames = new ArrayList<>();
        awayTeams = new ArrayList<>();
        
        if(getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId) == null){
            throw new ServiceException("no season with given id");
        }
        
        GetAllGamesFromSeasonService getGames = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
        getGames.init(getBrokerFactory());
        listOfGames = getGames.execute();
        listOfTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        
        for(Team team : listOfTeams){
            boolean contains = false;
            long teamId = (long) team.getDao().getLongId();
            
            for(Team addedTeam : awayTeams){
                long addedTeamId = (long) addedTeam.getDao().getLongId();
                contains = contains || (addedTeamId == teamId);
            }
            if(!contains){
                awayTeams.add(team);
            }
        }
        return new MakeAwayGameTable(listOfGames, awayTeams).execute();  
        
    }
    
}
