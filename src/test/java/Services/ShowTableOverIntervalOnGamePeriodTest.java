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
public class ShowTableOverIntervalOnGamePeriodTest {
    private static int gamePeriod;
    private static int start;
    private static int end;
    private static BrokerFactory brokerFactory;
    
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        gamePeriod = 1;
        start = 7;
        end = 9;
    }
    
    @Test
    public void testContructor(){
        try{
            new ShowTableOverIntervalOnGamePeriod(null, start, end);
            new ShowTableOverIntervalOnGamePeriod(gamePeriod, null, end);
            new ShowTableOverIntervalOnGamePeriod(gamePeriod, start, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ShowTableOverIntervalOnGamePeriod instance = new ShowTableOverIntervalOnGamePeriod(gamePeriod, start, end);
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
