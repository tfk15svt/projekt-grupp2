/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

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
    private static Game game1;
    private static Game game2;
    private static Sport sport;
    private static Arena arena;
    private static Team team1;
    private static Team team2;
    private static Season season;
    private static Round round;
    private static League league;
    private static Long teamId1;
    private static Long teamId2;
    private static Long gameId1;
    private static Long gameId2;

    public static void setUp() {
        DbConn.staticOpen();
        result1 = new Result();
        result2 = new Result();
        game1 = new Game();
        game2 = new Game();
        arena = new Arena();
        team1 = new Team();
        team2 = new Team();
        sport = new Sport();
        season = new Season();
        round = new Round();
        league = new League();

        sport.setName("sporttest5512213");
        sport.getDao().save();

        league.setSport(sport);
        league.setName("leaguetest5512213");
        league.getDao().save();

        season.setSummer(Boolean.TRUE);
        season.setYear(1);

        league.addSeason(season);
        season.getDao().save();

        team1.setName("teamtest5512213");
        team1.setSport(sport);
        team1.getDao().save();

        team2.setName("teamtest55122134");
        team2.setSport(sport);
        team2.getDao().save();

        arena.getDao().save();

        round.setRoundNumber(22);
        round.setSeason(season);
        round.getDao().save();

        game1.setArena(arena);
        game1.setAwayTeam(team1);
        game1.setHomeTeam(team2);
        game1.setRound(round);

        game1.getDao().save();
        gameId1 = game1.getDao().getLongId();

        game2.setArena(arena);
        game2.setAwayTeam(team1);
        game2.setHomeTeam(team2);
        game2.setRound(round);

        game2.getDao().save();
        gameId2 = game2.getDao().getLongId();

        try {
            result1.setHomeScore(43);
            result1.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }
        game1.setResult(result1);
        result1.getDao().save();

        try {
            result2.setHomeScore(4);
            result2.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }

        game2.setResult(result2);
        result2.getDao().save();

    }

    public static void tearDown() {
        result1.getDao().delete();
        result2.getDao().delete();
        game1.getDao().delete();
        game2.getDao().delete();
        round.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        arena.getDao().delete();
        team1.getDao().delete();
        team2.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }

    public static Long getGameId1() {
        return gameId1;
    }

    public static Long getGameId2() {
        return gameId2;
    }

    public static Long getTeamId1() {
        teamId1 = team1.getDao().getLongId();
        return teamId1;
    }

    public static Long getTeamId2() {
        teamId2 = team2.getDao().getLongId();
        return teamId2;
    }
}
