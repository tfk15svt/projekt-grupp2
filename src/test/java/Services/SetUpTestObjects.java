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

    private static Result result;
    private static Game game;
    private static Sport sport;
    private static Arena arena;
    private static Team team1;
    private static Team team2;
    private static Season season;
    private static Round round;
    private static League league;
    private static Long gameId;

    public static void setUp() {
        DbConn.staticOpen();
        result = new Result();
        game = new Game();
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

        game.setArena(arena);
        game.setAwayTeam(team1);
        game.setHomeTeam(team2);
        game.setRound(round);
        
        game.getDao().save();
        gameId = game.getDao().getLongId();

        try {
            result.setHomeScore(43);
            result.setAwayScore(3);
        } catch (Exception ex) {
            ex.getMessage();
        }

        result.getDao().save();

    }

    public static void tearDown() {
        result.getDao().delete();
        game.getDao().delete();
        round.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        arena.getDao().delete();
        team1.getDao().delete();
        team2.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    
    public static Long getGameId(){
        return gameId;
    }
}
