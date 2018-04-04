/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SportBroker;
import DB.DbConn;
import Domain.League;
import Domain.Sport;
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
public class GetAllLeagueFromSportServiceTest {
    private static BrokerFactory brokerFactory;
    private static SportBroker sportBroker;
    private static League leagueOne;
    private static League leagueTwo;
    private static List<League> leagueList;
    private static Sport sport;
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        sportBroker = mock(SportBroker.class);
        leagueOne = mock(League.class);
        leagueTwo = mock(League.class);
        leagueList = new ArrayList<League>();
        leagueList.add(leagueOne);
        leagueList.add(leagueTwo);
        sport = mock(Sport.class);
        
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        when(sportBroker.getAllLeaguesFromSportId(1L)).thenReturn(leagueList);
        when(sportBroker.findById(1L)).thenReturn(sport);
    }
    @Test
    public void testConstructor() {
        try {
            new GetAllLeagueFromSportService(null);
            fail();
        } catch (ServiceException e) {
            
        }
        new GetAllLeagueFromSportService(1L);
    }
    @Test
    public void testInit() {
        GetAllLeagueFromSportService instance = new GetAllLeagueFromSportService(1L);
        try {
            instance.init(null);
            fail();
        } catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    /**
     * Test of execute method, of class GetAllLeagueFromSportService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllLeagueFromSportService instance = new GetAllLeagueFromSportService(1L);
        instance.init(brokerFactory);
        List<League> result = instance.execute();
        assertEquals(leagueList, result);
    }
    
}
