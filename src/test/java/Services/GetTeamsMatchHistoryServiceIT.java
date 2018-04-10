/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Arena;
import Domain.Game;
import Domain.League;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
import Domain.Team;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peeftw
 */
public class GetTeamsMatchHistoryServiceIT {

    public static DbConn conn;
    public static Sport sport;
    public static Game game;
    public static Arena arena;
    public static Team team;
    public static Team team1;
    public static Round round;
    public static Season season;
    public static Result result;
    public static League league;

    public static Long gameId;
    public static Long arenaId;
    public static Long teamId;
    public static Long team1Id;

    @BeforeClass
    public static void setUp() {
        DbConn.staticOpen();
        sport = new Sport();
        season = new Season();
        game = new Game();
        arena = new Arena();
        team = new Team();
        team1 = new Team();
        round = new Round();
        result = new Result();
        league = new League();

        sport.setName("SportTest2222222");
        sport.getDao().save();

        league.setSport(sport);
        league.setName("LeagueTest2222222");
        league.getDao().save();

        season.setSummer(Boolean.TRUE);
        season.setYear(1);
        league.addSeason(season);
        season.getDao().save();

        team.setName("TeamTest99999");
        team.setSport(sport);
        team.getDao().save();
        teamId = team.getDao().getLongId();

        team1.setName("Teamtest 88888");
        team1.setSport(sport);
        team1.getDao().save();
        team1Id = team1.getDao().getLongId();

        arena.getDao().save();
        arenaId = arena.getDao().getLongId();

        round.setRoundNumber(22);
        round.setSeason(season);
        round.getDao().save();

        game.setArena(arena);
        game.setAwayTeam(team);
        game.setHomeTeam(team1);
        game.setRound(round);
        game.getDao().save();
        gameId = game.getDao().getLongId();
    }

    @AfterClass
    public static void tearDown() {
        game.getDao().delete();
        round.getDao().delete();
        arena.getDao().delete();
        team.getDao().delete();
        team1.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        sport.getDao().delete();

        DbConn.staticClose();
    }

    @Test
    public void testExecute() {
        List<Game> listOfGames;
        GetTeamsMatchHistoryService instance = new GetTeamsMatchHistoryService(teamId, team1Id);
        instance.init(new BrokerFactory());
        listOfGames = instance.execute();
        System.out.println("MATCHES BETWEEN TEAMS: " + listOfGames);

    }
}
