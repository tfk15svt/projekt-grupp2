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
    
    //Fotboll
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
    private static Result result13;
    private static Result result14;
    private static Result result15;
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
    private static Game game13;
    private static Game game14;
    private static Game game15;
    private static Sport sport1;
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
    
    
    //Hockey
    
    private static Result resultH1;
    private static Result resultH2;
    private static Result resultH3;
    private static Result resultH4;
    private static Result resultH5;
    private static Result resultH6;
    private static Result resultH7;
    private static Result resultH8;
    private static Result resultH9;
    private static Result resultH10;
    private static Result resultH11;
    private static Result resultH12;
    private static Result resultH13;
    private static Result resultH14;
    private static Result resultH15;
    private static Game gameH1;
    private static Game gameH2;
    private static Game gameH3;
    private static Game gameH4;
    private static Game gameH5;
    private static Game gameH6;
    private static Game gameH7;
    private static Game gameH8;
    private static Game gameH9;
    private static Game gameH10;
    private static Game gameH11;
    private static Game gameH12;
    private static Game gameH13;
    private static Game gameH14;
    private static Game gameH15;
    private static Sport sport2;
    private static Arena arenaH;
    private static Team teamH1;
    private static Team teamH2;
    private static Team teamH3;
    private static Team teamH4;
    private static Team teamH5;
    private static Team teamH6;
    private static Season season3;
    private static Long seasonId3;
    private static Round roundH1;
    private static Round roundH2;
    private static Round roundH3;
    private static Round roundH4;
    private static League league2;
    private static Long league2Id;
    private static Long teamHId1;
    private static Long teamHId2;
    private static Long teamHId6;
    private static Long teamHId3;
    private static Long teamHId4;
    private static Long teamHId5;
    private static Long gameHId1;
    private static Long gameHId2;
    private static Long gameHId3;
    private static Long gameHId4;
    private static Long gameHId5;
    private static TeamsSeasonsDao tTsH1;
    private static TeamsSeasonsDao tTsH2;
    private static TeamsSeasonsDao tTsH3;
    private static TeamsSeasonsDao tTsH4;
    private static TeamsSeasonsDao tTsH5;
    private static TeamsSeasonsDao tTsH6;
    private static int numberOfGamesH;
    
    
    
    
    
    
    
      public static void main(String[] args) {
          DbConn.staticOpen();
        numberOfGames = 0;
        numberOfGamesH = 0;
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
        result13 = new Result();
        result14 = new Result();
        result15 = new Result();
        
        resultH1 = new Result();
        resultH2 = new Result();
        resultH3 = new Result();
        resultH4 = new Result();
        resultH5 = new Result();
        resultH6 = new Result();
        resultH7 = new Result();
        resultH8 = new Result();
        resultH9 = new Result();
        resultH10 = new Result();
        resultH11 = new Result();
        resultH12 = new Result();
        resultH13 = new Result();
        resultH14 = new Result();
        resultH15 = new Result();
        
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
        game13 = new Game(); numberOfGames++;
        game14 = new Game(); numberOfGames++;
        game15 = new Game(); numberOfGames++;
        
        
        gameH1 = new Game(); numberOfGamesH++;
        gameH2 = new Game(); numberOfGamesH++;
        gameH3 = new Game(); numberOfGamesH++;
        gameH4 = new Game(); numberOfGamesH++;
        gameH5 = new Game(); numberOfGamesH++;
        gameH6 = new Game(); numberOfGamesH++;
        gameH7 = new Game(); numberOfGamesH++;
        gameH8 = new Game(); numberOfGamesH++;
        gameH9 = new Game(); numberOfGamesH++;
        gameH10 = new Game(); numberOfGamesH++;
        gameH11 = new Game(); numberOfGamesH++;
        gameH12 = new Game(); numberOfGamesH++;
        gameH13 = new Game(); numberOfGamesH++;
        gameH14 = new Game(); numberOfGamesH++;
        gameH15 = new Game(); numberOfGamesH++;
       
        arena = new Arena();
        team1 = new Team();
        team2 = new Team();
        team3 = new Team();
        team4 = new Team();
        team5 = new Team();
        team6 = new Team();
        
        arenaH = new Arena();
        teamH1 = new Team();
        teamH2 = new Team();
        teamH3 = new Team();
        teamH4 = new Team();
        teamH5 = new Team();
        teamH6 = new Team();
        
        sport1 = new Sport();
        sport2 = new Sport();
        season1 = new Season();
        season2 = new Season();
        season3 = new Season();
        round1 = new Round();
        round2 = new Round();
        round3 = new Round();
        round4 = new Round();
        
        
        roundH1 = new Round();
        roundH2 = new Round();
        roundH3 = new Round();
        roundH4 = new Round();
        
        
        league = new League();
        league2 = new League();

        arena.setArenaName("Friends Arena");
        arena.getDao().save();
        
        arenaH.setArenaName("Gavlerinken");
        arenaH.getDao().save();
        
        sport1.setName("Fotboll");
        sport1.getDao().save();
        
        sport2.setName("Hockey");
        sport2.getDao().save();
        
        league2.setSport(sport2);
        league2.setName("SHL");
        league2.getDao().save();
        league2Id = league2.getId();
        season3.setSummer(Boolean.FALSE);
        season3.setYear(2018);
        league2.addSeason(season3);
        

        league.setSport(sport1);
        league.setName("Allsvenskan");
        league.getDao().save();
        leagueId = league.getId();
        season1.setSummer(Boolean.TRUE);
        season1.setYear(2018);
        
        season2.setSummer(Boolean.TRUE);
        season2.setYear(2017);

        league.addSeason(season1);
        league.addSeason(season2);
        league2.addSeason(season3);
        season2.getDao().save();
        season1.getDao().save();
        season3.getDao().save();
        seasonId1 = season1.getId();
        seasonId2 = season2.getId();
        seasonId3 = season3.getId();

        team1.setName("Aik");
        team1.setSport(sport1);
        team1.getDao().save();

        team2.setName("Dif");
        team2.setSport(sport1);
        team2.getDao().save();
        
        team3.setName("Malmö");
        team3.setSport(sport1);
        team3.getDao().save();
        
        team4.setName("IFK");
        team4.setSport(sport1);
        team4.getDao().save();
        
        team5.setName("Dalkurd");
        team5.setSport(sport1);
        team5.getDao().save();
        
        team6.setName("Elfsborg");
        team6.setSport(sport1);
        team6.getDao().save();
        
        
        
        teamH1.setName("Brynäs");
        teamH1.setSport(sport2);
        teamH1.getDao().save();

        teamH2.setName("Djurgården");
        teamH2.setSport(sport2);
        teamH2.getDao().save();
        
        teamH3.setName("Frölunda");
        teamH3.setSport(sport2);
        teamH3.getDao().save();
        
        teamH4.setName("Färjestad");
        teamH4.setSport(sport2);
        teamH4.getDao().save();
        
        teamH5.setName("HV71");
        teamH5.setSport(sport2);
        teamH5.getDao().save();
        
        teamH6.setName("Linköping");
        teamH6.setSport(sport2);
        teamH6.getDao().save();


        round1.setRoundNumber(1);
        round1.setSeason(season1);
        round1.getDao().save();
        
        round2.setRoundNumber(2);
        round2.setSeason(season2);
        round2.getDao().save();
        
        round3.setRoundNumber(3);
        round3.setSeason(season1);
        round3.getDao().save();
        
        round4.setRoundNumber(4);
        round4.setSeason(season1);
        round4.getDao().save();
        
        
        roundH1.setRoundNumber(5);
        roundH1.setSeason(season3);
        roundH1.getDao().save();
        
        roundH2.setRoundNumber(6);
        roundH2.setSeason(season3);
        roundH2.getDao().save();
        
        roundH3.setRoundNumber(7);
        roundH3.setSeason(season3);
        roundH3.getDao().save();
        
        roundH4.setRoundNumber(8);
        roundH4.setSeason(season3);
        roundH4.getDao().save();

        game1.setArena(arena);
        game1.setDate(20180101);
        game1.setAwayTeam(team1);
        game1.setHomeTeam(team2);
        game1.setRound(round1);
        game1.setDate(20180105);
        game1.getDao().save();
        gameId1 = game1.getDao().getLongId();

        game2.setArena(arena);
        game2.setDate(20180202);
        game2.setAwayTeam(team2);
        game2.setHomeTeam(team3);
        game2.setRound(round1);
        game2.setDate(20180203);
        game2.getDao().save();
        gameId2 = game2.getDao().getLongId();
        
        game3.setArena(arena);
        game3.setHomeTeam(team3);
        game3.setAwayTeam(team4);
        game3.setRound(round2);
        game3.setDate(20180303);
        game3.getDao().save();
        gameId3 = game3.getDao().getLongId();
        
        game4.setArena(arena);
        game4.setHomeTeam(team4);
        game4.setAwayTeam(team5);
        game4.setRound(round3);
        game4.setDate(20180404);
        game4.getDao().save();
        gameId4 = game4.getDao().getLongId();
        
        game5.setArena(arena);
        game5.setHomeTeam(team5);
        game5.setAwayTeam(team6);
        game5.setRound(round4);
        game5.setDate(20180605);
        game5.getDao().save();
        gameId5 = game5.getDao().getLongId();
        
        game6.setArena(arena);
        game6.setHomeTeam(team6);
        game6.setAwayTeam(team1);
        game6.setRound(round4);
        game6.setDate(20180508);
        game6.getDao().save();
        gameId5 = game6.getDao().getLongId();
        
        game7.setArena(arena);
        game7.setHomeTeam(team2);
        game7.setAwayTeam(team5);
        game7.setRound(round4);
        game7.setDate(20180602);
        game7.getDao().save();
        gameId5 = game7.getDao().getLongId();
        
        game8.setArena(arena);
        game8.setHomeTeam(team3);
        game8.setAwayTeam(team1);
        game8.setRound(round4);
        game8.setDate(20180801);
        game8.getDao().save();
        gameId5 = game8.getDao().getLongId();
        
        game9.setArena(arena);
        game9.setHomeTeam(team4);
        game9.setAwayTeam(team2);
        game9.setRound(round4);
        game9.setDate(20180702);
        game9.getDao().save();
        gameId5 = game9.getDao().getLongId();
        
        game10.setArena(arena);
        game10.setHomeTeam(team5);
        game10.setAwayTeam(team3);
        game10.setRound(round4);
        game10.setDate(20180305);
        game10.getDao().save();
        gameId5 = game10.getDao().getLongId();
        
        game11.setArena(arena);
        game11.setHomeTeam(team3);
        game11.setAwayTeam(team6);
        game11.setRound(round4);
        game11.setDate(20180515);
        game11.getDao().save();
        gameId5 = game11.getDao().getLongId();
        
        
        game12.setArena(arena);
        game12.setHomeTeam(team6);
        game12.setAwayTeam(team2);
        game12.setRound(round4);
        game12.setDate(20180601);
        game12.getDao().save();
        gameId5 = game12.getDao().getLongId();
        
        
        game13.setArena(arena);
        game13.setHomeTeam(team5);
        game13.setAwayTeam(team3);
        game13.setRound(round4);
        game13.setDate(20180704);
        game13.getDao().save();
        gameId5 = game13.getDao().getLongId();
        
        
        game14.setArena(arena);
        game14.setHomeTeam(team4);
        game14.setAwayTeam(team5);
        game14.setRound(round4);
        game14.setDate(20180901);
        game14.getDao().save();
        gameId5 = game14.getDao().getLongId();
        
        
        game15.setArena(arena);
        game15.setHomeTeam(team1);
        game15.setAwayTeam(team4);
        game15.setRound(round4);
        game15.setDate(20180903);
        game15.getDao().save();
        gameId5 = game15.getDao().getLongId();

        
        
        
        gameH1.setArena(arenaH);
        gameH1.setDate(20180101);
        gameH1.setAwayTeam(teamH1);
        gameH1.setHomeTeam(teamH2);
        gameH1.setRound(roundH1);
        gameH1.setDate(20180103);
        gameH1.getDao().save();
        gameHId1 = gameH1.getDao().getLongId();

        gameH2.setArena(arenaH);
        gameH2.setDate(20180202);
        gameH2.setAwayTeam(teamH1);
        gameH2.setHomeTeam(teamH2);
        gameH2.setRound(roundH1);
        gameH2.setDate(20180303);
        gameH2.getDao().save();
        gameHId2 = gameH2.getDao().getLongId();
        
        gameH3.setArena(arenaH);
        gameH3.setHomeTeam(teamH1);
        gameH3.setAwayTeam(teamH2);
        gameH3.setRound(roundH2);
        gameH3.setDate(20180404);
        gameH3.getDao().save();
        gameHId3 = gameH3.getDao().getLongId();
        
        gameH4.setArena(arenaH);
        gameH4.setHomeTeam(teamH5);
        gameH4.setAwayTeam(teamH2);
        gameH4.setRound(roundH3);
        gameH4.setDate(20180505);
        gameH4.getDao().save();
        gameHId4 = gameH4.getDao().getLongId();
        
        gameH5.setArena(arenaH);
        gameH5.setHomeTeam(teamH2);
        gameH5.setAwayTeam(teamH1);
        gameH5.setRound(roundH4);
        gameH5.setDate(20180606);
        gameH5.getDao().save();
        gameHId5 = gameH5.getDao().getLongId();
        
        gameH6.setArena(arenaH);
        gameH6.setHomeTeam(teamH6);
        gameH6.setAwayTeam(teamH1);
        gameH6.setRound(roundH4);
        gameH6.setDate(20180508);
        gameH6.getDao().save();
        gameHId5 = gameH6.getDao().getLongId();
        
        gameH7.setArena(arenaH);
        gameH7.setHomeTeam(teamH2);
        gameH7.setAwayTeam(teamH5);
        gameH7.setRound(roundH4);
        gameH7.setDate(20180602);
        gameH7.getDao().save();
        gameHId5 = gameH7.getDao().getLongId();
        
        gameH8.setArena(arenaH);
        gameH8.setHomeTeam(teamH3);
        gameH8.setAwayTeam(teamH1);
        gameH8.setRound(roundH4);
        gameH8.setDate(20180801);
        gameH8.getDao().save();
        gameHId5 = gameH8.getDao().getLongId();
        
        gameH9.setArena(arenaH);
        gameH9.setHomeTeam(teamH4);
        gameH9.setAwayTeam(teamH2);
        gameH9.setRound(roundH4);
        gameH9.setDate(20180702);
        gameH9.getDao().save();
        gameHId5 = gameH9.getDao().getLongId();
        
        gameH10.setArena(arenaH);
        gameH10.setHomeTeam(teamH5);
        gameH10.setAwayTeam(teamH3);
        gameH10.setRound(roundH4);
        gameH10.setDate(20180305);
        gameH10.getDao().save();
        gameHId5 = gameH10.getDao().getLongId();
        
        gameH11.setArena(arenaH);
        gameH11.setHomeTeam(teamH3);
        gameH11.setAwayTeam(teamH6);
        gameH11.setRound(roundH4);
        gameH11.setDate(20180515);
        gameH11.getDao().save();
        gameHId5 = gameH11.getDao().getLongId();
        
        
        gameH12.setArena(arenaH);
        gameH12.setHomeTeam(teamH6);
        gameH12.setAwayTeam(teamH2);
        gameH12.setRound(roundH4);
        gameH12.setDate(20180601);
        gameH12.getDao().save();
        gameHId5 = gameH12.getDao().getLongId();
        
        
        gameH13.setArena(arenaH);
        gameH13.setHomeTeam(teamH5);
        gameH13.setAwayTeam(teamH3);
        gameH13.setRound(roundH4);
        gameH13.setDate(20180704);
        gameH13.getDao().save();
        gameHId5 = gameH13.getDao().getLongId();
        
        
        gameH14.setArena(arenaH);
        gameH14.setHomeTeam(teamH4);
        gameH14.setAwayTeam(teamH5);
        gameH14.setRound(roundH4);
        gameH14.setDate(20180901);
        gameH14.getDao().save();
        gameHId5 = gameH14.getDao().getLongId();
        
        
        gameH15.setArena(arenaH);
        gameH15.setHomeTeam(teamH1);
        gameH15.setAwayTeam(teamH4);
        gameH15.setRound(roundH4);
        gameH15.setDate(20180903);
        gameH15.getDao().save();
        gameHId5 = gameH15.getDao().getLongId();
        

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
        
        try {
            result6.setHomeScore(43);
            result6.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        game6.setResult(result6);
        result6.setFullTime();
        result6.getDao().save();

        try {
            result7.setHomeScore(4);
            result7.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game7.setResult(result7);
        result7.setOverTime();
        result7.getDao().save();
        
        try {
            result8.setHomeScore(7);
            result8.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game8.setResult(result8);
        result8.setOverTime();
        result8.getDao().save();
        
        try{
            result9.setHomeScore(3);
            result9.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        game9.setResult(result9);
        result9.setFullTime();
        result9.getDao().save();
        
        try{
            result10.setHomeScore(8);
            result10.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        game10.setResult(result10);
        result10.setFullTime();
        result10.getDao().save();
        
        try {
            result11.setHomeScore(43);
            result11.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        game11.setResult(result11);
        result11.setFullTime();
        result11.getDao().save();

        try {
            result12.setHomeScore(4);
            result12.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game12.setResult(result12);
        result12.setOverTime();
        result12.getDao().save();
        
        try {
            result13.setHomeScore(7);
            result13.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        game13.setResult(result13);
        result13.setOverTime();
        result13.getDao().save();
        
        try{
            result14.setHomeScore(3);
            result14.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        game14.setResult(result14);
        result14.setFullTime();
        result14.getDao().save();
        
        try{
            result15.setHomeScore(8);
            result15.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        game15.setResult(result15);
        result15.setFullTime();
        result15.getDao().save();
        
        
        
        
        
        
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
        
        
        
        
        
        
        try {
            resultH1.setHomeScore(43);
            resultH1.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        gameH1.setResult(resultH1);
        resultH1.setFullTime();
        resultH1.getDao().save();

        try {
            resultH2.setHomeScore(4);
            resultH2.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH2.setResult(resultH2);
        resultH2.setOverTime();
        resultH2.getDao().save();
        
        try {
            resultH3.setHomeScore(7);
            resultH3.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH3.setResult(resultH3);
        resultH3.setOverTime();
        resultH3.getDao().save();
        
        try{
            resultH4.setHomeScore(3);
            resultH4.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        gameH4.setResult(resultH4);
        resultH4.setFullTime();
        resultH4.getDao().save();
        
        try{
            resultH5.setHomeScore(8);
            resultH5.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        gameH5.setResult(resultH5);
        resultH5.setFullTime();
        resultH5.getDao().save();
        
        try {
            resultH6.setHomeScore(43);
            resultH6.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        gameH6.setResult(resultH6);
        resultH6.setFullTime();
        resultH6.getDao().save();

        try {
            resultH7.setHomeScore(4);
            resultH7.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH7.setResult(resultH7);
        resultH7.setOverTime();
        resultH7.getDao().save();
        
        try {
            resultH8.setHomeScore(7);
            resultH8.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH8.setResult(resultH8);
        resultH8.setOverTime();
        resultH8.getDao().save();
        
        try{
            resultH9.setHomeScore(3);
            resultH9.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        gameH9.setResult(resultH9);
        resultH9.setFullTime();
        resultH9.getDao().save();
        
        try{
            resultH10.setHomeScore(8);
            resultH10.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        gameH10.setResult(resultH10);
        resultH10.setFullTime();
        resultH10.getDao().save();
        
        try {
            resultH11.setHomeScore(43);
            resultH11.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        gameH11.setResult(resultH11);
        resultH11.setFullTime();
        resultH11.getDao().save();

        try {
            resultH12.setHomeScore(4);
            resultH12.setAwayScore(5);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH12.setResult(resultH12);
        resultH12.setOverTime();
        resultH12.getDao().save();
        
        try {
            resultH13.setHomeScore(7);
            resultH13.setAwayScore(6);
        } catch (Exception ex) {
            ex.getMessage();
        }
        
        gameH13.setResult(resultH13);
        resultH13.setOverTime();
        resultH13.getDao().save();
        
        try{
            resultH14.setHomeScore(3);
            resultH14.setAwayScore(7);
        }catch(Exception e){
            e.getMessage();
        }
        gameH14.setResult(resultH14);
        resultH14.setFullTime();
        resultH14.getDao().save();
        
        try{
            resultH15.setHomeScore(8);
            resultH15.setAwayScore(2);
        }catch(Exception e){
            e.getMessage();
        }
        gameH15.setResult(resultH15);
        resultH15.setFullTime();
        resultH15.getDao().save();

        
        tTsH1 = new TeamsSeasonsDao();
        tTsH1.setSeason(season3);
        tTsH1.setTeam(teamH1);
        tTsH1.save();
        
        tTsH2 = new TeamsSeasonsDao();
        tTsH2.setSeason(season3);
        tTsH2.setTeam(teamH2);
        tTsH2.save();
        
        tTsH3 = new TeamsSeasonsDao();
        tTsH3.setSeason(season3);
        tTsH3.setTeam(teamH3);
        tTsH3.save();
        
        tTsH4 = new TeamsSeasonsDao();
        tTsH4.setSeason(season3);
        tTsH4.setTeam(teamH4);
        tTsH4.save();
        
        tTsH5 = new TeamsSeasonsDao();
        tTsH5.setSeason(season3);
        tTsH5.setTeam(teamH5);
        tTsH5.save();
        
        tTsH6 = new TeamsSeasonsDao();
        tTsH6.setSeason(season3);
        tTsH6.setTeam(teamH6);
        tTsH6.save();
        
        
        
        
        
        DbConn.staticClose();
      }
}


