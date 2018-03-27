/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.ResultDao;
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
public class ResultTest {

    /**
     * Test of setHomeScore method, of class Result.
     */
    @Test
    public void testSetHomeScore() {
        ResultDao dao = mock(ResultDao.class);
        
        System.out.println("setHomeScore");
        Integer score = null;
        Result instance = new Result(dao);
        try {
            instance.setHomeScore(5);
        } catch (Exception e){
            fail();
        }
        try {
            instance.setHomeScore(score);
            fail();
        } catch (Exception e) {
            System.out.println("passed setHomeScore crash if null");
        }
        
        
    }

    /**
     * Test of setAwayScore method, of class Result.
     */
    @Test
    public void testSetAwayScore() {
        ResultDao dao = mock(ResultDao.class);
        
        System.out.println("setAwayScore");
        Integer score = null;
        Result instance = new Result(dao);
        
        try {
            instance.setAwayScore(score);
            fail();
        } catch (Exception e){
            
        }
        
        try {
            instance.setAwayScore(5);
        } catch (Exception e){
            fail();
        }
      
    }

    /**
     * Test of getHomeScore method, of class Result.
     */
    @Test
    public void testGetHomeScore() {
        ResultDao dao =  mock(ResultDao.class);
        when(dao.getInteger("homeScore")).thenReturn(5);
                
        System.out.println("getHomeScore");
        Result instance = new Result(dao);
        Integer expResult = 5;
        Integer result = instance.getHomeScore();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getAwayScore method, of class Result.
     */
    @Test
    public void testGetAwayScore() {
        ResultDao dao =  mock(ResultDao.class);
        when(dao.getInteger("awayScore")).thenReturn(5);
                
        System.out.println("getAwayScore");
        Result instance = new Result(dao);
        Integer expResult = 5;
        Integer result = instance.getAwayScore();
        assertEquals(expResult, result);
        
        
    }
    
}
