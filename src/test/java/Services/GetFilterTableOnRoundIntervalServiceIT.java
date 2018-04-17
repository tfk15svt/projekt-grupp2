/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
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
public class GetFilterTableOnRoundIntervalServiceIT {
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
        //DbConn.staticOpen();
        
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
        //DbConn.staticClose();
    }
    
    /**
     * Test of execute method, of class GetFilterTableOnRoundIntervalService.
     */
    @Test
    public void testExecute() {
        //GetFilterTableOnRoundIntervalService g = new GetFilterTableOnRoundIntervalService(0L, 1, 2);
        GetFilterTableOnRoundIntervalService g = new GetFilterTableOnRoundIntervalService(SetUpTestObjects.getSeasonId1(), 0, 1);
        g.init(new BrokerFactory());
        System.out.println("FILTERGAMES: " + "\n" + g.execute());
    }
}
