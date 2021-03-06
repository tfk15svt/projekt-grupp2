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

/**
 *
 * @author slett
 */
public class GetAllWinsForTeamService extends Service {
    
    private final Long teamId;
    
    public GetAllWinsForTeamService(Long teamId) {
        
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
        
        List<Game> listOfAwayGames = getBrokerFactory().getTeamBroker().getAllGamesForAwayTeam(teamId);
        List<Game> listOfHomeGames = getBrokerFactory().getTeamBroker().getAllGamesForHomeTeam(teamId);
        List<Game> listOfWonGames = new ArrayList<>();
        
        for(int x = 0; x < listOfAwayGames.size(); x++) {
            try {
                if (listOfAwayGames.get(x).getResult().getAwayScore() > listOfAwayGames.get(x).getResult().getHomeScore()) {
                
                    listOfWonGames.add(listOfAwayGames.get(x));
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
            
        }
        
        for(int x = 0; x < listOfHomeGames.size(); x++) {
            try {
                if (listOfHomeGames.get(x).getResult().getAwayScore() < listOfHomeGames.get(x).getResult().getHomeScore()) {
                
                    listOfWonGames.add(listOfHomeGames.get(x));
                }
            } catch (Exception ex) {
                ex.getMessage();
            }
            
        }
        
        return listOfWonGames;
    }
}
