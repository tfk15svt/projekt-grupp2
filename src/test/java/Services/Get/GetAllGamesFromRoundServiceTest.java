/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllGamesFromRoundService;
import Broker.BrokerFactory;
import Broker.RoundBroker;
import Domain.Game;
import Domain.League;
import Domain.Round;
import Services.ServiceException;
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
 * @author Peeftw
 */
public class GetAllGamesFromRoundServiceTest {
    private static BrokerFactory brokerFactory;
    private static RoundBroker roundBroker;
    private static List<Game> gameList;
    private static Game gameOne;
    private static Round round;
    
    public GetAllGamesFromRoundServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        roundBroker = mock(RoundBroker.class);
        round = mock(Round.class);
        
        gameOne = mock(Game.class);
        gameList = new ArrayList<Game>();
        gameList.add(gameOne);
        
        when(brokerFactory.getRoundBroker()).thenReturn(roundBroker);
        when(roundBroker.getAllGamesByRoundId(1L)).thenReturn(gameList);
        when(roundBroker.findById(1L)).thenReturn(round);
    }
    
    @Test
    public void testConstructor(){
        try {
            new GetAllGamesFromRoundService(null);
            fail();
            
        } catch (ServiceException e){
            
        } 
        new GetAllGamesFromRoundService(1L);
    }
  
    @Test
    public void testInit(){
        GetAllGamesFromRoundService instance = new GetAllGamesFromRoundService(1L);
        try {
            instance.init(null);
            fail();
           
        }catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    
    @Test
    public void testExecute() {
        System.out.println("execute test: ");
        GetAllGamesFromRoundService instance = new GetAllGamesFromRoundService(1L);
        instance.init(brokerFactory);
        List<Game> lista = instance.execute();
        assertEquals(gameList, lista);
        
              
    }
    
}
