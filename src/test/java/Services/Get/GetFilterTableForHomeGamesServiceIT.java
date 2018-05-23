/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetFilterTableForHomeGamesService;
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
public class GetFilterTableForHomeGamesServiceIT {
   
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    @Test
    public void testSomeMethod() {
        GetFilterTableForHomeGamesService instance = new GetFilterTableForHomeGamesService(SetUpTestObjects.getSeasonId1());
        instance.init(new BrokerFactory());
        System.out.println("Home table: " + "\n" + instance.execute());
    }
}
