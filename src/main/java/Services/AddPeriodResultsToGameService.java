/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import Domain.Result;

/**
 *
 * @author ntn13aae
 */
public class AddPeriodResultsToGameService extends Service {
    
    private final Integer homeScores[];
    private final Integer awayScores[];
    private final Long gameId;
    
    public AddPeriodResultsToGameService(Integer[] homeScores, Integer[] awayScores, Long gameId) {
        
        this.homeScores = homeScores;
        this.awayScores = awayScores;
        this.gameId = gameId;
        
        if(homeScores.length != awayScores.length)
            throw new ServiceException("Homescore and Awayscore need equal length");
        
        for (Integer x : homeScores) {
            if (x == null) {
                throw new ServiceException("HomeScore is null");
            }
        }
        
        for (Integer x : awayScores) {
            if (x == null) {
                throw new ServiceException("AwayScore is null");
            }
        }
        
        if (gameId == null)
            throw new ServiceException("GameId is null");
    }   
    
    
    @Override
    public Result execute() {
        Result result;
        if (getBrokerFactory().getResultBroker().findByGameId(gameId) != null)
            result = getBrokerFactory().getResultBroker().findByGameId(gameId);
        else
            result = getBrokerFactory().getResultBroker().create();
        
        
        
        Game game = getBrokerFactory().getGameBroker().findById(gameId);
        if(getBrokerFactory().getGameBroker().findById(gameId)==null)
            throw new ServiceException("game does not exist.");
        
        String scoreString = "";
        Integer finalHomeScore = 0;
        Integer finalAwayScore = 0;
        for(int x = 0; x < homeScores.length; x++) {
            finalHomeScore += homeScores[x];
            finalAwayScore += awayScores[x];
            scoreString += homeScores[x];
            scoreString += ":";
            scoreString += awayScores[x];
            if ((x+1) != homeScores.length)
                scoreString += "-";
        }
        try {
            result.setScore(scoreString, finalHomeScore, finalAwayScore);
        } catch (Exception ex){
            ex.getMessage();
        }
        
        game.setResult(result);
        getBrokerFactory().getGameBroker().saveGame(game);
        result.getDao().save();
        
        return result;
    }
}
