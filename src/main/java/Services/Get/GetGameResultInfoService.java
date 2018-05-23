/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Domain.Game;
import Domain.Result;
import Services.Service;
import Services.ServiceException;

/**
 *
 * @author Simon
 */
public class GetGameResultInfoService extends Service{

    private final Long gameId;

    public GetGameResultInfoService(Long gameId) {
        this.gameId = gameId;
        if (gameId == null) {
            throw new ServiceException("Game id is null");
        }
    }

    @Override
    public String execute() {
        if (!getBrokerFactory().getGameBroker().gameExists(gameId)) {
            throw new ServiceException("Game not found");
        }
        Game game = getBrokerFactory().getGameBroker().findById(gameId);
        if(game.getResult() == null){
            return "no result for this game";
        }
        Result result = game.getResult();
        String resultTime = "";
        if (result.getFullTime()) {
            resultTime = " : settled in full time";
        }
        if (result.getOverTime()) {
            resultTime = " : settled in overtime";
        }
        if (result.getShotOut()) {
            resultTime = " : settled after shootout";
        }
        return "" + game.getHomeTeam().getName() + " " + result.getHomeScore() + " - " + result.getAwayScore() + " " + game.getAwayTeam().getName() + resultTime ;
    }
    
    
    
}
