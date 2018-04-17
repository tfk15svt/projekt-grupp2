/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.ServiceBroker;
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
public class GetFilterTableOnRoundIntervalServiceTest {
    public static BrokerFactory brokerFactory;
    private static Long seasonId;
    private static int startRound;
    private static int endRound;
    private static ServiceBroker serviceBroker;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonService;
    
    @BeforeClass
    public static void setUpClass() {
        seasonId = 0L;
        endRound = 1;
        startRound = 2;
        brokerFactory = mock(BrokerFactory.class);
        getAllGamesFromSeasonService = mock(GetAllGamesFromSeasonService.class);
        
        //when(serviceBroker.getAllGamesFromSeasonService(seasonId)).thenReturn(getAllGamesFromSeasonService);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test 
    public void testConstructor(){
        try{
            new GetFilterTableOnRoundIntervalService(null, 0, 0);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        GetFilterTableOnRoundIntervalService instance = new GetFilterTableOnRoundIntervalService(seasonId, startRound, endRound);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    /**
     * Test of execute method, of class GetFilterTableOnRoundIntervalService.
     */
    @Test
    public void testExecute() {
        System.out.println("Execute");
        GetFilterTableOnRoundIntervalService instance = new GetFilterTableOnRoundIntervalService(seasonId, startRound, endRound);
        instance.init(brokerFactory);
        //System.out.println("Execute.instance: " + instance.execute());


                
    } 
}
