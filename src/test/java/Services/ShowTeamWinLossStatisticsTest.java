/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.SeasonBroker;
import Broker.ServiceBroker;
import Broker.TeamBroker;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import static org.mockito.Mockito.*;

/**
 *
 * @author Veiret
 */
public class ShowTeamWinLossStatisticsTest {
// Att göra: skriv om villkor till array. Testa home/away, båda får inte vara false, lägg till delresultat

    private static List<Long> teamIds, seasonIds;
    private static BrokerFactory brokerFactory;
    private static TeamBroker teamBroker;
    private static SeasonBroker seasonBroker;
    private static GameBroker gameBroker;
    private static ServiceBroker serviceBroker;
    private static List<Game> listOfGames;
    private static List<Game> listOfGames2;
    private static long teamId1;
    private static long teamId2;
    private static Team team1, team2;
    private static Game game1, game2, game3, game4;
    private static long gameId1, gameId2, gameId3, gameId4;
    private static long seasonId1;
    private static List<Team> listOfTeams1;
    private static List<Game> seasonOneListOfGames;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonOne;
    private static Result result1, result2, result3, result4;
    private static List<String> table1, table2, table3, table4, table5, table6, table7;
    private static TableRow table1Team1, table1Team2, table2Team1, table2Team2, table3Team1, table3Team2,
    table4Team1, table4Team2, table5Team1, table5Team2, table6Team1, table6Team2, table7Team1, table7Team2;
    
    
    @BeforeClass
    public static void setUpClass() {
        result1 = mock(Result.class);
        result2 = mock(Result.class);
        result3 = mock(Result.class);
        result4 = mock(Result.class);

        getAllGamesFromSeasonOne = mock(GetAllGamesFromSeasonService.class);
        seasonId1 = 1;
        seasonOneListOfGames = new ArrayList<>();
        
        listOfTeams1 = new ArrayList<>();
        
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        game4 = mock(Game.class);
        seasonOneListOfGames.add(game1);
        seasonOneListOfGames.add(game2);
        seasonOneListOfGames.add(game3);
        seasonOneListOfGames.add(game4);
        
        listOfTeams1.add(team1);
        listOfTeams1.add(team2);
        
        teamIds = new ArrayList<>();
        teamId1 = 1L;
        teamId2 = 2L;
        gameId1 = 1L;
        gameId2 = 2L;
        gameId3 = 3L;
        gameId4 = 4L;
        teamIds.add(1L);
        teamIds.add(2L);
        seasonIds = new ArrayList<>();
        seasonIds.add(seasonId1);
        listOfGames = new ArrayList<>();
        listOfGames.add(game1);
        listOfGames.add(game2);
        listOfGames.add(game3);
        listOfGames.add(game4);
        brokerFactory = mock(BrokerFactory.class);
        teamBroker = mock(TeamBroker.class);
        seasonBroker = mock(SeasonBroker.class);
        serviceBroker = mock(ServiceBroker.class);
        gameBroker = mock(GameBroker.class);
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(teamBroker.getAllGamesForOneTeam(teamId1)).thenReturn(listOfGames);
        when(teamBroker.getAllGamesForOneTeam(teamId2)).thenReturn(listOfGames);
        when(teamBroker.findTeamById(teamId1)).thenReturn(team1);
        when(teamBroker.findTeamById(teamId2)).thenReturn(team2);
        when(gameBroker.findById(gameId1)).thenReturn(game1);
        when(gameBroker.findById(gameId2)).thenReturn(game2);
        when(gameBroker.findById(gameId3)).thenReturn(game3);
        when(gameBroker.findById(gameId4)).thenReturn(game4);
        when(seasonBroker.getAllTeamsFromSeasonId(seasonId1)).thenReturn(listOfTeams1);
        when(serviceBroker.getAllGamesFromSeasonService(seasonId1)).thenReturn(getAllGamesFromSeasonOne);
        when(getAllGamesFromSeasonOne.execute()).thenReturn(seasonOneListOfGames);
        when(game1.getResult()).thenReturn(result1);
        when(game2.getResult()).thenReturn(result2);
        when(game3.getResult()).thenReturn(result3);
        when(game4.getResult()).thenReturn(result4);
        when(game1.getId()).thenReturn(gameId1);
        when(game2.getId()).thenReturn(gameId2);
        when(game3.getId()).thenReturn(gameId3);
        when(game4.getId()).thenReturn(gameId4);

        when(result1.getHomeScore()).thenReturn(4);
        when(result1.getAwayScore()).thenReturn(2);
        when(result2.getHomeScore()).thenReturn(6);
        when(result2.getAwayScore()).thenReturn(3);
        when(result3.getHomeScore()).thenReturn(5);
        when(result3.getAwayScore()).thenReturn(5);
        when(result4.getHomeScore()).thenReturn(4);
        when(result4.getAwayScore()).thenReturn(5);
        when(game1.getHomeTeam()).thenReturn(team1);
        when(game1.getAwayTeam()).thenReturn(team2);
        when(game2.getHomeTeam()).thenReturn(team1);
        when(game2.getAwayTeam()).thenReturn(team2);
        when(game3.getHomeTeam()).thenReturn(team1);
        when(game3.getAwayTeam()).thenReturn(team2);
        when(game4.getHomeTeam()).thenReturn(team1);
        when(game4.getAwayTeam()).thenReturn(team2);
        when(result1.getFullTime()).thenReturn(true);
        when(result1.getShotOut()).thenReturn(false);
        when(result1.getOverTime()).thenReturn(false);
        when(result2.getFullTime()).thenReturn(false);
        when(result2.getShotOut()).thenReturn(true);
        when(result2.getOverTime()).thenReturn(false);
        when(result3.getFullTime()).thenReturn(true);
        when(result3.getShotOut()).thenReturn(false);
        when(result3.getOverTime()).thenReturn(false);
        when(result4.getFullTime()).thenReturn(false);
        when(result4.getShotOut()).thenReturn(false);
        when(result4.getOverTime()).thenReturn(true);
        
        when(result1.getHomeTeamFirstGoal()).thenReturn(true);
        when(result1.getAwayTeamFirstGoal()).thenReturn(false);
        when(result1.getHomeTeamLastGoal()).thenReturn(true);
        when(result1.getAwayTeamLastGoal()).thenReturn(false);
        when(result1.getScore()).thenReturn("2:1-2:1");
        
        when(result2.getHomeTeamFirstGoal()).thenReturn(false);
        when(result2.getHomeTeamLastGoal()).thenReturn(false);
        when(result2.getAwayTeamFirstGoal()).thenReturn(true);
        when(result2.getAwayTeamLastGoal()).thenReturn(true);
        when(result2.getScore()).thenReturn("1:2-5:1");
        
        when(result3.getHomeTeamFirstGoal()).thenReturn(true);
        when(result3.getAwayTeamFirstGoal()).thenReturn(false);
        when(result3.getHomeTeamLastGoal()).thenReturn(true);
        when(result3.getAwayTeamLastGoal()).thenReturn(false);
        when(result3.getScore()).thenReturn("2:1-3:4");
        
        when(result4.getHomeTeamFirstGoal()).thenReturn(false);
        when(result4.getHomeTeamLastGoal()).thenReturn(false);
        when(result4.getAwayTeamFirstGoal()).thenReturn(true);
        when(result4.getAwayTeamLastGoal()).thenReturn(true);
        when(result4.getScore()).thenReturn("1:2-3:3");
        
        when(team1.getId()).thenReturn(teamId1);
        when(team2.getId()).thenReturn(teamId2);
        when(team1.getId()).thenReturn(teamId1);
        when(team2.getId()).thenReturn(teamId2);
        when(team1.getName()).thenReturn("team1");
        when(team2.getName()).thenReturn("team2");

        
    }
    
