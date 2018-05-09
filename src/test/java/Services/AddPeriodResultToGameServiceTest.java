/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.ResultBroker;
import DAO.ResultDao;
import Domain.Game;
import Domain.Result;
import static Services.AddResultToGameServiceTest.game;
import static Services.AddResultToGameServiceTest.result;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.stubbing.OngoingStubbing;

/**
 *
 * @author slett
 */
public class AddPeriodResultToGameServiceTest {
    public static Result result;
    public static Game game;
    private BrokerFactory brokerFactory;
    private GameBroker gameBroker;
    private ResultBroker resultBroker;
    private ResultDao resultDao;
    Integer homeScores[] = new Integer[2];
    Integer awayScores[] = new Integer[2];
    
     @Before
    public void setUpMockClasses(){
        game = mock(Game.class);
        result = mock(Result.class);
        brokerFactory = mock(BrokerFactory.class);
        gameBroker = mock(GameBroker.class);
        resultBroker = mock(ResultBroker.class);
        resultDao = mock(ResultDao.class);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(brokerFactory.getResultBroker()).thenReturn(resultBroker);
        when(resultBroker.create()).thenReturn(result);
        when(result.getDao()).thenReturn(resultDao);
        when(gameBroker.findById(1L)).thenReturn(game);
        when(gameBroker.findById(2L)).thenReturn(null);
        homeScores = new Integer[] {1, 2};
        awayScores = new Integer[] {1, 2};
    }
    
     /*
    * Test constructor
    */
    @Test
    public void testConstructor(){
        homeScores = new Integer[] {null, 1};
        awayScores = new Integer[] {null, 2};
        
        try {
            new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
            fail();
        } catch (ServiceException e){
            Logger.getLogger("Should not allow null");
        }
        homeScores = new Integer[] {1, 2};
        awayScores = new Integer[] {1, 2};
        
        try {
            new AddPeriodResultsToGameService(homeScores, awayScores, null);
            fail();
        } catch (ServiceException e){
            Logger.getLogger("Should not allow null");
        }
        
        new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
    }
    
    @Test
    public void testInit() {
        System.out.println("init");
        BrokerFactory nullBrokerFactory = null;
        AddPeriodResultsToGameService instance = new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
       
        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddPeriodResultsToGameService instance = new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
        AddPeriodResultsToGameService instance2 = new AddPeriodResultsToGameService(homeScores, awayScores, 2L);
        instance.init(brokerFactory);
        instance2.init(brokerFactory);
        try {
            instance2.execute();
            fail();
        } catch (ServiceException e) {
            
        }
        instance.execute();
    }
    @Test
    public void testScoreString() {
        AddPeriodResultsToGameService instance = new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
        String testString = "1:1-2:2";
        instance.init(brokerFactory);
    //    assertEquals(instance.execute().getScore(), testString);
        result = instance.execute();
        
        homeScores = new Integer[] {1, 2, 5, 7, 8, 0};
        awayScores = new Integer[] {1, 2, 3, 2, 1, 2};
        
        String testString2 = "1:1-2:2-5:3-7:2-8:1-0:2";
        AddPeriodResultsToGameService instance2 = new AddPeriodResultsToGameService(homeScores, awayScores, 1L);
        instance2.init(brokerFactory);
//        assertEquals(instance2.execute().getScore(), testString2);
//        
//        assertNotEquals(instance.execute().getScore(), testString2);
        System.out.println(instance2.execute().getScore() + "teststring2: " + testString2);
        System.out.println(instance.execute().getScore() + "teststring: " + testString);
    }
}
