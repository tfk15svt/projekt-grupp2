/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SeasonBroker;
import Broker.TeamBroker;
import Broker.TeamSeasonBroker;
import DAO.TeamsSeasonsDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Season;
import com.mycompany.sportstatsveiret.Team;
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
public class ConnectTeamToSeasonServiceTest {
    private static BrokerFactory brokerFactory;
    private static TeamBroker teamBroker;
    private static SeasonBroker seasonBroker;
    private static TeamSeasonBroker teamSeasonBroker;
    private static TeamsSeasonsDao teamSeason;
    private static Team team;
    private static Season season;
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        teamBroker = mock(TeamBroker.class);
        seasonBroker = mock(SeasonBroker.class);
        teamSeasonBroker = mock(TeamSeasonBroker.class);
        teamSeason = mock(TeamsSeasonsDao.class);
        team = mock(Team.class);
        season = mock(Season.class);
        
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(brokerFactory.getTeamSeasonBroker()).thenReturn(teamSeasonBroker);
        when(teamBroker.findTeamById(1L)).thenReturn(team);
        when(seasonBroker.findSeasonById(1L)).thenReturn(season);
        when(teamSeasonBroker.create()).thenReturn(teamSeason);
        
    }
    @Test
    public void testConstructor () {
        try {
            new ConnectTeamToSeasonService(null, 1L);
            fail();
        } catch (ServiceException e) {
            
        }
        try {
            new ConnectTeamToSeasonService(1L, null);
            fail();
        } catch (ServiceException e) {
            
        }
        new ConnectTeamToSeasonService(1L, 1L);
    }
    /**
     * Test of init method, of class ConnectTeamToSeasonService.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        ConnectTeamToSeasonService instance = new ConnectTeamToSeasonService(1L, 1L);
        try {
            instance.init(null);
        } catch (ServiceException e){
            
        }
        instance.init(brokerFactory);
        
    }

    /**
     * Test of execute method, of class ConnectTeamToSeasonService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        ConnectTeamToSeasonService instance = new ConnectTeamToSeasonService(1L, 1L);
        instance.init(brokerFactory);
        ConnectTeamToSeasonService instance2 = new ConnectTeamToSeasonService(2L, 1L);
        instance2.init(brokerFactory);
        ConnectTeamToSeasonService instance3 = new ConnectTeamToSeasonService(1L, 2L);
        instance3.init(brokerFactory);
        try {
            instance2.execute();
            fail();
        } catch (ServiceException e){
            
        }
        try {
            instance3.execute();
            fail();
        } catch (ServiceException e){
            
        }
        instance.execute();
    }
    
}
