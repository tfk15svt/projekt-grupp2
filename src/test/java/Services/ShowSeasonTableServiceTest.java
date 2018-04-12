/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Veiret
 */
public class ShowSeasonTableServiceTest {
    private static Long seasonId;
    private static BrokerFactory brokerFactory;
    
    @BeforeClass
    public static void setUpClass() {
        seasonId = 1L;
        brokerFactory = mock(BrokerFactory.class);
    }
    
    @Test
    public void testConstructor(){
        try {
            new ShowSeasonTableService(null);
        } catch (ServiceException e) {
            
        }
        new ShowSeasonTableService(seasonId);
    }
    @Test
    public void testInit(){
        ShowSeasonTableService instance = new ShowSeasonTableService(seasonId);
        try {
            instance.init(null);
        } catch (ServiceException e) {
        }
        instance.init(brokerFactory);
    }
    @Test
    public void testExecute() {
        System.out.println("execute");
        ShowSeasonTableService instance = new ShowSeasonTableService(seasonId);
        instance.init(brokerFactory);
        //String expResult = 
        //assertEquals(expResult, instance.execute());
    }
    
}
