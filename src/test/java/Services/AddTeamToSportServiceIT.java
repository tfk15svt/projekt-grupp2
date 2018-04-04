/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.SportDao;
import DAO.TeamDao;
import DB.DbConn;
import Domain.Sport;
import Domain.Team;
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
public class AddTeamToSportServiceIT {
    private static Sport sport;
    private static Long sportId;
    private static Team team;
    @BeforeClass
    public static void setUp() {
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("SportAddTeamToNewSport");
        sport.getDao().save();
        sportId = sport.getDao().getLongId();
        
        //team = new Team();
        //team.setName("TeamAddTeamToNewSport");
        DbConn.staticClose();
    }
    /**
     * Test of execute method, of class AddTeamToSportService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        AddTeamToSportService instance = new AddTeamToSportService("TeamAddTeamToNewSport", sportId);
        instance.init(new BrokerFactory());
        DbConn.staticOpen();
        instance.execute();
        //Long sportIdFromTeam = team.getDao().parent(SportDao.class).getLongId();
        //assertEquals(sportIdFromTeam, sportId);
        DbConn.staticClose();
    }
    
    @AfterClass
    public static void tearDown() {
        DbConn.staticOpen();
        TeamDao teamDao = (TeamDao) TeamDao.find("name=?", "TeamAddTeamToNewSport").get(0);
        teamDao.delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    
}
