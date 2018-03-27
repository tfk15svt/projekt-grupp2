/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.LeagueDao;
import DAO.SeasonDao;
import java.util.List;
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
public class LeagueTest {
    
    

    /**
     * Test of getName method, of class League.
     */
    @Test
    public void testGetName() {
        LeagueDao dao = mock(LeagueDao.class);
        when(dao.getString("name")).thenReturn("hej");
        
        
        System.out.println("getName");
        League instance = new League(dao);
        String expResult = "hej";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.

    }

   
    
}
