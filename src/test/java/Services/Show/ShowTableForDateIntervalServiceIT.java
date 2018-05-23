/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowTableForDateIntervalService;
import Broker.BrokerFactory;
import Services.SetUpTestObjects;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Veiret
 */
public class ShowTableForDateIntervalServiceIT {

    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    /**
     * Test of execute method, of class ShowTableForDateIntervalService.
     */
    @Test
    public void testExecute() {
        ShowTableForDateIntervalService instance = new ShowTableForDateIntervalService(SetUpTestObjects.getLeagueId(), 1, 2);
        instance.init(new BrokerFactory());
        System.out.println(instance.execute());
        ShowTableForDateIntervalService instance2 = new ShowTableForDateIntervalService(SetUpTestObjects.getLeagueId(), 1, 3);
        instance2.init(new BrokerFactory());
        System.out.println(instance.execute());
        System.out.println(instance2.execute());
    }
    
}
