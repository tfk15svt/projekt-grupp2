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
 * @author Simon
 */
public class GetFilterTableForHomeGamesServiceTest {
    private static Long seasonId;
    private static BrokerFactory brokerFactory;
    
    @BeforeClass
    public static void setUpClass() {
        seasonId = 1L;
        brokerFactory = mock(BrokerFactory.class);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testConstructor(){
        try{
            new GetFilterTableForHomeGamesService(null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        GetFilterTableForHomeGamesService instance = new GetFilterTableForHomeGamesService(seasonId);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        
        
    }
    
}
