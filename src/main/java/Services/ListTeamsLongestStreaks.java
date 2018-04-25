/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ListTeamsLongestStreaks extends Service {

    private final Long teamId;
    private final Integer startDate;
    private final Integer endDate;
    private int maxStreakWins;
    private int maxStreakTied;
    private int maxStreakLost;
    private int streakWins;
    private int streakTied;
    private int streakLost;
    private List<Game> listOfGames;
    private int gamesPlayed;

    public ListTeamsLongestStreaks(Long teamId, Integer startDate, Integer endDate) {
        this.teamId = teamId;
        this.startDate = startDate;
        this.endDate = endDate;
        if (teamId == null) {
            throw new ServiceException("teamId cannot be null");
        }

        if (startDate == null) {
            throw new ServiceException("startDate cannot be null");
        }

        if (endDate == null) {
            throw new ServiceException("endDate cannot be null");
        }
    }

    @Override
    public String execute() {
        maxStreakWins = 0;
        maxStreakTied = 0;
        maxStreakLost = 0;
        gamesPlayed = 0;
        streakWins = 0;
        streakTied = 0;
        streakLost = 0;
        Game game;
        listOfGames = getBrokerFactory().getTeamBroker().getAllGamesForOneTeam(teamId);
        for (int i = 0; i < listOfGames.size(); i++) {
            game = listOfGames.get(i);
            if (game.getDate() >= startDate && game.getDate() <= endDate) {
                gamesPlayed++;
                if (game.getHomeTeam().getId().equals(teamId) && game.getResult().getHomeScore() > game.getResult().getAwayScore()
                        || game.getAwayTeam().getId().equals(teamId) && game.getResult().getAwayScore() > game.getResult().getHomeScore()) {
                    maxStreakWins++;

                } else {
                    if (streakWins < maxStreakWins) {
                        streakWins = maxStreakWins;
                    }
                    maxStreakWins = 0;
                }
                if(streakWins < maxStreakWins){
                    streakWins = maxStreakWins;
                }
            }

            if (game.getDate() >= startDate && game.getDate() <= endDate) {
                if (game.getHomeTeam().getId().equals(teamId) && game.getResult().getHomeScore() < game.getResult().getAwayScore()
                        || game.getAwayTeam().getId().equals(teamId) && game.getResult().getAwayScore() < game.getResult().getHomeScore()) {
                    maxStreakLost++;
                } else {
                    if (streakLost < maxStreakLost) {
                        streakLost = maxStreakLost;
                    }
                    maxStreakLost = 0;
                }
                if(streakLost < maxStreakLost){
                    streakLost = maxStreakLost;
                }
            }

            if (game.getDate() >= startDate && game.getDate() <= endDate) {
                if (game.getHomeTeam().getId().equals(teamId) && game.getResult().getHomeScore().equals(game.getResult().getAwayScore())
                        || game.getAwayTeam().getId().equals(teamId) && game.getResult().getAwayScore().equals(game.getResult().getHomeScore())) {
                    maxStreakTied++;
                } else {
                    if (streakTied < maxStreakTied) {
                        streakTied = maxStreakTied;
                    }
                    maxStreakTied = 0;
                }
                if(streakTied < maxStreakTied){
                    streakTied = maxStreakTied;
                }
            }
        }
        return "GP:" + gamesPlayed + " WinningStreak:" + streakWins + " TiedStreak:" + streakTied + " LostStreak:" + streakLost;
    }
}
