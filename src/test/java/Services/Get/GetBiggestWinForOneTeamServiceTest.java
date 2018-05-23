package Services.Get;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Services.Get.GetBiggestWinForOneTeamService;
import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.LeagueBroker;
import Broker.TeamBroker;
import Domain.Game;
import Domain.Team;
import Services.ServiceException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
 * @author ntn13aae
 */
public class GetBiggestWinForOneTeamServiceTest {

    private static BrokerFactory brokerFactory;
    private static Team team;
    private static TeamBroker teamBroker;
    private static Integer startDate = 1;
    private static Integer endDate = 5;
    private static Game game;
    private static GameBroker gameBroker;
    private static LeagueBroker leagueBroker;
    private static List<Game> gameList;

    @BeforeClass
    public static void setUpClass() {
        team = mock(Team.class);
        teamBroker = mock(TeamBroker.class);
        brokerFactory = mock(BrokerFactory.class);
        game = mock(Game.class);
        gameBroker = mock(GameBroker.class);
        leagueBroker = mock(LeagueBroker.class);
        gameList = new ArrayList<Game>();
        gameList.add(game);
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.findTeamById(1L)).thenReturn(team);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.create()).thenReturn(game);
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
     
        //when(leagueBroker.getGamesWithinDateInterVal(1L, startDate, endDate)).thenReturn(gameList);
        
    }

    @Test
    public void testConstructor() {
        try {
            new GetBiggestWinForOneTeamService(null, startDate, endDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new GetBiggestWinForOneTeamService(1L, null, endDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new GetBiggestWinForOneTeamService(1L, startDate, null);
            fail();
        } catch (ServiceException e) {
        }
        new GetBiggestWinForOneTeamService(1L, startDate, endDate);
    }

    @Test
    public void testInit() {
        GetBiggestWinForOneTeamService service = new GetBiggestWinForOneTeamService(1L, startDate, endDate);
        try {
            service.init(brokerFactory);

        } catch (ServiceException e) {

        }
        service.init(brokerFactory);

    }

    @Test
    public void testExecute() {
        GetBiggestWinForOneTeamService service = new GetBiggestWinForOneTeamService(1L, startDate, endDate);
        service.init(brokerFactory);

        System.out.println("Get game: " + service.execute());
    }

}
