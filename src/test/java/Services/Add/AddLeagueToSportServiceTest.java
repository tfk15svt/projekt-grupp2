/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;

import Services.Add.AddLeagueToSportService;
import Broker.BrokerFactory;
import Broker.LeagueBroker;
import Broker.SportBroker;
import DB.DbConn;
import Domain.League;
import Domain.Sport;
import Services.ServiceException;
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
public class AddLeagueToSportServiceTest {
    private League league;
    private BrokerFactory brokerFactory;
    private SportBroker sportBroker;
    private LeagueBroker leagueBroker;
    private Sport sport;
    @Before
    public void setUpMockClasses(){
        league = mock(League.class);
        brokerFactory = mock(BrokerFactory.class);
        sportBroker = mock(SportBroker.class);
        leagueBroker = mock(LeagueBroker.class);
        sport = mock(Sport.class);
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(sportBroker.findById(1L)).thenReturn(sport);
        when(sportBroker.findById(2L)).thenReturn(null);
        when(leagueBroker.create()).thenReturn(league);
    }
    /**
     * Test constructor
     */
    @Test
    public void testConstructor(){
        Long nullSportId = null;
        Long notNullSportId = 1L;
        League nullLeague = null;
        
        try {
            new AddLeagueToSportService(nullSportId, "league");
            fail();
        } catch (ServiceException e){
            
        }
        try {
            new AddLeagueToSportService(notNullSportId, null);
            fail();
        } catch (ServiceException e){
            
        }
        new AddLeagueToSportService(notNullSportId, "league");
    }
    /**
     * Test of init method, of class AddLeagueToSportService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        BrokerFactory nullBrokerFactory = null;
        AddLeagueToSportService instance = new AddLeagueToSportService(1L, "league");
       
        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }

    /**
     * Test of execute method, of class AddLeagueToSportService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddLeagueToSportService instance = new AddLeagueToSportService(1L, "league");
        AddLeagueToSportService instance2 = new AddLeagueToSportService(2L, "league");
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
