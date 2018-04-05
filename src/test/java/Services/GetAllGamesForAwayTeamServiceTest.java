package Services;



import Broker.BrokerFactory;
import Broker.TeamBroker;
import Domain.Team;
import Services.GetAllGamesForOneTeamService;
import Services.ServiceException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class GetAllGamesForAwayTeamServiceTest {

    private static BrokerFactory brokerFactory;
    private static Team team;
    private static TeamBroker teamBroker;

    @BeforeClass
    public static void setUpClass() {
        team = mock(Team.class);
        teamBroker = mock(TeamBroker.class);
        brokerFactory = mock(BrokerFactory.class);
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.findTeamById(1L)).thenReturn(team);
    }

    @Test
    public void testConstructor() {
        try {
            new GetAllGamesForAwayTeamService(null);
            fail();
        } catch (ServiceException e) {

        }
        new GetAllGamesForAwayTeamService(1L);
    }

    @Test
    public void testInit() {
        GetAllGamesForAwayTeamService service = new GetAllGamesForAwayTeamService(1L);
        try {
            service.init(brokerFactory);

        } catch (ServiceException e) {

        }
        service.init(brokerFactory);

    }

    @Test
    public void testExecute() {
        GetAllGamesForAwayTeamService service = new GetAllGamesForAwayTeamService(1L);
        service.init(brokerFactory);

        System.out.println("Get games: " + service.execute());
    }
    
}