    @Before
    public void createTable() {
        table1 = new ArrayList<>();
        table1Team1 = new TableRow();
        table1Team1.gamesLossed = 1;
        table1Team1.gamesPlayed = 4;
        table1Team1.gamesWon = 2;
        table1Team1.lossPercentage = 25;
        table1Team1.teamId = 1L;
        table1Team1.teamName = "team1";
        table1Team1.winPercentage = 50;
        
        table1Team2 = new TableRow();
        table1Team2.gamesLossed = 2;
        table1Team2.gamesPlayed = 4;
        table1Team2.gamesWon = 1;
        table1Team2.lossPercentage = 50;
        table1Team2.teamId = 2L;
        table1Team2.teamName = "team2";
        table1Team2.winPercentage = 25;
        
        table1.add(JsonOutputformat.create(table1Team1));
        table1.add(JsonOutputformat.create(table1Team2));
        
        table2 = new ArrayList<>();
        table2Team1 = new TableRow();
        table2Team1.gamesLossed = 1;
        table2Team1.gamesPlayed = 4;
        table2Team1.gamesWon = 2;
        table2Team1.lossPercentage = 25;
        table2Team1.teamId = 1L;
        table2Team1.teamName = "team1";
        table2Team1.winPercentage = 50;
        
        table2Team2 = new TableRow();
        table2Team2.gamesLossed = 0;
        table2Team2.gamesPlayed = 0;
        table2Team2.gamesWon = 0;
        table2Team2.lossPercentage = 0;
        table2Team2.teamId = 2L;
        table2Team2.teamName = "team2";
        table2Team2.winPercentage = 0;
        
        table2.add(JsonOutputformat.create(table2Team1));
        table2.add(JsonOutputformat.create(table2Team2));
        
        
        table3 = new ArrayList<>();
        table3Team1 = new TableRow();
        table3Team1.gamesLossed = 0;
        table3Team1.gamesPlayed = 0;
        table3Team1.gamesWon = 0;
        table3Team1.lossPercentage = 0;
        table3Team1.teamId = 1L;
        table3Team1.teamName = "team1";
        table3Team1.winPercentage = 0;
        
        table3Team2 = new TableRow();
        table3Team2.gamesLossed = 2;
        table3Team2.gamesPlayed = 4;
        table3Team2.gamesWon = 1;
        table3Team2.lossPercentage = 50;
        table3Team2.teamId = 2L;
        table3Team2.teamName = "team2";
        table3Team2.winPercentage = 25;
        
        table3.add(JsonOutputformat.create(table3Team2));
        table3.add(JsonOutputformat.create(table3Team1));
        
        
        table4 = new ArrayList<>();
        table4Team1 = new TableRow();
        table4Team1.gamesLossed = 0;
        table4Team1.gamesPlayed = 2;
        table4Team1.gamesWon = 1;
        table4Team1.lossPercentage = 0;
        table4Team1.teamId = 1L;
        table4Team1.teamName = "team1";
        table4Team1.winPercentage = 50;
        
        table4Team2 = new TableRow();
        table4Team2.gamesLossed = 1;
        table4Team2.gamesPlayed = 2;
        table4Team2.gamesWon = 1;
        table4Team2.lossPercentage = 50;
        table4Team2.teamId = 2L;
        table4Team2.teamName = "team2";
        table4Team2.winPercentage = 50;
        
        table4.add(JsonOutputformat.create(table4Team1));
        table4.add(JsonOutputformat.create(table4Team2));
        
        table5 = new ArrayList<>();
        table5Team1 = new TableRow();
        table5Team1.gamesLossed = 1;
        table5Team1.gamesPlayed = 2;
        table5Team1.gamesWon = 1;
        table5Team1.lossPercentage = 50;
        table5Team1.teamId = 1L;
        table5Team1.teamName = "team1";
        table5Team1.winPercentage = 50;
        
        table5Team2 = new TableRow();
        table5Team2.gamesLossed = 1;
        table5Team2.gamesPlayed = 2;
        table5Team2.gamesWon = 1;
        table5Team2.lossPercentage = 50;
        table5Team2.teamId = 2L;
        table5Team2.teamName = "team2";
        table5Team2.winPercentage = 50;
        
        table5.add(JsonOutputformat.create(table5Team1));
        table5.add(JsonOutputformat.create(table5Team2));
        
        table6 = new ArrayList<>();
        table6Team1 = new TableRow();
        table6Team1.gamesLossed = 0;
        table6Team1.gamesPlayed = 2;
        table6Team1.gamesWon = 1;
        table6Team1.lossPercentage = 0;
        table6Team1.teamId = 1L;
        table6Team1.teamName = "team1";
        table6Team1.winPercentage = 50;
        
        table6Team2 = new TableRow();
        table6Team2.gamesLossed = 1;
        table6Team2.gamesPlayed = 2;
        table6Team2.gamesWon = 0;
        table6Team2.lossPercentage = 50;
        table6Team2.teamId = 2L;
        table6Team2.teamName = "team2";
        table6Team2.winPercentage = 0;
        
        table6.add(JsonOutputformat.create(table6Team1));
        table6.add(JsonOutputformat.create(table6Team2));
        
        table7 = new ArrayList<>();
        table7Team1 = new TableRow();
        table7Team1.gamesLossed = 0;
        table7Team1.gamesPlayed = 2;
        table7Team1.gamesWon = 1;
        table7Team1.lossPercentage = 0;
        table7Team1.teamId = 1L;
        table7Team1.teamName = "team1";
        table7Team1.winPercentage = 50;
        
        table7Team2 = new TableRow();
        table7Team2.gamesLossed = 1;
        table7Team2.gamesPlayed = 2;
        table7Team2.gamesWon = 1;
        table7Team2.lossPercentage = 50;
        table7Team2.teamId = 2L;
        table7Team2.teamName = "team2";
        table7Team2.winPercentage = 50;
        
        table7.add(JsonOutputformat.create(table7Team1));
        table7.add(JsonOutputformat.create(table7Team2));
    }

