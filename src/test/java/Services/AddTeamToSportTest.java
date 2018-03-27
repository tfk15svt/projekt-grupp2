/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SportBroker;
import Broker.TeamBroker;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Sport;
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
public class AddTeamToSportTest {
    private Team team;
    private Sport sport;
    private BrokerFactory brokerFactory;
    private SportBroker sportBroker;
    private TeamBroker teamBroker;
    @Before
    public void setUp() {
        team = mock(Team.class);
        sport = mock(Sport.class);
        brokerFactory = mock(BrokerFactory.class);
        sportBroker = mock(SportBroker.class);
        teamBroker = mock(TeamBroker.class);
        
        when(brokerFactory.getSportBroker()).thenReturn(sportBroker);
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(sportBroker.findById(1L)).thenReturn(sport);
        when(teamBroker.create()).thenReturn(team);
    }

    @Test
    public void testConstructor() {
        try {
            new AddTeamToSport("", null);
            fail();
        } catch (ServiceException e) {
            
        }
        try {
            new AddTeamToSport(null, 1L);
            fail();
        } catch (ServiceException e) {
            
        }
        new AddTeamToSport("", 1L);
    }
    @Test
    public void testInit(){
        AddTeamToSport instance = new AddTeamToSport("", 1L);
        try {
            instance.init(null);
            fail();
        } catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    @Test
    public void testExcecute(){
        AddTeamToSport instance = new AddTeamToSport("", 1L);
        AddTeamToSport instance2 = new AddTeamToSport("", 2L);
        instance.init(brokerFactory);
        instance2.init(brokerFactory);
        
        try {
            instance2.execute();
            fail();
        } catch (ServiceException e) {
            
        }
        instance.execute();
    }
    
}
