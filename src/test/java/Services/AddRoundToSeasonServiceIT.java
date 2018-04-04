/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.GameDao;
import DAO.RoundDao;
import DB.DbConn;
import Domain.League;
import Domain.Season;
import Domain.Sport;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Veiret
 */
public class AddRoundToSeasonServiceIT {
    private static Sport sport;
    private static League league;
    private static Season season;
    private static Long seasonId;
    private static List<RoundDao> allRounds;
    private static List<GameDao> theTwoGames;
    private static List<GameDao> theFourGames;
    
    @BeforeClass
    public static void setUpClass() {
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("testAddRoundSport7");
        sport.getDao().save();
        
        league = new League();
        league.setName("testAddRoundLeague7");
        league.setSport(sport);
        league.getDao().save();
        
        season = new Season();
        season.setMaxRounds(3L);
        league.addSeason(season);
        season.getDao().save();
        seasonId = season.getId();
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        season.getDao().delete();
        league.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }

    /**
     * Test of execute method, of class AddRoundToSeasonService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddRoundToSeasonService serviceTwoRounds = new AddRoundToSeasonService(seasonId, 2L);
        serviceTwoRounds.init(new BrokerFactory());
        AddRoundToSeasonService serviceFourRounds = new AddRoundToSeasonService(seasonId, 4L);
        serviceFourRounds.init(new BrokerFactory());
        serviceTwoRounds.execute();
        serviceFourRounds.execute();
        
        allRounds = season.getDao().getAll(RoundDao.class);
        theTwoGames = allRounds.get(0).getAll(GameDao.class);
        theFourGames = allRounds.get(1).getAll(GameDao.class);
        assertEquals(allRounds.size(), 2);
        assertEquals(theTwoGames.size(), 2);
        assertEquals(theFourGames.size(), 4);
     for (GameDao game :theTwoGames){
            game.delete();
        }
        for (GameDao game :theFourGames){
            game.delete();
        }
        for (RoundDao round :allRounds){
            round.delete();
        }   
    }
    
}
