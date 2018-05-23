/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetGameResultInfoService;
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
 * @author Simon
 */
public class GetGameResultInfoServiceIT {
    private static Long gameId1;
    private static Long gameId2;
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
        gameId1 = SetUpTestObjects.getGameId1();
        gameId2 = SetUpTestObjects.getGameId2();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    @Test
    public void testExecute() {
        GetGameResultInfoService g1 = new GetGameResultInfoService(gameId1);
        g1.init(new BrokerFactory());
        System.out.println("Get GAME: " + g1.execute());
        
        GetGameResultInfoService g2 = new GetGameResultInfoService(gameId2);
        g2.init(new BrokerFactory());
        System.out.println("Get GAME: " + g2.execute());
    }
    
}
