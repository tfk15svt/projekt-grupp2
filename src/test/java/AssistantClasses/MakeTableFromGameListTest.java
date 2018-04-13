/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AssistantClasses;

import Broker.BrokerFactory;
import Broker.SeasonBroker;
import Broker.ServiceBroker;
import DAO.TeamDao;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import Services.GetAllGamesFromSeasonService;
import Services.ServiceException;
import Services.ServiceRunner;
import java.util.ArrayList;
import java.util.List;
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
public class MakeTableFromGameListTest {
    
    private static BrokerFactory brokerFactory;
    private static String[] row1;
    private static String teamName1;
    private static int fullTimeWins1;
    private static int losses1;
    private static int tied1;
    private static int overTimeWins1;
    private static int overTimeLosses1;
    private static int scoredGoals1;
    private static int opponentScore1;
    private static int points1;
    private static String[] row2;
    private static String teamName2;
    private static int fullTimeWins2;
    private static int tied2;
    private static int overTimeWins2;
    private static int overTimeLosses2;
    private static int losses2;
    private static int scoredGoals2;
    private static int opponentScore2;
    private static int points2;
    
    private static Team team1;
    private static Team team2;
    private static TeamDao teamDao1;
    private static TeamDao teamDao2;
    private static Game game1;
    private static Game game2;
    private static SeasonBroker seasonBroker;
    private static Result result1;
    private static Result result2;
    private static ServiceRunner serviceRunner;
    private static ServiceBroker serviceBroker;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonService;
    
    private static List<Game> games;
    private static List<Team> teams;
    
    
    @BeforeClass
    public static void setUpClass() {
             
        brokerFactory = mock(BrokerFactory.class);
        getAllGamesFromSeasonService = mock(GetAllGamesFromSeasonService.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamDao1 = mock(TeamDao.class);
        teamDao2 = mock(TeamDao.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        seasonBroker = mock(SeasonBroker.class);
        result1 = mock(Result.class);
        result2 = mock(Result.class);
        serviceRunner = mock(ServiceRunner.class);
        serviceBroker = mock(ServiceBroker.class);
        
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        fullTimeWins1 = 1;
        losses1 = 0;
        tied1 = 1;
        overTimeWins1 = 1;
        overTimeLosses1 = 0;
        scoredGoals1 = 7;
        opponentScore1 = 1;
        points1 = 5;
        row1 = new String[7] ;
        row2 = new String[7] ;
        fullTimeWins2 = 0;
        tied2 = 1;
        overTimeWins2 = 0;
        overTimeLosses2 = 1;
        losses2 = 1;
        scoredGoals2 = 1;
        opponentScore2 = 7;
        points2 = 1;
        
        games = new ArrayList<Game>();
        games.add(game1);
        games.add(game2);
        teams = new ArrayList<Team>();
        teams.add(team1);
        teams.add(team2);
        
        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(getAllGamesFromSeasonService.execute()).thenReturn(games);
        when(team1.getDao()).thenReturn(teamDao1);
        when(team2.getDao()).thenReturn(teamDao2);
        when(team1.getName()).thenReturn(teamName1);
        when(team2.getName()).thenReturn(teamName2);
        when(teamDao1.getLongId()).thenReturn(1L);
        when(teamDao2.getLongId()).thenReturn(2L);
        when(game1.getResult()).thenReturn(result1);
        when(game2.getResult()).thenReturn(result2);
        when(result1.getAwayScore()).thenReturn(0);
        when(result1.getHomeScore()).thenReturn(5);
        when(result2.getAwayScore()).thenReturn(2);
        when(result2.getHomeScore()).thenReturn(1);
        when(result1.getFullTime()).thenReturn(true);
        when(result2.getFullTime()).thenReturn(false);
        when(result1.getOverTime()).thenReturn(false);
        when(result2.getOverTime()).thenReturn(true);
        when(result1.getShotOut()).thenReturn(false);
        when(result2.getShotOut()).thenReturn(false);
        when(game1.getHomeTeam()).thenReturn(team1);
        when(game1.getAwayTeam()).thenReturn(team2);
        when(game2.getHomeTeam()).thenReturn(team2);
        when(game2.getAwayTeam()).thenReturn(team1);
        
        row1 = new String[7];
        row1[0] = teamName1;
        row1[1] = " GP: " + (fullTimeWins1 + losses1 + tied1);
        row1[2] = " W: " + (fullTimeWins1);
        row1[3] = " T: " + (tied1);
        row1[4] = " L: " + losses1;
        row1[5] = " " + scoredGoals1 + " - " + opponentScore1 + " ";
        row1[6] = points1 + "p";

        row2 = new String[7];
        row2[0] = teamName2;
        row2[1] = " GP: " + (fullTimeWins2 + losses2 + tied2);
        row2[2] = " W: " + (fullTimeWins2);
        row2[3] = " T: " + (tied2);
        row2[4] = " L: " + losses2;
        row2[5] = " " + scoredGoals2 + " - " + opponentScore2 + " ";
        row2[6] = points2 + "p";
    }

    @Test
    public void testConstructor() {
        try {
            new MakeTableFromGameList( games, null);
            fail();
        } catch (ServiceException e) {

        }
         try {
            new MakeTableFromGameList(null, teams);
            fail();
        } catch (ServiceException e) {

        }
        new MakeTableFromGameList(games, teams);
    }


    @Test
    public void testExecute() {
        System.out.println("execute");
        MakeTableFromGameList instance = new MakeTableFromGameList(games, teams);
        String expResult = 
                row1[0] + row1[1] + row1[2] + row1[3] + row1[4] + row1[5] + row1[6] + "\n" +
                row2[0] + row2[1] + row2[2] + row2[3] + row2[4] + row2[5] + row2[6] + "\n";
        String reString = instance.execute();
        assertEquals(expResult, reString);
    }

}
