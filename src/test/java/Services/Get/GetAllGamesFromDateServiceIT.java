/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllGamesFromDateService;
import Broker.BrokerFactory;
import DAO.GameDao;
import DB.DbConn;
import Domain.Game;
import Services.SetUpTestObjects;
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
public class GetAllGamesFromDateServiceIT {
    private static DbConn conn;
    private static Long date;
    
    public GetAllGamesFromDateServiceIT() {
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
     * Test of execute method, of class GetAllGamesFromDateService.
     */
    @Test
    public void testExecute() {
        int date = 12345678;
        GameDao gd = GameDao.findById(SetUpTestObjects.getGameId1());
        Game game = new Game(gd);
        game.setDate(date);
        gd.save();
        GetAllGamesFromDateService service = new GetAllGamesFromDateService(date);
        service.init(new BrokerFactory());
        List<Game> log = service.execute();
        System.out.println("LISTA OF GAMES: " + log + " - " + log.size());
        assertEquals(1, log.size());
    }
    
}
