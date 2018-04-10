package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Broker.BrokerFactory;
import DAO.ResultDao;
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
import java.text.SimpleDateFormat;
import java.util.Date;
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
    public static Game game;
    public static Round round;
    public static Arena arena;
    public static Team team1;
    public static Team team2;
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
        game = new Game();
        arena = new Arena();
        team1 = new Team();
        team2 = new Team();
        sport = new Sport();
        season = new Season();
        round = new Round();
        league = new League();
        
            
            sport.setName("Ishockey21");
            sport.getDao().save();
            
            
            league.setSport(sport);
            league.setName("SHL12");
            league.getDao().save();

            season.setSummer(Boolean.TRUE);
            season.setYear(1);
            
            league.addSeason(season);
            season.getDao().save();
            
            team1.setName("AIK12");
            team1.setSport(sport);
            team1.getDao().save();
            
            team2.setName("DIF12");
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
            game.setDate(20180410L);
            game.getDao().save();
            gameId = game.getDao().getLongId();
            
    }
    
    @AfterClass
    public static void tearDownClass() {
        game.getDao().getAll(ResultDao.class).get(0).delete();
        game.getDao().delete();
        round.getDao().delete();
        season.getDao().delete();
        league.getDao().delete();
        arena.getDao().delete();
        team1.getDao().delete();
        team2.getDao().delete();
        sport.getDao().delete();
        
        conn.close();
    }

    @Test
    public void testExecute() {
        
         AddResultToGameService add = new AddResultToGameService(5, 2,gameId );
         add.init(new BrokerFactory());
            System.out.println("ADD RESULT: " + add.execute());
        
    }
    
}
