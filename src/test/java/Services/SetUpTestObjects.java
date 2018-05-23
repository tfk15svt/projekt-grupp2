/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
 * @author Simon
 */
public class SetUpTestObjects {

    private static Result result1;
    private static Result result2;
    private static Result result3;
    private static Result result4;
    private static Result result5;
    private static Result result6;
    private static Result result7;
    private static Result result8;
    private static Result result9;
    private static Result result10;
    private static Result result11;
    private static Result result12;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    private static Game game4;
    private static Game game5;
    private static Game game6;
    private static Game game7;
    private static Game game8;
    private static Game game9;
    private static Game game10;
    private static Game game11;
    private static Game game12;
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
    private static Round round5;
    private static Round round6;
    private static Round round7;
    private static Round round8;
    private static Round round9;
    private static Round round10;
   private static Round round11;
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
    private static Long gameId6;
    private static Long gameId7;
    private static Long gameId8;
    private static Long gameId9;
    private static Long gameId10;
    private static Long gameId11;
    private static Long gameId12;
    private static Long arenaId;
    private static TeamsSeasonsDao tTs1;
    private static TeamsSeasonsDao tTs2;
    private static TeamsSeasonsDao tTs3;
    private static TeamsSeasonsDao tTs4;
    private static TeamsSeasonsDao tTs5;
    private static TeamsSeasonsDao tTs6;
    private static int numberOfGames;


