/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SeasonBroker;
import Broker.ServiceBroker;
import DAO.TeamDao;
import Domain.Game;
import Domain.Result;
import Domain.Round;
import Domain.Season;
import Domain.Team;
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
public class GetFilterTableOnRoundIntervalServiceTest {
    
    private static Long seasonId;
    private static BrokerFactory brokerFactory;
    private static String[] row1;
    private static String[] row3;
    private static String teamName1;
    private static String teamName3;
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
    
    private static int fullTimeWins3;
    private static int losses3;
    private static int tied3;
    private static int overTimeWins3;
    private static int overTimeLosses3;
    private static int scoredGoals3;
    private static int opponentScore3;
    private static int points3;
    
    private static Team team1;
    private static Team team2;
    private static Team team3;
    private static TeamDao teamDao1;
    private static TeamDao teamDao2;
    private static TeamDao teamDao3;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    private static SeasonBroker seasonBroker;
    private static Result result1;
    private static Result result2;
    private static Result result3;
    private static ServiceRunner serviceRunner;
    private static ServiceBroker serviceBroker;
    private static GetAllGamesFromSeasonService getAllGamesFromSeasonService;
    private static int startRound;
    private static int endRound;
    private static Round round1;
    private static Round round2;
    private static Round round3;
    
    private static List<Game> allSeasonGames;
    private static List<Team> allSeasonTeams;
    
    
    @BeforeClass
    public static void setUpClass() {
        round1 = mock(Round.class);
        round2 = mock(Round.class);
        round3 = mock(Round.class);
        seasonId = 1L;
        endRound = 3;
        startRound = 0;  
        brokerFactory = mock(BrokerFactory.class);
        getAllGamesFromSeasonService = mock(GetAllGamesFromSeasonService.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        team3 = mock(Team.class);
        teamDao1 = mock(TeamDao.class);
        teamDao2 = mock(TeamDao.class);
        teamDao3 = mock(TeamDao.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        seasonBroker = mock(SeasonBroker.class);
        result1 = mock(Result.class);
        result2 = mock(Result.class);
        result3 = mock(Result.class);
        serviceRunner = mock(ServiceRunner.class);
        serviceBroker = mock(ServiceBroker.class);
        
        teamName1 = "Lag1";
        teamName2 = "Lag2";
        teamName3 = "Lag3";
        
        fullTimeWins1 = 1;
        losses1 = 1;
        tied1 = 1;
        overTimeWins1 = 1;
        overTimeLosses1 = 0;
        scoredGoals1 = 9;
        opponentScore1 = 5;
        points1 = 5;
        row1 = new String[7] ;
        
        row2 = new String[7] ;
        fullTimeWins2 = 1;
        tied2 = 1;
        overTimeWins2 = 0;
        overTimeLosses2 = 1;
        losses2 = 1;
        scoredGoals2 = 5;
        opponentScore2 = 9;
        points2 = 4;
        
        row3 = new String[7] ;
        fullTimeWins3 = 0;
        tied3 = 0;
        overTimeWins3 = 0;
        overTimeLosses3 = 0;
        losses3 = 0;
        scoredGoals3 = 0;
        opponentScore3 = 0;
        points3 = 0;
        
        allSeasonGames = new ArrayList<>();
        allSeasonGames.add(game1);
        allSeasonGames.add(game2);
        allSeasonGames.add(game3);
        allSeasonTeams = new ArrayList<>();
        allSeasonTeams.add(team1);
        allSeasonTeams.add(team2);
        allSeasonTeams.add(team3);
        
        when(round1.getRoundNumber()).thenReturn(1);
        when(round2.getRoundNumber()).thenReturn(2);
        when(round3.getRoundNumber()).thenReturn(3);
        when(game1.getRound()).thenReturn(round1);
        when(game2.getRound()).thenReturn(round2);
        when(game3.getRound()).thenReturn(round3);
        
        
        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(serviceBroker.getAllGamesFromSeasonService(seasonId)).thenReturn(getAllGamesFromSeasonService);
        when(getAllGamesFromSeasonService.execute()).thenReturn(allSeasonGames);
        when(seasonBroker.getAllTeamsFromSeasonId(seasonId)).thenReturn(allSeasonTeams);
        when(seasonBroker.findSeasonById(seasonId)).thenReturn(mock(Season.class));
        when(team1.getDao()).thenReturn(teamDao1);
        when(team2.getDao()).thenReturn(teamDao2);
        when(team3.getDao()).thenReturn(teamDao3);
        when(team1.getName()).thenReturn(teamName1);
        when(team2.getName()).thenReturn(teamName2);
        when(team3.getName()).thenReturn(teamName3);
        when(teamDao1.getLongId()).thenReturn(1L);
        when(teamDao2.getLongId()).thenReturn(2L);
        when(teamDao3.getLongId()).thenReturn(3L);
        when(game1.getResult()).thenReturn(result1);
        when(game2.getResult()).thenReturn(result2);
        when(game3.getResult()).thenReturn(result3);
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
        when(result3.getAwayScore()).thenReturn(2);
        when(result3.getHomeScore()).thenReturn(4);
        when(result3.getOverTime()).thenReturn(false);
        when(result3.getShotOut()).thenReturn(false);
        when(result3.getFullTime()).thenReturn(true);
        when(game1.getHomeTeam()).thenReturn(team1);
        when(game1.getAwayTeam()).thenReturn(team2);
        when(game2.getHomeTeam()).thenReturn(team2);
        when(game2.getAwayTeam()).thenReturn(team1);
        when(game3.getAwayTeam()).thenReturn(team1);
        when(game3.getHomeTeam()).thenReturn(team2);
        
        
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
        
        row3 = new String[7];
        row3[0] = teamName3;
        row3[1] = " GP: " + (fullTimeWins3 + losses3 + tied3);
        row3[2] = " W: " + (fullTimeWins3);
        row3[3] = " T: " + (tied3);
        row3[4] = " L: " + losses3;
        row3[5] = " " + scoredGoals3 + " - " + opponentScore3 + " ";
        row3[6] = points3 + "p";
    }

    @Test 
    public void testConstructor(){
        try{
            new GetFilterTableOnRoundIntervalService(null, 0, 0);
        }catch(ServiceException e){
            e.getMessage();
        }
    }

    @Test
    public void testInit(){
        GetFilterTableOnRoundIntervalService instance = new GetFilterTableOnRoundIntervalService(seasonId, startRound, endRound);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        System.out.println("execute");
        GetFilterTableOnRoundIntervalService instance = new GetFilterTableOnRoundIntervalService(seasonId, startRound, endRound);
        instance.init(brokerFactory);
        String expResult = 
                row1[0] + row1[1] + row1[2] + row1[3] + row1[4] + row1[5] + row1[6] + "\n" +
                row2[0] + row2[1] + row2[2] + row2[3] + row2[4] + row2[5] + row2[6] + "\n" + 
                row3[0] + row3[1] + row3[2] + row3[3] + row3[4] + row3[5] + row3[6] + "\n";
        String reString = instance.execute();
        assertEquals(expResult, reString);
    }
}
