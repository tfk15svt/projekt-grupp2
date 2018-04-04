/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
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
        if (result == null)
            throw new ServiceException("Result is null");
        if (gameId == null)
            throw new ServiceException("GameId is null");
    }

    
    
    @Override
    public Result execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        Game game = brokerFactory.getGameBroker().findById(gameId);
        if (game == null)
            throw new ServiceException("There is no game with that Id");
        game.setResult(result);
        brokerFactory.getGameBroker().saveGame(game);
        return result;
    }
    
}
