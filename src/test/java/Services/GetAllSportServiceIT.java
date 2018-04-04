/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Sport;
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
public class GetAllSportServiceIT {
    private static BrokerFactory brokerFactory;
    @BeforeClass
    public static void setUp() {
        brokerFactory = new BrokerFactory();
    }
    @Test
    public void testExecute() {
        
        DbConn.staticOpen();
        System.out.println("execute");
        GetAllSportService instance = new GetAllSportService();
        instance.init(brokerFactory);
        List<Sport> result = instance.execute();
        assertNotEquals(null, result);
        System.out.println("Sporten: " + result.size());
        DbConn.staticClose();
        
    }
    
}
