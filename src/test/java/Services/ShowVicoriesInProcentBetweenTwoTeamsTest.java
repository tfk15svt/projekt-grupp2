/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.RoundBroker;
import Broker.TeamBroker;
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
public class ShowVicoriesInProcentBetweenTwoTeamsTest {
    private static BrokerFactory brokerFactory;
    private static long teamId1;
    private static long teamId2;
    private static List<Game> allGames;
    private static Team team1, team2;
    private static Game game;
    private static Integer start;
    private static Integer end;
    private static TeamBroker teamBroker;
    private static GameBroker gameBroker;
    private static Result result;
    private static String expectedString;
    private static Round round;
    private static int gamesPlayed;
    private static double team1Procent;
    private static double team2Procent;
    private static double tiedProcent;
    private static RoundBroker roundBroker;
    private static Season season;
    
    
    @BeforeClass
    public static void setUpClass() {
        season = mock(Season.class);
        roundBroker = mock(RoundBroker.class);
        round = mock(Round.class);
        result = mock(Result.class);
        game = mock(Game.class);
        start = 1;
        end = 2;
        allGames = new ArrayList<>();
        allGames.add(game);
        teamId1 = 1L;
        teamId2 = 2L;
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        teamBroker = mock(TeamBroker.class);
        brokerFactory = mock(BrokerFactory.class);
        gameBroker = mock(GameBroker.class);
        gamesPlayed = 1;
        team1Procent = 100.0;
        team2Procent = 0.0;
        tiedProcent = 0.0;
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.getAllGamesForTwoTeams(teamId1, teamId2)).thenReturn(allGames);
        when(teamBroker.findTeamById(teamId1)).thenReturn(team1);
        when(teamBroker.findTeamById(teamId2)).thenReturn(team2);
        //when(brokerFactory.getRoundBroker()).thenReturn(roundBroker);
        //when(roundBroker.create()).thenReturn(round);
        when(round.getRoundNumber()).thenReturn(1);
        when(round.getSeason()).thenReturn(season);
        when(season.getYear()).thenReturn(2019);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.create()).thenReturn(game);
        when(game.getHomeTeam()).thenReturn(team1);
        when(game.getAwayTeam()).thenReturn(team2);
        when(game.getRound()).thenReturn(round);
        when(game.getDate()).thenReturn(20190424);
        when(team1.getId()).thenReturn(teamId1);
        when(team2.getId()).thenReturn(teamId2);
        when(game.getResult()).thenReturn(result);
        when(result.getHomeScore()).thenReturn(5);
        when(result.getAwayScore()).thenReturn(3);
        when(result.getFullTime()).thenReturn(true);
        when(result.getOverTime()).thenReturn(false);
        when(result.getShotOut()).thenReturn(false);
        
        expectedString = "GP:" + gamesPlayed + " team1:" + team1Procent + "%" + " team2:" + team2Procent + "%" + " tied:" + tiedProcent + "%"; 
    }
    
    @Test
    public void testConstructor(){
        try{
            new ShowVicoriesInProcentBetweenTwoTeams(null, null, null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
        
        try{
            new ShowVicoriesInProcentBetweenTwoTeams(teamId1, null, null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
        
        try{
            new ShowVicoriesInProcentBetweenTwoTeams(null, teamId2, null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ShowVicoriesInProcentBetweenTwoTeams instance = new ShowVicoriesInProcentBetweenTwoTeams(teamId1, teamId2, start, end);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }
    

    @Test
    public void testExecute() {
        System.out.println("Execute");
        ShowVicoriesInProcentBetweenTwoTeams instance = new ShowVicoriesInProcentBetweenTwoTeams(teamId1, teamId2, start, end);
        instance.init(brokerFactory);
        String expResult = JsonOutputformat.create(expectedString);
        String reString = JsonOutputformat.create(instance.execute());
        assertTrue(expResult.equals(reString));
    }
    
}
