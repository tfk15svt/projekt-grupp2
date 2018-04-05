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
import static Services.AddResultToGameServiceIT.arena;
import static Services.AddResultToGameServiceIT.conn;
import static Services.AddResultToGameServiceIT.game;
import static Services.AddResultToGameServiceIT.gameId;
import static Services.AddResultToGameServiceIT.league;
import static Services.AddResultToGameServiceIT.result;
import static Services.AddResultToGameServiceIT.round;
import static Services.AddResultToGameServiceIT.season;
import static Services.AddResultToGameServiceIT.sport;
import static Services.AddResultToGameServiceIT.team;
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
public class AddMetaInfoToGameServiceIT {
    public static DbConn conn;
    public static Sport sport;
    public static Game game;
    public static Arena arena;
    public static Team team;
    public static Round round;
    public static Season season;
    public static Result result;
    public static League league;
    public static Long gameId;
    public static Long arenaId;
    
    
    public AddMetaInfoToGameServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @BeforeClass
    public static void setUp() {
        conn = new DbConn();
        conn.open();
        sport = new Sport();
        season = new Season();
        game = new Game();
        arena = new Arena();
        team = new Team();
        round = new Round();
        result = new Result();
        league = new League();
        
        
        sport.setName("SportTest12");
        sport.getDao().save();
            
            
        league.setSport(sport);
        league.setName("LeagueTest12");
        league.getDao().save();

        season.setSummer(Boolean.TRUE);
        season.setYear(1);
        league.addSeason(season);
        season.getDao().save();
            
        team.setName("TeamTest12");
        team.setSport(sport);
        team.getDao().save();

        arena.getDao().save();
        arenaId = arena.getDao().getLongId();
            
        round.setRoundNumber(22);
        round.setSeason(season);
        round.getDao().save();
            
           
        game.setArena(arena);
        game.setAwayTeam(team);
        game.setHomeTeam(team);
        game.setRound(round);
        game.getDao().save();
        gameId = game.getDao().getLongId();
    }
    
    @AfterClass
    public static void tearDown() {
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

    @Test
    public void testSomeMethod() {
        
        System.out.println("HEJ");
        try{
            AddMetaInfoToGameService service = new AddMetaInfoToGameService(gameId, arenaId, 5005);
            service.init(new BrokerFactory());
            System.out.println("DÅ");
            System.out.println("SPECTATORS: " + service.execute());
            System.out.println("YYYYYY");
        }catch(Exception e){
            e.getMessage();
        }
    } 
}
