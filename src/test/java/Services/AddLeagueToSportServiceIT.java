/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.LeagueDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Sport;
import java.util.List;
import java.util.stream.Collectors;
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
public class AddLeagueToSportServiceIT {
    public static Sport sport;
    public static League league;
    public static Long sportId;
    @BeforeClass
    public static void setUp(){
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("addLeagueToSportServiceTest");
        sport.getDao().save();
        sportId = sport.getDao().getLongId();
    }
    @AfterClass
    public static void tearDown(){
        //Delete the test objects
        sport.getDao().getAll(LeagueDao.class).get(0).delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testExecute() {
        //
        AddLeagueToSportService instance = new AddLeagueToSportService(sportId,"theLeagueServiceTest");
        instance.init(new BrokerFactory());
        instance.execute();
        
        List<League> list = sport.getDao().getAll(LeagueDao.class).stream()
                .map(leagueDao -> new League((LeagueDao) leagueDao))
                .collect(Collectors.toList());        
        int expectedListSize = 1;
        int listSize = list.size();
        
        assertEquals(expectedListSize, listSize);
    }
    
}
