/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.ArenaDao;
import DAO.GameDao;
import DAO.ResultDao;
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
public class GameTest {
    
    /**
     * Test of setName method, of class Game.
     */
    @Test
    public void testSetName() {
        GameDao dao = mock(GameDao.class);
        
        System.out.println("setName");
        String name = "testName";
        Game instance = new Game(dao);
        instance.setNumber(name);
        // TODO review the generated test code and remove the default call to fail.
       
    }

    /**
     * Test of getName method, of class Game.
     */
    @Test
    public void testGetName() {
        GameDao dao = mock(GameDao.class);
        when(dao.getString("name")).thenReturn("testName");
        
        System.out.println("getName");
        Game instance = new Game(dao);
        String expResult = "testName";
        String result = instance.getNumber();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of setResult method, of class Game.
     */
    @Test
    public void testSetResult() {
        GameDao dao = mock(GameDao.class);
        System.out.println("setResult");
        Result result_2 = new Result(mock(ResultDao.class));
        Game instance = new Game(dao);
        instance.setResult(result_2);
        // TODO review the generated test code and remove the default call to fail.
        
    }

    /**
     * Test of getResult method, of class Game.
     */
    @Test
    public void testGetResult() {
        GameDao dao = mock(GameDao.class);
        when(dao.parent(ResultDao.class)).thenReturn(mock(ResultDao.class));
        System.out.println("getResult");
        Game instance = new Game(dao);
        
        Result result = instance.getResult();
        
    }

    /**
     * Test of setHomeTeam method, of class Game.
     */
    @Test
    public void testSetHomeTeam() {
        GameDao dao = mock(GameDao.class);
        System.out.println("setHomeTeam");
        Team team = new Team(mock(TeamDao.class));
        Game instance = new Game(dao);
        instance.setHomeTeam(team);
    }

    /**
     * Test of setAwayTeam method, of class Game.
     */
    @Test
    public void testSetAwayTeam() {
        GameDao dao = mock(GameDao.class);
        System.out.println("setAwayTeam");
        Team team = new Team(mock(TeamDao.class));
        Game instance = new Game(dao);
        instance.setAwayTeam(team);
    }

    /**
     * Test of setArena method, of class Game.
     */
    @Test
    public void testSetArena() {
        GameDao dao = mock(GameDao.class);
        System.out.println("setArena");
        Arena arena = new Arena(mock(ArenaDao.class));
        Game instance = new Game(dao);
        instance.setArena(arena);
    }

    /**
     * Test of getArena method, of class Game.
     
    @Test
    public void testGetArena() {
        System.out.println("getArena");
        Game instance = new Game();
        Arena expResult = null;
        Arena result = instance.getArena();
        assertEquals(expResult, result);
    }
    */
}
