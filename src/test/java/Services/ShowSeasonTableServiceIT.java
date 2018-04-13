/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import oldServices.ShowSeasonTableOldService;
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
public class ShowSeasonTableServiceIT {
    
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
        ShowSeasonTableService instance = new ShowSeasonTableService(SetUpTestObjects.getSeasonId());
        instance.init(new BrokerFactory());
        System.out.println("hejhejhkeh \n" + instance.execute());
    }
    
}
