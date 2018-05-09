/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Veiret
 */
public class ShowTableWithDynamicFiltersServiceIT {
    private static List<Long> seasonIds;
    private static int[] dates;
    
    
    @BeforeClass
    public static void setUpClass() {
        dates = new int[2];
        dates[0] = 1;
        dates[1] = 2;
        seasonIds = new ArrayList<>();
        SetUpTestObjects.setUp();
        seasonIds.add(SetUpTestObjects.getSeasonId1());
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    /**
     * Test of execute method, of class ShowTableWithDynamicFiltersService.
     */
    @Test
    public void testExecute() {
        ShowTableWithDynamicFiltersService instance1 = new ShowTableWithDynamicFiltersService(seasonIds);
        instance1.init(new BrokerFactory());
        System.out.println("Instance1: " + "\n" + instance1.execute());
        
        ShowTableWithDynamicFiltersService instance2 = new ShowTableWithDynamicFiltersService(seasonIds,dates, true);
        instance2.init(new BrokerFactory());
        System.out.println("Instance2: " + "\n" + instance2.execute());
    }
}
