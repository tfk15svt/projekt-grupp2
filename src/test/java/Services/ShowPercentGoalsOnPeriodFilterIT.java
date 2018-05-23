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
public class ShowPercentGoalsOnPeriodFilterIT {
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    @Test
    public void testExecute() {
        ShowPercentGoalsOnPeriodFilter s = new ShowPercentGoalsOnPeriodFilter(SetUpTestObjects.getSeasonId2(), 20190432, 20190433);
        s.init(new BrokerFactory());
        System.out.println("PERCENT: " + s.execute());
    }
}
