/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.SportDao;
import DB.DbConn;
import Domain.League;
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
public class GetAllLeagueFromSportServiceIT {
    private static Sport sport;
    private static Sport sportTwo;
    private static Long sportId;
    private static Long sportTwoId;
    private static DbConn dbConn;
    private static BrokerFactory brokerFactory;
    private static League leagueOne;
    private static League leagueTwo;
    @BeforeClass
    public static void setUp () {
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("test");
        sport.getDao().save();
        sportId = sport.getDao().getLongId();
        
        sportTwo = new Sport();
        sportTwo.setName("testTwo");
        sportTwo.getDao().save();
        sportTwoId = sportTwo.getDao().getLongId();
        
        leagueOne = new League();
        leagueOne.setName("leagueOne");
        leagueOne.setSport(sportTwo);
        leagueOne.getDao().save();
        
        leagueTwo = new League();
        leagueTwo.setName("leagueTwo");
        leagueTwo.setSport(sportTwo);
        leagueTwo.getDao().save();
        
        dbConn = new DbConn();
        brokerFactory = new BrokerFactory();
        DbConn.staticClose();
    }
    @AfterClass
    public static void tearDown () {
        DbConn.staticOpen();
        leagueOne.getDao().delete();
        leagueTwo.getDao().delete();
        sport.getDao().delete();
        sportTwo.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testExecute () {
         DbConn.staticOpen();
        GetAllLeagueFromSportService instance = new GetAllLeagueFromSportService(sportId);
        instance.init(brokerFactory);
        List<League> result = instance.execute();
        assertNotNull(result);
        assertEquals(0, result.size());
        DbConn.staticClose();
    }
    @Test
    public void testTwoExecute () {
         DbConn.staticOpen();
        GetAllLeagueFromSportService instance = new GetAllLeagueFromSportService(sportTwoId);
        instance.init(brokerFactory);
        List<League> result = instance.execute();
        assertNotNull(result);
        assertEquals(2, result.size());
        DbConn.staticClose();
    }
    
}
