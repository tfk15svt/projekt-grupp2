/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetBiggestLossForOneTeamService;
import Broker.BrokerFactory;
import Services.SetUpTestObjects;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author ntn13aae
 */
public class GetBiggestLossForOneTeamServiceIT {
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }

    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    /**
     * Test of execute method, of class GetBiggestWinLoseForTwoTeamsService.
     */
    @Test
    public void testExecute() {
        
        //TO-DO använda värden från SetUpTestObjects.java
        GetBiggestLossForOneTeamService gbw = new GetBiggestLossForOneTeamService(1L, 1, 5);
        gbw.init(new BrokerFactory());
        System.out.println("Biggest LOSS: " + gbw.execute());
    }
}
