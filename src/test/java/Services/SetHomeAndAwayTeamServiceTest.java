/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.TeamBroker;
import DAO.TeamDao;
import Domain.Game;
import Domain.Team;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class SetHomeAndAwayTeamServiceTest {
    private static BrokerFactory brokerFactory;
    private static Team team1;
    private static Team team2;
    private static TeamDao teamDao;
    private static TeamBroker teamBroker;
    private static GameBroker gameBroker;

    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamDao = mock(TeamDao.class);
        teamBroker = mock(TeamBroker.class);
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Test
    public void testConstructor(){
        try{
            new SetHomeAndAwayTeamService(null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        SetHomeAndAwayTeamService s = new SetHomeAndAwayTeamService(34L, 35L);
        try{
            s.init(null);
            fail("faila");
        }catch(ServiceException e){
            e.getMessage();
        }
        s.init(brokerFactory);
    }

    /**
     * Test of execute method, of class SetHomeAndAwayTeamService.
     */
    @Test
    public void testExecute() {
        SetHomeAndAwayTeamService s1 = new SetHomeAndAwayTeamService(35L, 34L);
        SetHomeAndAwayTeamService s2 = new SetHomeAndAwayTeamService(35L, 34L);
        s1.init(brokerFactory);
        s2.init(brokerFactory);
        try{
            s2.execute();
        }catch(ServiceException e){
            e.getMessage();
            
        }
    }
}
