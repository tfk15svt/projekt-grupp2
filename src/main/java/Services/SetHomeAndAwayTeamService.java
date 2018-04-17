/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import Domain.Team;

/**
 *
 * @author Simon
 */
public class SetHomeAndAwayTeamService extends Service{
    private final Long homeTeamId;
    private final Long awayTeamId;
    private final Long gameId;

    public SetHomeAndAwayTeamService(Long homeTeamId, Long awayTeamId, Long gameId) {
        this.homeTeamId = homeTeamId;
        this.awayTeamId = awayTeamId;
        this.gameId = gameId;
        
        if(homeTeamId == null){
            throw new ServiceException("hometeamID cannot be null");
        }
        if(awayTeamId == null){
            throw new SecurityException("awayTeamID cannot be null");
        }
        if(gameId == null){
            throw new SecurityException("gameID cannot be null");
        }
    }

    @Override
    public Game execute() {
        Team homeTeam = getBrokerFactory().getTeamBroker().findTeamById(homeTeamId);
        Team awayTeam = getBrokerFactory().getTeamBroker().findTeamById(awayTeamId);
        Game game = getBrokerFactory().getGameBroker().findById(gameId);
        
        if(getBrokerFactory().getTeamBroker().teamExists(homeTeamId) == false){
            throw new ServiceException("hometeam not found");
        }
        if(getBrokerFactory().getTeamBroker().teamExists(awayTeamId) == false){
            throw new ServiceException("awayteam not found");
        }
        
        
        game.setHomeTeam(homeTeam);
        game.setAwayTeam(awayTeam);
        game.getDao().save();
        
        return game;
    }
    
    
}

