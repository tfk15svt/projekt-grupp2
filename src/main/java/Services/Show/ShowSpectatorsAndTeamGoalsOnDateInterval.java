/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Domain.Game;
import Services.Service;
import Services.ServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ShowSpectatorsAndTeamGoalsOnDateInterval extends Service{
    private Long leagueId;
    private Integer startDate;
    private Integer endDate;

    public ShowSpectatorsAndTeamGoalsOnDateInterval(Long leagueId, Integer startDate, Integer endDate) {
        this.leagueId = leagueId;
        this.startDate = startDate;
        this.endDate = endDate;
        
        if(leagueId == null){
            throw new ServiceException("leagueId cannot be null");
        }
        if(startDate == null){
            throw new ServiceException("startDate cannot be null");
        }
        if(endDate == null){
            throw new ServiceException("endDate cannot be null");
        }
    }
    
    

    @Override
    public List<String> execute() {
        List<String> los = new ArrayList<>();
        double totalSpectators = 0;
        double homeScore = 0;
        double awayScore = 0;
        String hometeam = "";
        String awayTeam = "";
        List<Game> listOfLeaugeGames = getBrokerFactory().getLeagueBroker().getAllGames(leagueId);
        List<Game> gamesInInterval = new ArrayList<>();
        for(int i = 0; i < listOfLeaugeGames.size(); i++){
            Game game = listOfLeaugeGames.get(i);
            if(game.getDate() >= startDate && game.getDate() <= endDate){
                gamesInInterval.add(game);
            }
        }
        
        int spectators = 0;
        int hScore = 0;
        int aScore = 0;
        int numberOfGames = 0;
        for(int i = 0; i < gamesInInterval.size(); i++){
            String st = "";
            Game game = gamesInInterval.get(i);
            if(game.getSpectators() != null){
            hScore = game.getResult().getHomeScore();
            aScore = game.getResult().getAwayScore();
            spectators = game.getSpectators();
            totalSpectators += game.getSpectators();
            homeScore += game.getResult().getHomeScore();
            awayScore += game.getResult().getAwayScore();
            totalSpectators += game.getSpectators();
            numberOfGames++;
            
            st = "\n" + "Game:" + numberOfGames + " Spectators: " + spectators + " HomeTeamName: " 
                    + game.getHomeTeam().getName() + " HomeScore: " + hScore + " AwayTeamName: " 
                    + game.getAwayTeam().getName() + " AwayScore: " + aScore;
            los.add(st);
            }       
        }        
        return los;
    }
}
