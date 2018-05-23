/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;

import Services.Add.AddSportService;
import Broker.BrokerFactory;
import DAO.SportDao;
import DB.DbConn;
import Domain.Sport;
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
    @BeforeClass
    public static void setUp() {
        DbConn.staticOpen();
    }
    @AfterClass
    public static void TearDown () {
        SportDao.find("name=?", "testAddSport").get(0).delete();
        DbConn.staticClose();
    }
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
           AddSportService service = new AddSportService("testAddSport");
           service.init(new BrokerFactory());
           service.execute();
        }catch(Exception e){
            e.getMessage();
        }
    }
    
}
