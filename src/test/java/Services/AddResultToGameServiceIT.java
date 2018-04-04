package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.DbConn;
import Domain.Arena;
import Domain.Game;
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
        

        
        try {

            season.setSummer(Boolean.TRUE);
            season.setYear(1);
            season.getDao().save();

            sport.setName("testSport");
            sport.getDao().save();

            team.setName("testTeam");
            team.setSport(sport);
            team.getDao().save();

            arena.setTeam(team);
            arena.getDao().save();
            
            round.setRoundNumber(1);
            round.setSeason(season);
            round.getDao().save();
            
            result.setHomeScore(4);
            result.setAwayScore(3);
            result.getDao().save();
            
            game.setResult(result);
            game.setArena(arena);
            game.setAwayTeam(team);
            game.setHomeTeam(team);
            game.setName("testGame");
            game.setRound(round);
            game.getDao().save();
            
            
            
        } catch (Exception ex) {
            ex.getMessage();
        }
    }
    
    @AfterClass
    public static void tearDownClass() {
        game.getDao().delete();
        result.getDao().delete();
        round.getDao().delete();
        arena.getDao().delete();
        team.getDao().delete();
        sport.getDao().delete();
        season.getDao().delete();
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
        Long gameId = 1L;
        //System.out.println("Game: " + game.getResult());
        try{
        ServiceRunner runner = new ServiceRunner(new AddResultToGameService(result, gameId));
        runner.execute();
        }catch(Exception e){
            e.getMessage();
        }
        
    }
    
}
