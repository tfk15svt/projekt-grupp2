/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.GameDao;
import Domain.Game;
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
public class SetHomeAndAwayTeamServiceIT {
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    /**
     * Test of execute method, of class SetHomeAndAwayTeamService.
     */
    @Test
    public void testExecute() {
        SetHomeAndAwayTeamService s = new SetHomeAndAwayTeamService(38L, 39L);
        s.init(new BrokerFactory());
        System.out.println("SetHomeAndAwayTeam: " + s.execute());
    }
    
}
