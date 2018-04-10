/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.GameDao;
import DB.DbConn;
import Domain.Game;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class GetAllGamesFromDateIT {
    private static DbConn conn;
    private static Long date;
    
    public GetAllGamesFromDateIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of execute method, of class GetAllGamesFromDate.
     */
    @Test
    public void testExecute() {
        Long date = 1234567L;
        GameDao gd = GameDao.findById(SetUpTestObjects.getGameId());
        Game game = new Game(gd);
        game.setDate(date);
        gd.save();
        GetAllGamesFromDate service = new GetAllGamesFromDate(date);
        service.init(new BrokerFactory());
        List<Game> log = service.execute();
        System.out.println("LISTA OF GAMES: " + log + " - " + log.size());
        assertEquals(1, log.size());
    }
    
}