    @Test
    public void testConstructor1() {
        try {
            Boolean[] firstLastGoal = {null, true};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, null};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {null, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, null};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, null, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, (List<Long>) null, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        Boolean[] firstLastGoal = {true, true};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
    }

    @Test
    public void testConstructor2() {
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(null, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {null, true};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, null};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {null, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, null};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, null, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        Boolean[] firstLastGoal = {true, true};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
    }

    @Test
    public void testConstructor3() {
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(null, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {null, true};
            Boolean[] fullOvertime = {true, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, null};
            Boolean[] fullOvertime = {true, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {null, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, null};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, null, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {true, true};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, null, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        try {
            Boolean[] firstLastGoal = {true, true};
            Boolean[] fullOvertime = {false, false};
            Boolean[] homeAway = {true, true};
            new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
            fail();
        } catch (ServiceException e) {
        }
        Boolean[] firstLastGoal = {true, true};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
    }

    /**
     * Test of execute method, of class ShowTeamWinLossStatistics.
     */
    @Test
    public void testExecute1() {
        System.out.println("execute");
        Boolean[] firstLastGoal = {false, false};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        ShowTeamWinLossStatistics instance = new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
        instance.init(brokerFactory);
        List<String> res = instance.execute();
        assertEquals(table1.get(0), res.get(0));
        assertEquals(table1.get(1), res.get(1));
        
        Boolean[] firstLastGoal2 = {false, false};
        Boolean[] fullOvertime2 = {true, true};
        Boolean[] homeAway2 = {true, false};
        ShowTeamWinLossStatistics instance2 = new ShowTeamWinLossStatistics(firstLastGoal2, fullOvertime2, 0, teamIds, homeAway2);
        instance2.init(brokerFactory);
        List<String> res2 = instance2.execute();
        assertEquals(table2.get(0), res2.get(0));
        assertEquals(table2.get(1), res2.get(1));
        
        Boolean[] firstLastGoal3 = {false, false};
        Boolean[] fullOvertime3 = {true, true};
        Boolean[] homeAway3 = {false, true};
        ShowTeamWinLossStatistics instance3 = new ShowTeamWinLossStatistics(firstLastGoal3, fullOvertime3, 0, teamIds, homeAway3);
        instance3.init(brokerFactory);
        List<String> res3 = instance3.execute();
        assertEquals(table3.get(0), res3.get(0));
        assertEquals(table3.get(1), res3.get(1));
        
        Boolean[] firstLastGoal4 = {true, false};
        Boolean[] fullOvertime4 = {true, true};
        Boolean[] homeAway4 = {true, true};
        ShowTeamWinLossStatistics instance4 = new ShowTeamWinLossStatistics(firstLastGoal4, fullOvertime4, 0, teamIds, homeAway4);
        instance4.init(brokerFactory);
        List<String> res4 = instance4.execute();
        assertEquals(table4.get(0), res4.get(0));
        assertEquals(table4.get(1), res4.get(1));
        
        Boolean[] firstLastGoal5 = {false, true};
        Boolean[] fullOvertime5 = {true, true};
        Boolean[] homeAway5 = {true, true};
        ShowTeamWinLossStatistics instance5 = new ShowTeamWinLossStatistics(firstLastGoal5, fullOvertime5, 0, teamIds, homeAway5);
        instance5.init(brokerFactory);
        List<String> res5 = instance5.execute();
        assertEquals(table4.get(0), res5.get(0));
        assertEquals(table4.get(1), res5.get(1));
        
        Boolean[] firstLastGoal6 = {false, false};
        Boolean[] fullOvertime6 = {false, true};
        Boolean[] homeAway6 = {true, true};
        ShowTeamWinLossStatistics instance6 = new ShowTeamWinLossStatistics(firstLastGoal6, fullOvertime6, 0, teamIds, homeAway6);
        instance6.init(brokerFactory);
        List<String> res6 = instance6.execute();
        assertEquals(table5.get(0), res6.get(0));
        assertEquals(table5.get(1), res6.get(1));
        
        Boolean[] firstLastGoal7 = {false, false};
        Boolean[] fullOvertime7 = {true, false};
        Boolean[] homeAway7 = {true, true};
        ShowTeamWinLossStatistics instance7 = new ShowTeamWinLossStatistics(firstLastGoal7, fullOvertime7, 0, teamIds, homeAway7);
        instance7.init(brokerFactory);
        List<String> res7 = instance7.execute();
        assertEquals(table6.get(0), res7.get(0));
        assertEquals(table6.get(1), res7.get(1));
        
        Boolean[] firstLastGoal8 = {false, false};
        Boolean[] fullOvertime8 = {true, true};
        Boolean[] homeAway8 = {true, true};
        ShowTeamWinLossStatistics instance8 = new ShowTeamWinLossStatistics(firstLastGoal8, fullOvertime8, 1, teamIds, homeAway8);
        instance8.init(brokerFactory);
        List<String> res8 = instance8.execute();
        assertEquals(table7.get(0), res8.get(0));
        assertEquals(table7.get(1), res8.get(1));
        

    }
    @Test
    public void testExecute2() {
        System.out.println("execute");
        Boolean[] firstLastGoal = {false, false};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        ShowTeamWinLossStatistics instance = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, homeAway);
        instance.init(brokerFactory);
        List<String> res = instance.execute();
        assertEquals(table1.get(0), res.get(0));
        assertEquals(table1.get(1), res.get(1));
        
        Boolean[] firstLastGoal2 = {false, false};
        Boolean[] fullOvertime2 = {true, true};
        Boolean[] homeAway2 = {true, false};
        ShowTeamWinLossStatistics instance2 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal2, fullOvertime2, 0, homeAway2);
        instance2.init(brokerFactory);
        List<String> res2 = instance2.execute();
        assertEquals(table2.get(0), res2.get(0));
        assertEquals(table2.get(1), res2.get(1));
        
        Boolean[] firstLastGoal3 = {false, false};
        Boolean[] fullOvertime3 = {true, true};
        Boolean[] homeAway3 = {false, true};
        ShowTeamWinLossStatistics instance3 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal3, fullOvertime3, 0, homeAway3);
        instance3.init(brokerFactory);
        List<String> res3 = instance3.execute();
        assertEquals(table3.get(0), res3.get(0));
        assertEquals(table3.get(1), res3.get(1));
        
