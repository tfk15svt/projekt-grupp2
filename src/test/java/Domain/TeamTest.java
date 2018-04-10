/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.Team;
import DAO.TeamDao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Veiret
 */
public class TeamTest {
    
    /**
     * Test of getName method, of class Team.
     */
    @Test
    public void testGetName() {
        TeamDao dao = mock(TeamDao.class);
        when(dao.getString("name")).thenReturn("testName");
        
        System.out.println("getName");
        Team instance = new Team(dao);
        String expResult = "testName";
        String result = instance.getName();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setString method, of class Team.
     */
    @Test
    public void testSetString() {
        TeamDao dao = mock(TeamDao.class);
        
        System.out.println("setString");
        String name = "";
        Team instance = new Team(dao);
        instance.setName(name);
        
    }
    
}
