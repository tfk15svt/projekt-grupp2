/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import DAO.TeamsSeasonsDao;
import DB.DbConn;
import Domain.Arena;
import Domain.Game;
import Domain.League;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
import Domain.Team;

/**
 *
 * @author slett
 */
public class FillDatabase {
    private static Result result1;
    private static Result result2;
    private static Result result3;
    private static Result result4;
    private static Result result5;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    private static Game game4;
    private static Game game5;
    private static Sport sport;
    private static Arena arena;
    private static Team team1;
    private static Team team2;
    private static Team team3;
    private static Team team4;
    private static Team team5;
    private static Team team6;
    private static Season season1;
    private static Long seasonId1;
    private static Season season2;
    private static Long seasonId2;
    private static Round round1;
    private static Round round2;
    private static Round round3;
    private static Round round4;
    private static League league;
    private static Long leagueId;
    private static Long teamId1;
    private static Long teamId2;
    private static Long teamId6;
    private static Long teamId3;
    private static Long teamId4;
    private static Long teamId5;
    private static Long gameId1;
    private static Long gameId2;
    private static Long gameId3;
    private static Long gameId4;
    private static Long gameId5;
    private static TeamsSeasonsDao tTs1;
    private static TeamsSeasonsDao tTs2;
    private static TeamsSeasonsDao tTs3;
    private static TeamsSeasonsDao tTs4;
    private static TeamsSeasonsDao tTs5;
    private static TeamsSeasonsDao tTs6;
    private static int numberOfGames;
    
      public static void main(String[] args) {
          DbConn.staticOpen();
        numberOfGames = 0;
        result1 = new Result();
        result2 = new Result();
        result3 = new Result();
        result4 = new Result();
        result5 = new Result();
        game1 = new Game(); numberOfGames++;
        game2 = new Game(); numberOfGames++;
        game3 = new Game(); numberOfGames++;
        game4 = new Game(); numberOfGames++;
        game5 = new Game(); numberOfGames++;
       
        arena = new Arena();
        team1 = new Team();
        team2 = new Team();
        team3 = new Team();
        team4 = new Team();
        team5 = new Team();
        team6 = new Team();
        sport = new Sport();
        season1 = new Season();
        season2 = new Season();
        round1 = new Round();
        round2 = new Round();
        round3 = new Round();
        round4 = new Round();
        league = new League();

        arena.setArenaName("Friends Arena");
        arena.getDao().save();
        
        sport.setName("Fotboll");
        sport.getDao().save();

        league.setSport(sport);
        league.setName("Allsvenskan");
        league.getDao().save();
        leagueId = league.getId();
        season1.setSummer(Boolean.TRUE);
        season1.setYear(1);
        
        season2.setSummer(Boolean.TRUE);
        season2.setYear(2019);

        league.addSeason(season1);
        league.addSeason(season2);
        season2.getDao().save();
        season1.getDao().save();
        seasonId1 = season1.getId();
        seasonId2 = season2.getId();

        team1.setName("Aik");
        team1.setSport(sport);
        team1.getDao().save();

        team2.setName("Dif");
        team2.setSport(sport);
        team2.getDao().save();
        
        team3.setName("Malmö");
        team3.setSport(sport);
        team3.getDao().save();
        
        team4.setName("IFK");
        team4.setSport(sport);
        team4.getDao().save();
        
        team5.setName("Dalkurd");
        team5.setSport(sport);
        team5.getDao().save();
        
        team6.setName("Elfsborg");
        team6.setSport(sport);
        team6.getDao().save();


        round1.setRoundNumber(1);
        round1.setSeason(season1);
        round1.getDao().save();
        
        round2.setRoundNumber(2);
        round2.setSeason(season2);
        round2.getDao().save();
        
        round3.setRoundNumber(2);
        round3.setSeason(season1);
        round3.getDao().save();
        
        round4.setRoundNumber(3);
        round4.setSeason(season1);
        round4.getDao().save();

        game1.setArena(arena);
        game1.setDate(1);
        game1.setAwayTeam(team1);
        game1.setHomeTeam(team2);
        game1.setRound(round1);
        game1.setDate(1);
        game1.getDao().save();
        gameId1 = game1.getDao().getLongId();

        game2.setArena(arena);
        game2.setDate(2);
        game2.setAwayTeam(team1);
        game2.setHomeTeam(team2);
        game2.setRound(round1);
        game2.setDate(2);
        game2.getDao().save();
        gameId2 = game2.getDao().getLongId();
        
        game3.setArena(arena);
        game3.setHomeTeam(team1);
        game3.setAwayTeam(team2);
        game3.setRound(round2);
        game3.setDate(3);
        game3.getDao().save();
        gameId3 = game3.getDao().getLongId();
        
        game4.setArena(arena);
        game4.setHomeTeam(team5);
        game4.setAwayTeam(team2);
        game4.setRound(round3);
        game4.setDate(4);
        game4.getDao().save();
        gameId4 = game4.getDao().getLongId();
        
        game5.setArena(arena);
        game5.setHomeTeam(team2);
        game5.setAwayTeam(team1);
        game5.setRound(round4);
        game5.setDate(3);
        game5.getDao().save();
        gameId5 = game5.getDao().getLongId();
        

        try {
            result1.setHomeScore(43);
            result1.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        game1.setResult(result1);
        result1.setFullTime();
        result1.getDao().save();

        try {
            result2.setHomeScore(4);
            result2.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game2.setResult(result2);
        result2.setOverTime();
        result2.getDao().save();
        
        try {
            result3.setHomeScore(7);
            result3.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game3.setResult(result3);
        result3.setOverTime();
        result3.getDao().save();
        
        try{
            result4.setHomeScore(3);
            result4.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        game4.setResult(result4);
        result4.setFullTime();
        result4.getDao().save();
        
        try{
            result5.setHomeScore(8);
            result5.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        game5.setResult(result5);
        result5.setFullTime();
        result5.getDao().save();
        
        tTs1 = new TeamsSeasonsDao();
        tTs1.setSeason(season1);
        tTs1.setTeam(team1);
        tTs1.save();
        
        tTs2 = new TeamsSeasonsDao();
        tTs2.setSeason(season1);
        tTs2.setTeam(team2);
        tTs2.save();
        
        tTs3 = new TeamsSeasonsDao();
        tTs3.setSeason(season2);
        tTs3.setTeam(team3);
        tTs3.save();
        
        tTs4 = new TeamsSeasonsDao();
        tTs4.setSeason(season2);
        tTs4.setTeam(team4);
        tTs4.save();
        
        tTs5 = new TeamsSeasonsDao();
        tTs5.setSeason(season1);
        tTs5.setTeam(team5);
        tTs5.save();
        
        tTs6 = new TeamsSeasonsDao();
        tTs6.setSeason(season2);
        tTs6.setTeam(team6);
        tTs6.save();
        DbConn.staticClose();
      }
}

