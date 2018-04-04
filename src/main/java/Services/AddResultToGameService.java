/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import DAO.GameDao;
import Domain.Game;
import Domain.Result;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Simon
 */
public class AddResultToGameService extends Service {

    private final Result result;
    private final Long gameId;
    
    public AddResultToGameService(Result result, Long gameId) {
        this.result = result;
        this.gameId = gameId;
    }

    
    
    @Override
    public Result execute() {
        Game game = getBrokerFactory().getGameBroker().findById(gameId);
        game.setResult(result);
        game.getDao().save();
        return result;
    }
    
}
