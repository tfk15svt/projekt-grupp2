/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
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
public class ShowPercentOnArenaForOneSeasonIT {
    
    public ShowPercentOnArenaForOneSeasonIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    /**
     * Test of execute method, of class ShowPercentOnArenaForOneSeason.
     */
    @Test
    public void testExecute() {
        ShowPercentOnArenaForOneSeason s = new ShowPercentOnArenaForOneSeason(SetUpTestObjects.getSeasonId2(), SetUpTestObjects.getArenaId1());
        s.init(new BrokerFactory());
        System.out.println(s.execute());
    }
}
