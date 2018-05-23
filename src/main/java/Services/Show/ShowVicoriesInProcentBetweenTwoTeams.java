/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Domain.Game;
import Domain.Team;
import Services.Service;
import Services.ServiceException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ShowVicoriesInProcentBetweenTwoTeams extends Service {

    private final Long teamId1;
    private final Long teamId2;
    private int team1Wins;
    private int team2Wins;
    private double numberOfGames;
    private int numberOfGamesInt;
    private double procentTeam1;
    private double procentTeam2;
    private double procentTied;
    private int tied;
    private final Integer start;
    private final Integer end;

    public ShowVicoriesInProcentBetweenTwoTeams(Long teamId1, Long teamId2, Integer start, Integer end) {
        this.teamId1 = teamId1;
        this.teamId2 = teamId2;
        this.start = start;
        this.end = end;
        if (teamId1 == null) {
            throw new ServiceException("teamId1 cannot be null");
        }
        if (teamId2 == null) {
            throw new ServiceException("teamId2 cannot be null");
        }
    }

    @Override
    public String execute() {
        team1Wins = 0;
        team2Wins = 0;
        tied = 0;
        numberOfGames = 0;
        numberOfGamesInt = 0;
        if (getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(teamId1, teamId2) == null) {
            throw new ServiceException("No game between this teams.");
        }

        if (start == null && end == null) {
            allGames();
        }

        if (start != null && end != null) {
            roundInterval();
            dateInterval();
            seasonInterval();
        }
        
        if(start == null && end != null || start != null && end == null){
            throw new ServiceException("One of start/end is null.");
        }
        return "GP:" + numberOfGamesInt + " team1:" + procentTeam1 + "%" + " team2:" + procentTeam2 + "%" + " tied:" + procentTied + "%";
    }

    public void allGames(){
        List<Game> gameBetweenTwoTeams = getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(teamId1, teamId2);
        List<Game> listOfGames = new ArrayList<>();
        Game game;
            for (int i = 0; i < gameBetweenTwoTeams.size(); i++) {
                game = gameBetweenTwoTeams.get(i);
                listOfGames.add(game);
            }
            makeProcentStats(listOfGames);
    }
    
    public void roundInterval() {
        List<Game> gameBetweenTwoTeams = getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(teamId1, teamId2);
        List<Game> roundGames = new ArrayList<>();
        Game game;
        for (int i = 0; i < gameBetweenTwoTeams.size(); i++) {
            game = gameBetweenTwoTeams.get(i);
            if (game.getRound().getRoundNumber() >= start && game.getRound().getRoundNumber() <= end) {
                roundGames.add(game);
            }
        }
        makeProcentStats(roundGames);
    }
    
    public void dateInterval(){
        List<Game> gameBetweenTwoTeams = getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(teamId1, teamId2);
        List<Game> dateGames = new ArrayList<>();
        Game game;
        for(int i = 0; i < gameBetweenTwoTeams.size(); i++){
            game = gameBetweenTwoTeams.get(i);
            if(game.getDate() >= start && game.getDate() <= end){
                dateGames.add(game);
            }
        }
        makeProcentStats(dateGames);
    }
    
    public void seasonInterval(){
        List<Game> gameBetweenTwoTeams = getBrokerFactory().getTeamBroker().getAllGamesForTwoTeams(teamId1, teamId2);
        List<Game> seasonGames = new ArrayList<>();
        Game game;
        for(int i = 0; i < gameBetweenTwoTeams.size(); i++){
            game = gameBetweenTwoTeams.get(i);
            if(game.getRound().getSeason().getYear() >= start && game.getRound().getSeason().getYear() <= end){
                seasonGames.add(game);
            }
        }
        makeProcentStats(seasonGames);
    }
    
    public void makeProcentStats(List<Game> listOfGames){
        for(Game game : listOfGames){
            if (game.getHomeTeam().getId().equals(teamId1) && game.getResult().getHomeScore() > game.getResult().getAwayScore()) {
                team1Wins++;
                numberOfGames++;
                numberOfGamesInt++;
            }

            if (game.getHomeTeam().getId().equals(teamId2) && game.getResult().getHomeScore() > game.getResult().getAwayScore()) {
                team2Wins++;
                numberOfGames++;
                numberOfGamesInt++;
            }

            if (game.getAwayTeam().getId().equals(teamId1) && game.getResult().getAwayScore() > game.getResult().getHomeScore()) {
                team1Wins++;
                numberOfGames++;
                numberOfGamesInt++;
            }

            if (game.getAwayTeam().getId().equals(teamId2) && game.getResult().getAwayScore() > game.getResult().getHomeScore()) {
                team2Wins++;
                numberOfGames++;
                numberOfGamesInt++;
            }

            if (game.getResult().getHomeScore().equals(game.getResult().getAwayScore())) {
                tied++;
                numberOfGames++;
                numberOfGamesInt++;
            }
        }
        if(numberOfGames == 0){
            procentTeam1 = 0;
            procentTeam2 = 0;
            procentTied = 0;
        }
        if(numberOfGames != 0){
        procentTeam1 = (team1Wins / numberOfGames) * 100;
        procentTeam2 = (team2Wins / numberOfGames) * 100;
        procentTied = (tied / numberOfGames) * 100;
        }
    }
}
