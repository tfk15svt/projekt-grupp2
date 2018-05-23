/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Domain.Game;
import Services.Service;
import Services.ServiceException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author slett
 */
public class GetAllTiesForTeamService extends Service {
    
    private final Long teamId;
    
    public GetAllTiesForTeamService(Long teamId) {
        
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
        
        List<Game> listOfGames = getBrokerFactory().getTeamBroker().getAllGamesForOneTeam(teamId);
        List<Game> listOfTiedGames = new ArrayList<>();
        
        for(int x = 0; x < listOfGames.size(); x++) {
            try {
                if (Objects.equals(listOfGames.get(x).getResult().getAwayScore(), listOfGames.get(x).getResult().getHomeScore())) {
                
                    listOfTiedGames.add(listOfGames.get(x));
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
            
        }
        
        return listOfTiedGames;
    }
}
