package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Broker.ArenaBroker;
import Broker.BrokerFactory;
import Broker.GameBroker;
import DAO.GameDao;
import Domain.Arena;
import Domain.Game;
import Services.AddMetaInfoToGameService;
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
public class AddMetaInfoToGameServiceTest {
    public static Game game;
    public static Arena arena;
    private BrokerFactory brokerFactory;
    private GameBroker gameBroker;
    private ArenaBroker arenaBroker;
    private GameDao gameDao;
    public AddMetaInfoToGameServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        gameDao = mock(GameDao.class);
        game = mock(Game.class);
        arena = mock(Arena.class);
        brokerFactory = mock(BrokerFactory.class);
        gameBroker = mock(GameBroker.class);
        arenaBroker = mock(ArenaBroker.class);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(brokerFactory.getArenaBroker()).thenReturn(arenaBroker);
        when(game.getDao()).thenReturn(gameDao);
        when(gameBroker.findById(2L)).thenReturn(game);
        when(arenaBroker.findById(3L)).thenReturn(arena);
        
        
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class AddMetaInfoToGameService.
     */
    @Test
    public void testConstructor() {
        System.out.println("testConstructor");
        try{
           new AddMetaInfoToGameService(2L, 3L, 5000);
           new AddMetaInfoToGameService(2L, 3L, 0);
           //fail();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        System.out.println("Init");
        BrokerFactory nullBrokerFactory = null;
        AddMetaInfoToGameService instance = new AddMetaInfoToGameService(2L, 3L, 7000);
        
        try{
            instance.init(nullBrokerFactory);
            fail();
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }
    
    @Test
    public void testExecute(){
        System.out.println("Execute");
        AddMetaInfoToGameService instance1 = new AddMetaInfoToGameService(2L, 3L, 0);
        instance1.init(brokerFactory);
        
        try{
            instance1.execute();
            
        }catch(ServiceException e){
            e.getMessage();
        }
        
    }
    
}
