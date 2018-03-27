/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.GameDao;
import DAO.RoundDao;
import java.util.ArrayList;
import java.util.List;
import org.javalite.activejdbc.LazyList;
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
public class RoundTest {
    
    
    /**
     * Test of getGames method, of class Round.
     
    @Test
    public void testGetGames() {
        RoundDao dao = mock(RoundDao.class);
        when(dao.getAll(GameDao.class)).thenReturn(new LazyList<Game>());
        System.out.println("getGames");
        Round instance = new Round(dao);
        List<Game> expResult = new ArrayList<Game>();
        List<Game> result = instance.getGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    */
}
