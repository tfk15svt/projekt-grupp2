/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.LeagueBroker;
import Broker.SeasonBroker;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;
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
public class AddSeasonToLeagueServiceTest {
    private DbConn dbConn;
    private BrokerFactory brokerFactory;
    private Season season;
    private League league;
    private LeagueBroker leagueBroker;
    private SeasonBroker seasonBroker;
    
    @Before
    public void setUpMock() {
        dbConn = mock(DbConn.class);
        brokerFactory = mock(BrokerFactory.class);
        season = mock(Season.class);
        league = mock(League.class);
        leagueBroker = mock(LeagueBroker.class);
        seasonBroker = mock(SeasonBroker.class);
        
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(leagueBroker.findLeagueById(1L)).thenReturn(league);
    }
    /**
     * Test constructor
     */
    @Test
    public void testConstructor() {
        Season nullSeason = null;
        Long nullLeagueId = null;
        try {
            new AddSeasonToLeagueService(nullSeason, 1L);
            fail();
        } catch (ServiceException e) {
            
        }
        try {
            new AddSeasonToLeagueService(season, nullLeagueId);
            fail();
        } catch (ServiceException e) {
            
        }
        new AddSeasonToLeagueService(season, 1L);
    }
    /**
     * Test of init method, of class AddSeasonToLeagueService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        DbConn nullDbConn = null;
        BrokerFactory nullBrokerFactory = null;
        AddSeasonToLeagueService instance = new AddSeasonToLeagueService(season, 1L);

        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e){
            
        }
        instance.init(brokerFactory);
    }

    /**
     * Test of execute method, of class AddSeasonToLeagueService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddSeasonToLeagueService instance = new AddSeasonToLeagueService(season, 1L);
        AddSeasonToLeagueService instance2 = new AddSeasonToLeagueService(season, 2L);
        instance.init(brokerFactory);
        instance2.init(brokerFactory);
        try {
            instance2.execute();
            fail();
        } catch (ServiceException e) {
            
        }
        instance.execute();
    }
    
}
