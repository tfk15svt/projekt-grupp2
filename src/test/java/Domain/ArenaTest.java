/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.Arena;
import DAO.ArenaDao;
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
public class ArenaTest {
        

    /**
     * Test of getName method, of class Arena.
     */
    @Test
    public void testGetName() {
        ArenaDao dao = mock(ArenaDao.class);
        when(dao.getString("name")).thenReturn("Testnamn");
        System.out.println("getName");
        Arena instance = new Arena(dao);
        String expResult = "Testnamn";
        String result = instance.getArenaName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getTeam method, of class Arena.
     
    @Test
    public void testGetTeam() {
        System.out.println("getTeam");
        Arena instance = new Arena();
        Team expResult = null;
        Team result = instance.getTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTeam method, of class Arena.
     
    @Test
    public void testSetTeam() {
        ArenaDao dao = mock(ArenaDao.class);
        System.out.println("setTeam");
        Team team = null;
        Arena instance = new Arena(dao);
        instance.setTeam(team);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    * */
    
}
