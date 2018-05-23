/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllSeasonsFromLeagueService;
import Broker.BrokerFactory;
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
public class GetAllSeasonsFromLeagueServiceIT {
    private static Sport sport;
    private static League league;
    private static Season season;
    private static Long seasonId;
    private static Long leagueId;
    private static DbConn dbConn;
    private static BrokerFactory brokerFactory;
    @BeforeClass
    public static void setUp(){
        // Create test objects
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("testSport");
        sport.getDao().save();
        league = new League();
        league.setName("name");
        league.setSport(sport);
        league.getDao().save();
        leagueId = league.getDao().getLongId();
        season = new Season();
        league.addSeason(season);
        season.getDao().save();
        seasonId = season.getDao().getLongId();
        DbConn.staticClose();
        dbConn = new DbConn();
        brokerFactory = new BrokerFactory();
    }
    @AfterClass
    public static void tearDown() {
        // Remove test objects
        DbConn.staticOpen();
        season.getDao().delete();
        league.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testExecute() {
         DbConn.staticOpen();
        GetAllSeasonsFromLeagueService instance = new GetAllSeasonsFromLeagueService(leagueId);
        instance.init(brokerFactory);
        List<Season> list = instance.execute();
        assertEquals(1, list.size());
        assertEquals(seasonId, list.get(0).getDao().getLongId());
        DbConn.staticClose();
    }
}
