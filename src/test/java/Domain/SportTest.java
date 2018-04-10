/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import Domain.Sport;
import DAO.SportDao;
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
public class SportTest {
    
    /**
     * Test of getName method, of class Sport.
     */
    @Test
    public void testGetName() {
        SportDao dao = mock(SportDao.class);
        when(dao.getString("name")).thenReturn("TestName");
        
        System.out.println("getName");
        Sport instance = new Sport(dao);
        String expResult = "TestName";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setName method, of class Sport.
     */
    @Test
    public void testSetName() {
        SportDao dao = mock(SportDao.class);
        
        
        System.out.println("setName");
        String name = "";
        Sport instance = new Sport(dao);
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
