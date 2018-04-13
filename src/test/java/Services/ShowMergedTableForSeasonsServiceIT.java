/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import java.util.ArrayList;
import java.util.List;
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
public class ShowMergedTableForSeasonsServiceIT {
    
    private static List<Long> seasonIds;
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
        seasonIds = new ArrayList<Long>();
        seasonIds.add(SetUpTestObjects.getSeasonId1());
        seasonIds.add(SetUpTestObjects.getSeasonId2());
    }
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    
    @Test
    public void testExecute() {
        ShowMergedTableForSeasonsService instance = new ShowMergedTableForSeasonsService(seasonIds);
        instance.init(new BrokerFactory());
        System.out.println("hejhejhkeh \n" + instance.execute());
    }
    
}
