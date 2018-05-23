/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllGamesFromDateIntervalService;
import Broker.BrokerFactory;
import Domain.Game;
import Services.SetUpTestObjects;
import java.util.List;
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
public class GetAllGamesFromDateIntervalServiceIT {
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    /**
     * Test of execute method, of class GetAllGamesFromDateIntervalService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllGamesFromDateIntervalService instance = new GetAllGamesFromDateIntervalService(SetUpTestObjects.getLeagueId(), 2 , 3);
        instance.init(new BrokerFactory());
        List<Game> result = instance.execute();
        assertEquals(2, result.size());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
