/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;


import Domain.Game;
import Domain.Result;
import Services.Service;
import Services.ServiceException;

/**
 *
 * @author Simon
 */
public class AddResultToGameService extends Service {

    private final Integer homeScore;
    private final Integer awayScore;
    private final Long gameId;
    
    public AddResultToGameService(Integer homeScore, Integer awayScore, Long gameId) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
        this.gameId = gameId;
        
        if (homeScore < 0)
            throw new ServiceException("Result is null");
        
        if (awayScore < 0)
            throw new ServiceException("Result is null");
        
        if (gameId == null)
            throw new ServiceException("GameId is null");
    }

    
    
    @Override
    public Result execute() {
       
        Result result = getBrokerFactory().getResultBroker().findByGameId(gameId);
        if(result == null) {
            
            result = getBrokerFactory().getResultBroker().create();
        }
        try {
            if (result.getScore() != null)
                throw new ServiceException("Score (partial result) is not null, use AddPeriodResults instead");
            } catch (Exception ex) {
                ex.getMessage();
        }

        Game game = getBrokerFactory().getGameBroker().findById(gameId);
        
        if(getBrokerFactory().getGameBroker().findById(gameId)==null){
            throw new ServiceException("game does not exist.");
        }
        try {
            result.setHomeScore(homeScore);
            } catch (Exception ex) {
                ex.getMessage();
            }
        try{
            result.setAwayScore(awayScore);
            }catch(Exception e){
                e.getMessage();
            }
        game.setResult(result);
        getBrokerFactory().getGameBroker().saveGame(game);
        result.getDao().save();
        return result;
    }
    
}
