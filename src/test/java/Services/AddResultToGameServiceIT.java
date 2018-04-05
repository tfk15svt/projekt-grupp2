package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import Services.ServiceRunner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class AddResultToGameServiceIT {
    public static DbConn conn;
    public static Result result;
    public static Game game;
    public static Round round;
    public static Arena arena;
    public static Team team;
    public static Sport sport;
    public static Season season;
    public static League league;
    public static Long gameId;
    public AddResultToGameServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        conn = new DbConn();
        conn.open();
        result = new Result();
        game = new Game();
        arena = new Arena();
        team = new Team();
        sport = new Sport();
        season = new Season();
        round = new Round();
        league = new League();
            
            sport.setName("sporttest");
            sport.getDao().save();
            
            
            league.setSport(sport);
            league.setName("leaguetest");
            league.getDao().save();

            season.setSummer(Boolean.TRUE);
            season.setYear(1);
            
            league.addSeason(season);
            season.getDao().save();
            
            team.setName("teamtest");
            team.setSport(sport);
            team.getDao().save();

            arena.getDao().save();
            
            round.setRoundNumber(22);
            round.setSeason(season);
            round.getDao().save();
            
           
            game.setArena(arena);
            game.setAwayTeam(team);
            game.setHomeTeam(team);
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
    
    @AfterClass
    public static void tearDownClass() {
        result.getDao().delete();
        game.getDao().delete();
        round.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        arena.getDao().delete();
        team.getDao().delete();
        sport.getDao().delete();
        
        conn.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testExecute() {
        
         AddResultToGameService add = new AddResultToGameService(result,gameId );
         add.init(new BrokerFactory());
            System.out.println("ADD RESULT: " + add.execute());
        
    }
    
}