        Boolean[] firstLastGoal4 = {true, false};
        Boolean[] fullOvertime4 = {true, true};
        Boolean[] homeAway4 = {true, true};
        ShowTeamWinLossStatistics instance4 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal4, fullOvertime4, 0, homeAway4);
        instance4.init(brokerFactory);
        List<String> res4 = instance4.execute();
        assertEquals(table4.get(0), res4.get(0));
        assertEquals(table4.get(1), res4.get(1));
        
        Boolean[] firstLastGoal5 = {false, true};
        Boolean[] fullOvertime5 = {true, true};
        Boolean[] homeAway5 = {true, true};
        ShowTeamWinLossStatistics instance5 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal5, fullOvertime5, 0, homeAway5);
        instance5.init(brokerFactory);
        List<String> res5 = instance5.execute();
        assertEquals(table4.get(0), res5.get(0));
        assertEquals(table4.get(1), res5.get(1));
        
        Boolean[] firstLastGoal6 = {false, false};
        Boolean[] fullOvertime6 = {false, true};
        Boolean[] homeAway6 = {true, true};
        ShowTeamWinLossStatistics instance6 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal6, fullOvertime6, 0, homeAway6);
        instance6.init(brokerFactory);
        List<String> res6 = instance6.execute();
        assertEquals(table5.get(0), res6.get(0));
        assertEquals(table5.get(1), res6.get(1));
        
        Boolean[] firstLastGoal7 = {false, false};
        Boolean[] fullOvertime7 = {true, false};
        Boolean[] homeAway7 = {true, true};
        ShowTeamWinLossStatistics instance7 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal7, fullOvertime7, 0, homeAway7);
        instance7.init(brokerFactory);
        List<String> res7 = instance7.execute();
        assertEquals(table6.get(0), res7.get(0));
        assertEquals(table6.get(1), res7.get(1));
        
        Boolean[] firstLastGoal8 = {false, false};
        Boolean[] fullOvertime8 = {true, true};
        Boolean[] homeAway8 = {true, true};
        ShowTeamWinLossStatistics instance8 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal8, fullOvertime8, 1, homeAway8);
        instance8.init(brokerFactory);
        List<String> res8 = instance8.execute();
        assertEquals(table7.get(0), res8.get(0));
        assertEquals(table7.get(1), res8.get(1));
    }
    @Test
    public void testExecute3() {
        System.out.println("execute");
        Boolean[] firstLastGoal = {false, false};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        ShowTeamWinLossStatistics instance = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal, fullOvertime, 0, teamIds, homeAway);
        instance.init(brokerFactory);
        List<String> res = instance.execute();
        assertEquals(table1.get(0), res.get(0));
        assertEquals(table1.get(1), res.get(1));
        
        Boolean[] firstLastGoal2 = {false, false};
        Boolean[] fullOvertime2 = {true, true};
        Boolean[] homeAway2 = {true, false};
        ShowTeamWinLossStatistics instance2 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal2, fullOvertime2, 0, teamIds, homeAway2);
        instance2.init(brokerFactory);
        List<String> res2 = instance2.execute();
        assertEquals(table2.get(0), res2.get(0));
        assertEquals(table2.get(1), res2.get(1));
        
        Boolean[] firstLastGoal3 = {false, false};
        Boolean[] fullOvertime3= {true, true};
        Boolean[] homeAway3 = {false, true};
        ShowTeamWinLossStatistics instance3 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal3, fullOvertime3, 0, teamIds, homeAway3);
        instance3.init(brokerFactory);
        List<String> res3 = instance3.execute();
        assertEquals(table3.get(0), res3.get(0));
        assertEquals(table3.get(1), res3.get(1));
        
        Boolean[] firstLastGoal4 = {true, false};
        Boolean[] fullOvertime4 = {true, true};
        Boolean[] homeAway4 = {true, true};
        ShowTeamWinLossStatistics instance4 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal4, fullOvertime4, 0, teamIds, homeAway4);
        instance4.init(brokerFactory);
        List<String> res4 = instance4.execute();
        assertEquals(table4.get(0), res4.get(0));
        assertEquals(table4.get(1), res4.get(1));
        
        Boolean[] firstLastGoal5 = {false, true};
        Boolean[] fullOvertime5 = {true, true};
        Boolean[] homeAway5 = {true, true};
        ShowTeamWinLossStatistics instance5 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal5, fullOvertime5, 0, teamIds, homeAway5);
        instance5.init(brokerFactory);
        List<String> res5 = instance5.execute();
        assertEquals(table4.get(0), res5.get(0));
        assertEquals(table4.get(1), res5.get(1));
        
        Boolean[] firstLastGoal6 = {false, false};
        Boolean[] fullOvertime6 = {false, true};
        Boolean[] homeAway6 = {true, true};
        ShowTeamWinLossStatistics instance6 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal6, fullOvertime6, 0, teamIds, homeAway6);
        instance6.init(brokerFactory);
        List<String> res6 = instance6.execute();
        assertEquals(table5.get(0), res6.get(0));
        assertEquals(table5.get(1), res6.get(1));
        
        Boolean[] firstLastGoal7 = {false, false};
        Boolean[] fullOvertime7 = {true, false};
        Boolean[] homeAway7 = {true, true};
        ShowTeamWinLossStatistics instance7 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal7, fullOvertime7, 0, teamIds, homeAway7);
        instance7.init(brokerFactory);
        List<String> res7 = instance7.execute();
        assertEquals(table6.get(0), res7.get(0));
        assertEquals(table6.get(1), res7.get(1));
        
        Boolean[] firstLastGoal8 = {false, false};
        Boolean[] fullOvertime8 = {true, true};
        Boolean[] homeAway8 = {true, true};
        ShowTeamWinLossStatistics instance8 = new ShowTeamWinLossStatistics(seasonIds, firstLastGoal8, fullOvertime8, 1, teamIds, homeAway8);
        instance8.init(brokerFactory);
        List<String> res8 = instance8.execute();
        assertEquals(table7.get(0), res8.get(0));
        assertEquals(table7.get(1), res8.get(1));
    }
    

    @JsonPropertyOrder({"teamName", "winPercentage", "lossPercentage", "gamesPlayed", "gamesWon", "gamesLossed"})
    private class TableRow {
        public String teamName;
        public long teamId;
        public double winPercentage;
        public double lossPercentage;
        public int gamesPlayed;
        public int gamesWon;
        public int gamesLossed;
    }
}
