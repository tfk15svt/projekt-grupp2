/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldTests;

import Broker.BrokerFactory;
import DAO.SportDao;
import DB.DbConn;
import oldServices.AddTeamToNewSportService;
import com.mycompany.sportstatsveiret.Sport;
import com.mycompany.sportstatsveiret.Team;
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
public class AddTeamToNewSportServiceIT {
    
    @Test
    public void testExecute() {
        
        DbConn.staticOpen();
        Team existingSport = new Team();
        existingSport.setName("existingSport");
        Team notExistingSport = new Team();
        notExistingSport.setName("notExistingSport");
        Sport sport = new Sport();
        sport.setName("sportE");
        sport.getDao().save();
        DbConn.staticClose();
        AddTeamToNewSportService instanceExisting = new AddTeamToNewSportService(existingSport, new String("sportE"));
        instanceExisting.init(new DbConn(), new BrokerFactory());
        instanceExisting.execute();
        AddTeamToNewSportService instanceNotExisting = new AddTeamToNewSportService(notExistingSport,new String("SportNE"));
        instanceNotExisting.init(new DbConn(),new BrokerFactory());
        instanceNotExisting.execute();
        DbConn.staticOpen();
        Sport newSport = new Sport(notExistingSport.getDao().parent(SportDao.class));
        //Sport oldSport = new Sport(existingSport.getDao().parent(SportDao.class));
        //System.out.println(existingSport.getDao().getId());
        //System.out.println(notExistingSport.getDao().getId());
        //System.out.println(newSport.getDao().getId());
        //System.out.println(oldSport.getDao().getId());
        existingSport.getDao().delete();
        notExistingSport.getDao().delete();
        sport.getDao().delete();
        newSport.getDao().delete();
        //oldSport.getDao().delete();
        DbConn.staticClose();
    }
    
}
