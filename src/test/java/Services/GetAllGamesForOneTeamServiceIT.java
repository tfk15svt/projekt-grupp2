package Services;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class GetAllGamesForOneTeamServiceIT {
    public static DbConn conn;
    
    
    public GetAllGamesForOneTeamServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        conn = new DbConn();
        conn.open();
        
        
        
    }
    
    @After
    public void tearDown() {
        
        conn.close();
    }

    @Test
    public void testSomeMethod() {
        List<Game> listOfGames;
        GetAllGamesForOneTeamService instance = new GetAllGamesForOneTeamService(2L);
        listOfGames = instance.execute();
        System.out.println("LIST OF GAMES: " + listOfGames);
        
    }
    
}
