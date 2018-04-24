package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.ResultBroker;
import DAO.ResultDao;
import DB.DbConn;
import Domain.Arena;
import Domain.Game;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
import Domain.Team;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Simon
 */
public class AddResultToGameServiceTest {
    public static Result result;
    public static Game game;
    private BrokerFactory brokerFactory;
    private GameBroker gameBroker;
    private ResultBroker resultBroker;
    private ResultDao resultDao;
    
    @Before
    public void setUpMockClasses(){
        game = mock(Game.class);
        result = mock(Result.class);
        try{
            result.setAwayScore(5);
            result.setHomeScore(7);
        }catch(Exception e){
            e.getMessage();
        }
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
        
    }
    /*
    * Test constructor
    */
    @Test
    public void testConstructor(){
        
        try {
            new AddResultToGameService(result.getHomeScore(), result.getAwayScore(), null);
            fail();
        } catch (ServiceException e){
     
        }
        try {
            new AddResultToGameService(-4, -2, 1L);
            fail();
        } catch (ServiceException e){
            
        }
        new AddResultToGameService(result.getHomeScore(), result.getAwayScore(), 1L);
    }
     /**
     * Test of init method, of class AddResultToGameService
     */
    @Test
    public void testInit() {
        System.out.println("init");
        BrokerFactory nullBrokerFactory = null;
        AddResultToGameService instance = new AddResultToGameService(result.getHomeScore(), result.getAwayScore(), 1L);
       
        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    /**
     * Test of execute method, of class AddResultToGameService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddResultToGameService instance = new AddResultToGameService(result.getHomeScore(), result.getAwayScore(), 1L);
        AddResultToGameService instance2 = new AddResultToGameService(result.getHomeScore(), result.getAwayScore(), 2L);
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
