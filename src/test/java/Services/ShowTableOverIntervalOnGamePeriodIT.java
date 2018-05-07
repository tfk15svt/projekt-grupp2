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
public class ShowTableOverIntervalOnGamePeriodIT {
    
    private static int start;
    private static int end;
    private static int gamePeriod;
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
        start = 7;
        end = 9;
        gamePeriod = 1;
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    @Test
    public void testExecute() {
        ShowTableOverIntervalOnGamePeriod instance = new ShowTableOverIntervalOnGamePeriod(gamePeriod, start, end);
        instance.init(new BrokerFactory());
        System.out.println("Show table on interval: " + "\n" + instance.execute());
        
    }
    
}
