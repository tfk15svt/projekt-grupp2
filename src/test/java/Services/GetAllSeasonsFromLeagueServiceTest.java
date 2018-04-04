/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.LeagueBroker;
import DB.DbConn;
import Domain.League;
import Domain.Season;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Veiret
 */
public class GetAllSeasonsFromLeagueServiceTest {
    private static DbConn dbConn;
    private static BrokerFactory brokerFactory;
    private static LeagueBroker leagueBroker;
    private static Season seasonOne;
    private static Season seasonTwo;
    private static League league;
    private static List<Season> seasonList;
    @BeforeClass
    public static void setUpClass() {
        dbConn = mock(DbConn.class);
        brokerFactory = mock(BrokerFactory.class);
        leagueBroker = mock(LeagueBroker.class);
        seasonOne = mock(Season.class);
        seasonTwo = mock(Season.class);
        seasonList = new ArrayList<Season>();
        seasonList.add(seasonOne);
        seasonList.add(seasonTwo);
        league = mock(League.class);
        
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(leagueBroker.getAllSeasonsFromLeagueId(1L)).thenReturn(seasonList);
        when(leagueBroker.findLeagueById(1L)).thenReturn(league);
    }
    @Test
    public void testConstructor () {
        try {
            new GetAllSeasonsFromLeagueService(null);
            fail();
        } catch (ServiceException e) {
            
        }
        new GetAllSeasonsFromLeagueService(1L);
    }
    @Test
    public void testInit () {
        GetAllSeasonsFromLeagueService instance = new GetAllSeasonsFromLeagueService(1L);
        instance.init(brokerFactory);
    }
    /**
     * Test of execute method, of class GetAllSeasonsFromLeagueService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllSeasonsFromLeagueService instance = new GetAllSeasonsFromLeagueService(1L);
        instance.init(brokerFactory);
        GetAllSeasonsFromLeagueService instanceTwo = new GetAllSeasonsFromLeagueService(2L);
        instanceTwo.init(brokerFactory);
        try {
            instanceTwo.execute();
            fail();
        } catch (ServiceException e) {
            
        }
        List<Season> result = instance.execute();
        assertEquals(seasonList, result);
    }
    
}
