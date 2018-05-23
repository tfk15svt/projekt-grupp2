/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowMergedTableForSeasonsService;
import Services.Get.GetAllGamesFromSeasonService;
import AssistantClasses.FakeTableRowForJsonTests;
import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;
import Broker.SeasonBroker;
import Broker.ServiceBroker;
import Broker.TeamBroker;
import DAO.TeamDao;
import Domain.Game;
import Domain.Result;
import Domain.Team;
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
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class ShowMergedTableForSeasonsServiceTest {
    private static BrokerFactory brokerFactory;
    private static TeamBroker teamBroker;
    private static List<Long> seasonIds;
    private static FakeTableRowForJsonTests row1;
    private static FakeTableRowForJsonTests row2;
    private static Long seasonId;
    private static String teamName1;
    private static int fullTimeWins1;
    private static int losses1;
    private static int tied1;
    private static int overTimeWins1;
    private static int overTimeLosses1;
    private static int scoredGoals1;
    private static int opponentScore1;
    private static int points1;
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
    private static Game game3;
    private static SeasonBroker seasonBroker;
    private static Result result1;
    private static Result result2;
    private static Result result3;
    private static ServiceRunner serviceRunner;
    private static ServiceBroker serviceBroker;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonService1;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonService2;
    private static List<FakeTableRowForJsonTests> expList;
    private static List<Game> allSeasonGames1;
    private static List<Team> allSeasonTeams1;
    private static List<Game> allSeasonGames2;
    private static List<Team> allSeasonTeams2;
    private static long teamId1;
    private static long teamId2;
    
    @BeforeClass
    public static void setUpClass() {
        seasonIds = new ArrayList<Long>();
        seasonIds.add(1L);
        seasonIds.add(2L);
        brokerFactory = mock(BrokerFactory.class);
        teamId1 = 1L;
        teamId2 = 2L;
        seasonId = 1L;
        brokerFactory = mock(BrokerFactory.class);
        getAllGamesFromSeasonService1 = mock(GetAllGamesFromSeasonService.class);
        getAllGamesFromSeasonService2 = mock(GetAllGamesFromSeasonService.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamDao1 = mock(TeamDao.class);
        teamDao2 = mock(TeamDao.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        seasonBroker = mock(SeasonBroker.class);
        result1 = mock(Result.class);
        result2 = mock(Result.class);
        result3 = mock(Result.class);
        serviceRunner = mock(ServiceRunner.class);
        serviceBroker = mock(ServiceBroker.class);
        teamBroker = mock(TeamBroker.class);
        
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        fullTimeWins1 = 2;
        losses1 = 0;
        tied1 = 1;
        overTimeWins1 = 1;
        overTimeLosses1 = 0;
        scoredGoals1 = 15;
        opponentScore1 = 7;
        points1 = 8;
        fullTimeWins2 = 0;
        tied2 = 1;
        overTimeWins2 = 0;
        overTimeLosses2 = 1;
        losses2 = 2;
        scoredGoals2 = 7;
        opponentScore2 = 15;
        points2 = 1;
        
        allSeasonGames1 = new ArrayList<Game>();
        allSeasonGames1.add(game1);
        allSeasonGames1.add(game2);
        allSeasonTeams1 = new ArrayList<Team>();
        allSeasonTeams1.add(team1);
        allSeasonTeams1.add(team2);
        
        allSeasonGames2 = new ArrayList<Game>();
        allSeasonGames2.add(game3);
        allSeasonTeams2 = new ArrayList<Team>();
        allSeasonTeams2.add(team1);
        allSeasonTeams2.add(team2);
        
        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(serviceBroker.getAllGamesFromSeasonService(seasonIds.get(0))).thenReturn(getAllGamesFromSeasonService1);
        when(serviceBroker.getAllGamesFromSeasonService(seasonIds.get(1))).thenReturn(getAllGamesFromSeasonService2);
        when(getAllGamesFromSeasonService1.execute()).thenReturn(allSeasonGames1);
        when(getAllGamesFromSeasonService2.execute()).thenReturn(allSeasonGames2);
        when(seasonBroker.getAllTeamsFromSeasonId(seasonIds.get(0))).thenReturn(allSeasonTeams1);
        when(seasonBroker.getAllTeamsFromSeasonId(seasonIds.get(1))).thenReturn(allSeasonTeams2);
        when(seasonBroker.seasonExists(seasonIds.get(0))).thenReturn(true);
        when(seasonBroker.seasonExists(seasonIds.get(1))).thenReturn(true);
        when(seasonBroker.seasonExists(999L)).thenReturn(false);
        when(teamBroker.findTeamById(teamId1)).thenReturn(team1);
        when(teamBroker.findTeamById(teamId2)).thenReturn(team2);
        when(team1.getDao()).thenReturn(teamDao1);
        when(team2.getDao()).thenReturn(teamDao2);
        when(teamDao1.getId()).thenReturn(teamId1);
        when(teamDao1.getLongId()).thenReturn(teamId1);
        when(teamDao2.getId()).thenReturn(teamId2);
        when(teamDao2.getLongId()).thenReturn(teamId2);
        when(team1.getId()).thenReturn(teamId1);
        when(team2.getId()).thenReturn(teamId2);
        when(team1.getName()).thenReturn(teamName1);
        when(team2.getName()).thenReturn(teamName2);
        when(game1.getResult()).thenReturn(result1);
        when(game2.getResult()).thenReturn(result2);
        when(game3.getResult()).thenReturn(result3);
        when(result1.getAwayScore()).thenReturn(0);
        when(result1.getHomeScore()).thenReturn(5);
        when(result2.getAwayScore()).thenReturn(2);
        when(result2.getHomeScore()).thenReturn(1);
        when(result3.getHomeScore()).thenReturn(8);
        when(result3.getAwayScore()).thenReturn(6);
        
        when(result3.getFullTime()).thenReturn(true);
        when(result3.getOverTime()).thenReturn(false);
        when(result3.getShotOut()).thenReturn(false);
        
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
        when(game3.getHomeTeam()).thenReturn(team1);
        when(game3.getAwayTeam()).thenReturn(team2);
        
        row1 = new FakeTableRowForJsonTests();
        row2 = new FakeTableRowForJsonTests();
        row1.setFullTimeWins(fullTimeWins1);
        row1.setGamesPlayed(fullTimeWins1 + losses1 + tied1);
        row1.setLosses(losses1);
        row1.setOpponentScore(opponentScore1);
        row1.setPoints(points1);
        row1.setScoredGoals(scoredGoals1);
        row1.setTeamname(teamName1);
        row1.setTied(tied1);
        row2.setFullTimeWins(fullTimeWins2);
        row2.setGamesPlayed(fullTimeWins2 + losses2 + tied2);
        row2.setLosses(losses2);
        row2.setOpponentScore(opponentScore2);
        row2.setPoints(points2);
        row2.setScoredGoals(scoredGoals2);
        row2.setTeamname(teamName2);
        row2.setTied(tied2);
        
        expList = new ArrayList<>();
        expList.add(row1);
        expList.add(row2);
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testConstructor(){
        try{
            new ShowMergedTableForSeasonsService(null);
            fail("fail");
        }catch(ServiceException e){
            e.getMessage();
        }
        new ShowMergedTableForSeasonsService(seasonIds);
    }
    
    @Test
    public void testInit(){
        ShowMergedTableForSeasonsService instance = new ShowMergedTableForSeasonsService(seasonIds);
        try{
            instance.init(null);
            fail("init fail");
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        ShowMergedTableForSeasonsService instance = new ShowMergedTableForSeasonsService(seasonIds);
        instance.init(brokerFactory);
        String expResult = JsonOutputformat.create(expList);        
        String reString = JsonOutputformat.create(instance.execute());
        assertTrue(expResult.equals(reString));
    }
    
}
