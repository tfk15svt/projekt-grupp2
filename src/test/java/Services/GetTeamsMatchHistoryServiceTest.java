/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.TeamBroker;
import Domain.Team;
import static org.junit.Assert.fail;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author slett
 */
public class GetTeamsMatchHistoryServiceTest {

    private static BrokerFactory brokerFactory;
    private static Team team;
    private static Team team2;
    private static TeamBroker teamBroker;

    @BeforeClass
    public static void setUpClass() {
        team = mock(Team.class);
        team2 = mock(Team.class);
        teamBroker = mock(TeamBroker.class);
        brokerFactory = mock(BrokerFactory.class);
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.findTeamById(1L)).thenReturn(team);
        when(teamBroker.findTeamById(2L)).thenReturn(team2);
    }

    @Test
    public void testConstructor() {
        try {
            new GetTeamsMatchHistoryService(null, null);
            fail();
        } catch (ServiceException e) {

        }
        new GetTeamsMatchHistoryService(1L, 2L);
    }

    @Test
    public void testInit() {
        GetTeamsMatchHistoryService service = new GetTeamsMatchHistoryService(1L, 2L);
        try {
            service.init(brokerFactory);

        } catch (ServiceException e) {

        }
        service.init(brokerFactory);

    }

    @Test
    public void testExecute() {
        GetTeamsMatchHistoryService service = new GetTeamsMatchHistoryService(1L, 2L);
        service.init(brokerFactory);

        System.out.println("Getting matches: " + service.execute());
    }
    
}