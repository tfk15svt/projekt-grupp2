/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import Domain.Team;
import java.util.List;

/**
 *
 * @author Simon
 */
public class GetAllGamesForAwayTeamService extends Service{
    private final Long teamId;

    public GetAllGamesForAwayTeamService(Long teamId) {
        this.teamId = teamId;
        
        if(teamId == null){
            throw new ServiceException("teamId cannot be null.");
        }
    }

    @Override
    public List<Game> execute() {
        if(getBrokerFactory().getTeamBroker().findTeamById(teamId) == null){
            throw new ServiceException("id not found.");
        }
        List<Game> listOfGames = getBrokerFactory().getTeamBroker().getAllGamesForAwayTeam(teamId);
        
        return listOfGames;
    }
    
    
    
    
}