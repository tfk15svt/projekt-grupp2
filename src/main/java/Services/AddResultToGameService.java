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

    private Result result;
    private final Long gameId;
    private int homeScore;
    private int awayScore;
    
    public AddResultToGameService(Result result, Long gameId) {
        this.result = result;
        this.gameId = gameId;
        if (result == null)
            throw new ServiceException("Result is null");
        if (gameId == null)
            throw new ServiceException("GameId is null");
    }
    public AddResultToGameService(int homeScore, int awayScore, Long gameId){
        if (gameId == null)
            throw new ServiceException("GameId is null");
        else{
            this.gameId = gameId;
        }
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    
    
    @Override
    public Result execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        Game game = brokerFactory.getGameBroker().findById(gameId);
        if (game == null)
            throw new ServiceException("There is no game with that Id");
        if (result == null){
            result = brokerFactory.getResultBroker().create();
            try {
                result.setAwayScore(awayScore);
                result.setHomeScore(homeScore);
            } catch (Exception ex) {
                Logger.getLogger(AddResultToGameService.class.getName()).log(Level.SEVERE, null, ex);
            }
            brokerFactory.getResultBroker().saveResult(result);
        }
        
        game.setResult(result);
        brokerFactory.getGameBroker().saveGame(game);
        return result;
    }
    
}
