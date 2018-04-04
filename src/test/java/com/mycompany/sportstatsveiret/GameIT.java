/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import java.util.Date;
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
public class GameIT {
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Game instance = new Game();
        instance.setNumber(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Game.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Game instance = new Game();
        String expResult = "";
        String result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setResult method, of class Game.
     */
    @Test
    public void testSetResult() {
        System.out.println("setResult");
        Result result_2 = null;
        Game instance = new Game();
        instance.setResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getResult method, of class Game.
     */
    @Test
    public void testGetResult() {
        System.out.println("getResult");
        Game instance = new Game();
        Result expResult = null;
        Result result = instance.getResult();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setHomeTeam method, of class Game.
     */
    @Test
    public void testSetHomeTeam() {
        System.out.println("setHomeTeam");
        Team team = null;
        Game instance = new Game();
        instance.setHomeTeam(team);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAwayTeam method, of class Game.
     */
    @Test
    public void testSetAwayTeam() {
        System.out.println("setAwayTeam");
        Team team = null;
        Game instance = new Game();
        instance.setAwayTeam(team);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHomeTeam method, of class Game.
     */
    @Test
    public void testGetHomeTeam() {
        System.out.println("getHomeTeam");
        Game instance = new Game();
        Team expResult = null;
        Team result = instance.getHomeTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAwayTeam method, of class Game.
     */
    @Test
    public void testGetAwayTeam() {
        System.out.println("getAwayTeam");
        Game instance = new Game();
        Team expResult = null;
        Team result = instance.getAwayTeam();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setArena method, of class Game.
     */
    @Test
    public void testSetArena() {
        System.out.println("setArena");
        Arena arena = null;
        Game instance = new Game();
        instance.setArena(arena);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getArena method, of class Game.
     */
    @Test
    public void testGetArena() {
        System.out.println("getArena");
        Game instance = new Game();
        Arena expResult = null;
        Arena result = instance.getArena();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Game.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Game instance = new Game();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Game.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Game instance = new Game();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
