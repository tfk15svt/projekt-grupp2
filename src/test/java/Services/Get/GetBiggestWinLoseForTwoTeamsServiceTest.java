/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetBiggestWinLoseForTwoTeamsService;
import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.ResultBroker;
import DAO.GameDao;
import DAO.ResultDao;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import Services.ServiceException;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class GetBiggestWinLoseForTwoTeamsServiceTest {
    public static BrokerFactory brokerFactory;
    public static List<Game> listOfGames;
    public static Game game;
    public static Result result;
    public static ResultBroker resultBroker;
    public static Long team1Id = 1L;
    public static Long team2Id = 2L;
    public static Team homeTeam;
    public static Team awayTeam;
    public static GameDao gameDao;
    public static ResultDao resultDao;
    public static GameBroker gameBroker;
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        game = mock(Game.class);
        result = mock(Result.class);
        resultBroker = mock(ResultBroker.class);
        homeTeam = mock(Team.class);
        awayTeam = mock(Team.class);
        gameDao = mock(GameDao.class);
        resultDao = mock(ResultDao.class);
        gameBroker = mock(GameBroker.class);
        
        
        
        when(resultDao.parent(GameDao.class)).thenReturn(gameDao);
        when(brokerFactory.getResultBroker()).thenReturn(resultBroker);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.create(gameDao)).thenReturn(game);
        when(resultBroker.getBiggestDifferensBetweenTwoTeams(team1Id, team2Id)).thenReturn(result);
        when(game.getAwayTeam()).thenReturn(awayTeam);
        when(game.getHomeTeam()).thenReturn(homeTeam);
        when(game.getResult()).thenReturn(result);
        when(result.getDao()).thenReturn(resultDao);
        
        when(result.getHomeScore()).thenReturn(7);
        when(result.getAwayScore()).thenReturn(1);
        when(homeTeam.getName()).thenReturn("homeTeam");
        when(awayTeam.getName()).thenReturn("awayTeam");
        
        
        
        
    }

    @Test
    public void testConstructor() {
        try {
            new GetBiggestWinLoseForTwoTeamsService(team1Id, null);
            fail();

        } catch (ServiceException e) {

        }
        try {
            new GetBiggestWinLoseForTwoTeamsService(null, team2Id);
            fail();
        } catch (ServiceException e) {

        }
        new GetBiggestWinLoseForTwoTeamsService(team1Id, team2Id);
    }

    @Test
    public void testInit() {
        System.out.println("Testinit");
        GetBiggestWinLoseForTwoTeamsService instance = new GetBiggestWinLoseForTwoTeamsService(team1Id, team2Id);
        BrokerFactory nullBrokerFactory = null;

        try {
            instance.init(nullBrokerFactory);
            fail();
        } catch (ServiceException e) {

        }
        instance.init(brokerFactory);
    }

/**
 * Test of execute method, of class GetBiggestWinLoseForTwoTeamsService.
 */
        @Test
        public void testExecute() {
        System.out.println("execute");
        GetBiggestWinLoseForTwoTeamsService instance = new GetBiggestWinLoseForTwoTeamsService(1L, 2L);
        instance.init(brokerFactory);
        
        instance.execute();
        
        
    }
    
}
