/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Sport;
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
public class AddSportServiceIT {

    @Test
    public void testExecute() {
        /**AddSportService instance = new AddSportService("TestAddSportService");
        instance.init(new BrokerFactory());
        Sport sport = instance.execute();
        assertNotNull(sport);
        DbConn.staticOpen();
        sport.getDao().delete();
        DbConn.staticClose();*/
        try{
           ServiceRunner runner = new ServiceRunner(new AddSportService(null));
            System.out.println("ADD SPORT: " + runner.execute());
        }catch(Exception e){
            e.getMessage();
        }
    }
    
}
