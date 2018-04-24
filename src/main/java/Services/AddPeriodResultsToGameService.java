/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
                throw new ServiceException("Result is null");
            }
        }
        
        for (Integer x : awayScores) {
            if (x == null) {
                throw new ServiceException("Result is null");
            }
        }
        
        if (gameId == null)
            throw new ServiceException("GameId is null");
    }   
    
    
    @Override
    public Result execute() {
        Result result = new Result();
        String scoreString = "";

        for(int x = 0; x < homeScores.length; x++) {
            
            scoreString += homeScores[x];
            scoreString += ":";
            scoreString += awayScores[x];
            scoreString += "-";
        }


        return result;
    }
}