    public static void setUp() {
        DbConn.staticOpen();
        numberOfGames = 0;
        result1 = new Result();
        result2 = new Result();
        result3 = new Result();
        result4 = new Result();
        result5 = new Result();
        result6 = new Result();
        result7 = new Result();
        result8 = new Result();
        result9 = new Result();
        result10 = new Result();
        result11 = new Result();
        result12 = new Result();
        game1 = new Game(); numberOfGames++;
        game2 = new Game(); numberOfGames++;
        game3 = new Game(); numberOfGames++;
        game4 = new Game(); numberOfGames++;
        game5 = new Game(); numberOfGames++;
        game6 = new Game(); numberOfGames++;
        game7 = new Game(); numberOfGames++;
        game8 = new Game(); numberOfGames++;
        game9 = new Game(); numberOfGames++;
        game10 = new Game(); numberOfGames++;
        game11 = new Game(); numberOfGames++;
        game12 = new Game(); numberOfGames++;
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
        round5 = new Round();
        round6 = new Round();
        round7 = new Round();
        round8 = new Round();
        round9 = new Round();
        round10 = new Round();
        round11 = new Round();
        league = new League();

        sport.setName("sporttest12791");
        sport.getDao().save();

        league.setSport(sport);
        league.setName("leaguetest19271");
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

        team1.setName("teamtesst12971");
        team1.setSport(sport);
        team1.getDao().save();

        team2.setName("teamtesst22971");
        team2.setSport(sport);
        team2.getDao().save();
        
        team3.setName("teamtesst32971");
        team3.setSport(sport);
        team3.getDao().save();
        
        team4.setName("teamtesst42971");
        team4.setSport(sport);
        team4.getDao().save();
        
        team5.setName("teamtesst52791");
        team5.setSport(sport);
        team5.getDao().save();
        
        team6.setName("teamtesst62971");
        team6.setSport(sport);
        team6.getDao().save();

        arena.maxCapacity(8500);
        arena.setArenaName("Gavlerinken");
        arena.getDao().save();
        arenaId = arena.getDao().getLongId();

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
        
        round5.setRoundNumber(5);
        round5.setSeason(season2);
        round5.getDao().save();
        
        round6.setRoundNumber(6);
        round6.setSeason(season2);
        round6.getDao().save();
        
        round7.setRoundNumber(7);
        round7.setSeason(season2);
        round7.getDao().save();
        
        round8.setRoundNumber(8);
        round8.setSeason(season2);
        round8.getDao().save();
        
        round9.setRoundNumber(9);
        round9.setSeason(season2);
        round9.getDao().save();
        
        round10.setRoundNumber(10);
        round10.setSeason(season2);
        round10.getDao().save();
        
        round11.setRoundNumber(11);
        round11.setSeason(season2);
        round11.getDao().save();

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
        
        game6.setArena(arena);
        game6.setHomeTeam(team3);
        game6.setAwayTeam(team4);
        game6.setRound(round5);
        game6.setDate(20190424);
        game6.getDao().save();
        gameId6 = game6.getDao().getLongId();
        
        game7.setArena(arena);
        game7.setHomeTeam(team4);
        game7.setAwayTeam(team3);
        game7.setRound(round6);
        game7.setDate(20190426);
        game7.getDao().save();
        gameId7 = game7.getDao().getLongId();
        
        game8.setArena(arena);
        game8.setHomeTeam(team3);
        game8.setAwayTeam(team4);
        game8.setRound(round7);
        game8.setDate(20190428);
        game8.getDao().save();
        gameId8 = game8.getDao().getLongId();
        
        game9.setArena(arena);
        game9.setHomeTeam(team3);
        game9.setAwayTeam(team4);
        game9.setRound(round8);
        game9.setDate(20190430);
        game9.getDao().save();
        gameId9 = game9.getDao().getLongId();
        
        game10.setArena(arena);
        game10.setHomeTeam(team4);
        game10.setAwayTeam(team3);
        game10.setRound(round9);
        game10.setDate(20190432);
        game10.getDao().save();
        gameId10 = game10.getDao().getLongId();
        
        game11.setArena(arena);
        game11.setHomeTeam(team4);
        game11.setAwayTeam(team3);
        game11.setRound(round10);
        game11.setSpectators(7000);
        game11.setDate(20190432);
        game11.getDao().save();
        gameId11 = game11.getDao().getLongId();
        
        game12.setArena(arena);
        game12.setHomeTeam(team1);
        game12.setAwayTeam(team2);
        game12.setRound(round10);
        game12.setSpectators(4500);
        game12.setDate(20190433);
        game12.getDao().save();
        gameId12 = game12.getDao().getLongId();
        

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
        
        try{
            result6.setHomeScore(20);
            result6.setAwayScore(10);
        }catch(Exception e){
            e.getMessage();
        }
        game6.setResult(result6);
        result6.setFullTime();
        result6.getDao().save();
        
        try{
            result7.setHomeScore(8);
            result7.setAwayScore(4);
        }catch(Exception e){
            e.getMessage();
        }
        game7.setResult(result7);
        result7.setFullTime();
        result7.getDao().save();
        
        try{
            result8.setHomeScore(3);
            result8.setAwayScore(1);
        }catch(Exception e){
            e.getMessage();
        }
        game8.setResult(result8);
        result8.setFullTime();
        result8.getDao().save();
        
        try{
            result9.setHomeScore(7);
            result9.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        game9.setResult(result9);
        result9.setFullTime();
        result9.getDao().save();
        
        try{
            result10.setHomeScore(2);
            result10.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        game10.setResult(result10);
        result10.setFullTime();
        result10.getDao().save();
        
        try{
            result11.setHomeScore(16);
            result11.setAwayScore(16);
            result11.setScore("1:2-3:2-6:4-6:8", result11.getHomeScore(), result11.getAwayScore());
        }catch(Exception e){
            e.getMessage();
        }
        game11.setResult(result11);
        result11.setFullTime();
        result11.getDao().save();
        
        try{
            result12.setHomeScore(8);
            result12.setAwayScore(12);
            result12.setScore("2:3-4:6-1:1-1:2", result12.getHomeScore(), result12.getAwayScore());
        }catch(Exception e){
            e.getMessage();
        }
        game12.setResult(result12);
        result12.setFullTime();
        result12.getDao().save();
        
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

    }

    public static void tearDown() {
        
        tTs1.delete();
        tTs2.delete();
        tTs3.delete();
        tTs4.delete();
        tTs5.delete();
        tTs6.delete();
        result1.getDao().delete();
        result2.getDao().delete();
        result3.getDao().delete();
        result4.getDao().delete();
        result5.getDao().delete();
        result6.getDao().delete();
        result7.getDao().delete();
        result8.getDao().delete();
        result9.getDao().delete();
        result10.getDao().delete();
        result11.getDao().delete();
        result12.getDao().delete();
        
        game1.getDao().delete();
        game2.getDao().delete();
        game3.getDao().delete();
        game4.getDao().delete();
        game5.getDao().delete();
        game6.getDao().delete();
        game7.getDao().delete();
        game8.getDao().delete();
        game9.getDao().delete();
        game10.getDao().delete();
        game11.getDao().delete();
        game12.getDao().delete();
        
        round1.getDao().delete();
        round2.getDao().delete();
        round3.getDao().delete();
        round4.getDao().delete();
        round5.getDao().delete();
        round6.getDao().delete();
        round7.getDao().delete();
        round8.getDao().delete();
        round9.getDao().delete();
        round10.getDao().delete();
        round11.getDao().delete();
        season1.getDao().delete();
        season2.getDao().delete();
        league.getDao().delete();
        arena.getDao().delete();
        team1.getDao().delete();
        team2.getDao().delete();
        team3.getDao().delete();
        team4.getDao().delete();
        team5.getDao().delete();
        team6.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    public static Long getLeagueId () {
        return leagueId;
    }
    public static Long getGameId1() {
        return gameId1;
    }

    public static Long getGameId2() {
        return gameId2;
    }
    
    public static Long getGameId3(){
        return gameId3;
    }
    
    public static Long getGameId4(){
        return gameId4;
    }
    
    public static Long getGameId5(){
        return gameId5;
    }
    
    public static Long getGameId6(){
        return gameId6;
    }
    
    public static Long getGameId7(){
        return gameId7;
    }
    
    public static Long getGameId8(){
        return gameId8;
    }
    
    public static Long getGameId9(){
        return gameId9;
    }
    
    public static Long getGameId10(){
        return gameId10;
    }
    
    public static Long getGameId11(){
        return gameId11;
    }

    public static Long getTeamId1() {
        teamId1 = team1.getDao().getLongId();
        return teamId1;
    }

    public static Long getTeamId2() {
        teamId2 = team2.getDao().getLongId();
        return teamId2;
    }
    
    public static Long getTeamId3() {
        teamId3 = team3.getDao().getLongId();
        return teamId3;
    }
        
    public static Long getTeamId4() {
        teamId4 = team4.getDao().getLongId();
        return teamId4;
    }
            
    public static Long getTeamId5() {
        teamId5 = team5.getDao().getLongId();
        return teamId5;
    }
                
    public static Long getTeamId6() {
        teamId6 = team6.getDao().getLongId();
        return teamId6;
    }
    public static Long getSeasonId1() {
        return seasonId1;
    }
    
    public static Long getSeasonId2(){
        return seasonId2;
    }
    public static int getNumberOfGames(){
        return numberOfGames;
    }
    
    public static Long getArenaId1(){
        return arenaId;
    }
    
}
