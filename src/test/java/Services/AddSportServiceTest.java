/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SportBroker;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Sport;
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
public class AddSportServiceTest {
    private BrokerFactory brokerFactory;
    private SportBroker sportBroker;
    private Sport sport;
    @Before
    public void setUpMock() {
        brokerFactory = mock(BrokerFactory.class);
        sportBroker = mock(SportBroker.class);
        sport = mock(Sport.class);
        
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        when(sportBroker.create()).thenReturn(sport);
    }
    /**
     * Test constructor
     */
    @Test
    public void testConstructor(){
        try {
            new AddSportService("");
            fail();
        } catch (ServiceException e) {
            
        }
        try {
            new AddSportService(" ");
            fail();
        } catch (ServiceException e) {
            
        }
        try {
            new AddSportService(null);
            fail();
        } catch (ServiceException e) {
            
        }
        new AddSportService("Sport");
    }
    /**
     * Test of init method, of class AddSportService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        DbConn nullDbConn = null;
        BrokerFactory nullBrokerFactory = null;
        AddSportService instance = new AddSportService("Sport");
        
        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e){
            
        }
        instance.init(brokerFactory);
    }

    /**
     * Test of execute method, of class AddSportService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddSportService instance = new AddSportService("Sport");
        instance.init(brokerFactory);
        Sport expResult = sport;
        Sport result = instance.execute();
        assertEquals(expResult, result);
    }
    
}
