/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.GameBroker;
import Domain.Game;
import java.util.ArrayList;
import java.util.List;
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
public class GetAllGamesFromDateTest {
    private static Game game;
    private static Long date;
    private static BrokerFactory brokerFactory;
    private static GameBroker gameBroker;
    private static List<Game> listOfGames;
    
    public GetAllGamesFromDateTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        game = mock(Game.class);
        brokerFactory = mock(BrokerFactory.class);
        gameBroker = mock(GameBroker.class);
        listOfGames = new ArrayList<Game>();
        listOfGames.add(game);
        date = 12345678L;
        
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.findGamesByDate(date)).thenReturn(listOfGames);
    }
    
    @Test
    public void testConstructor(){
        try{
            new GetAllGamesFromDate(null);
            fail("borde faila");
        }catch(ServiceException e){
            e.getMessage();
        }
        try{
            new GetAllGamesFromDate(49234L);
            fail("tar emot ogiltigt datum");
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        GetAllGamesFromDate instance = new GetAllGamesFromDate(date);
        try{
            
            instance.init(null);
            fail("fail");
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    /**
     * Test of execute method, of class GetAllGamesFromDate.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllGamesFromDate instance = new GetAllGamesFromDate(date);
        instance.init(brokerFactory);  
        List<Game> result = instance.execute();
        assertEquals(1, result.size());
        
    }
}
