/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Get.GetAllGamesFromSeasonService;
import Broker.BrokerFactory;
import Domain.Game;
import Services.Service;
import Services.ServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ShowPercentGoalsOnPeriodFilter extends Service {

    private final Long seasonId;
    private final Integer startDate;
    private final Integer endDate;

    public ShowPercentGoalsOnPeriodFilter(Long seasonId, Integer startDate, Integer endDate) {
        this.seasonId = seasonId;
        this.startDate = startDate;
        this.endDate = endDate;

        if (seasonId == null) {
            throw new ServiceException("seasonId cannot be null");
        }
        if (startDate == null) {
            throw new ServiceException("startDate cannot be null");
        }
        if (endDate == null) {
            throw new ServiceException("endDate cannot be null");
        }
    }
    
        @Override
    public List<String> execute() {
        List<String> listOfTeamsString = new ArrayList<>();
        GetAllGamesFromSeasonService allGames = getBrokerFactory().getServiceBroker().getAllGamesFromSeasonService(seasonId);
        allGames.init(new BrokerFactory());
        List<Game> allGamesForOneSeason = allGames.execute();
        for (int i = 0; i < allGamesForOneSeason.size(); i++) {
            Game game = allGamesForOneSeason.get(i);
            char homeTeamScore;
            char awayTeamScore;
            int homeScore;
            int awayScore;
            double totalScore;
            double homeScorePercent;
            double awayScorePercent;
            
            int periodNumber = 0;
            if ((game.getDate() >= startDate && game.getDate() <= endDate) && game.getResult().getScore() != null) {
                for (int j = 0; j < game.getResult().getScore().length(); j++) {
                    if (game.getResult().getScore().charAt(j) == ':') {
                        periodNumber++;
                        homeTeamScore = game.getResult().getScore().charAt(j - 1);
                        awayTeamScore = game.getResult().getScore().charAt(j + 1);
                        homeScore = Character.getNumericValue(homeTeamScore);
                        awayScore = Character.getNumericValue(awayTeamScore);
                        totalScore = homeScore+awayScore;
                        homeScorePercent = (homeScore/totalScore)*100;
                        awayScorePercent = (awayScore/totalScore)*100;
                        
                        String homeTeamString = "\n Period:" + periodNumber + " HomeTeamName: " + game.getHomeTeam().getName() + " HomeScores: "
                                + homeScorePercent + "% AwayScore: " + awayScorePercent + "%";
                        String awayTeamString = "\n Period:" + periodNumber + " AwayTeamName: " + game.getAwayTeam().getName() + " AwayScores: "
                                + awayScorePercent + "% HomeScore: " + homeScorePercent + "%" + "\n";
                        listOfTeamsString.add(homeTeamString);
                        listOfTeamsString.add(awayTeamString);
                    }
                }
            }
        }
        return listOfTeamsString;
    }
}


