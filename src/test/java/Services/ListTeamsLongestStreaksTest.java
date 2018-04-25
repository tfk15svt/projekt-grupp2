/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;
import Broker.GameBroker;
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
public class ListTeamsLongestStreaksTest {
    private static Long teamId1;
    private static Long teamId2;
    private static Integer startDate;
    private static Integer endDate;
    private static BrokerFactory brokerFactory;
    private static TeamBroker teamBroker;
    private static GameBroker gameBroker;
    private static Game game1;
    private static Team team1;
    private static Team team2;
    private static Result result1;
    private static String expectedString;
    private static int gamesPlayed;
    private static int winningStreak;
    private static int tiedStreak;
    private static int lostStreak;
    private static List<Game> listOfGames;
    private static Round round1;
    private static Season season1;
    
    
    @BeforeClass
    public static void setUpClass() {
        game1 = mock(Game.class);
        season1 = mock(Season.class);
        round1 = mock(Round.class);
        listOfGames = new ArrayList<>();
        listOfGames.add(game1);
        brokerFactory = mock(BrokerFactory.class);
        teamBroker = mock(TeamBroker.class);
        gameBroker = mock(GameBroker.class);
        team1 = mock(Team.class);
        team2 = mock(Team.class);
        result1 = mock(Result.class);
        teamId1 = 1L;
        teamId2 = 2L;
        startDate = 1;
        endDate = 2;
        
        gamesPlayed = 1;
        winningStreak = 1;
        tiedStreak = 0;
        lostStreak = 0;
        
        
        when(brokerFactory.getTeamBroker()).thenReturn(teamBroker);
        when(teamBroker.getAllGamesForOneTeam(teamId1)).thenReturn(listOfGames);
        
        when(teamBroker.findTeamById(teamId1)).thenReturn(team1);
        when(teamBroker.findTeamById(teamId2)).thenReturn(team2);
        when(team1.getId()).thenReturn(teamId1);
        when(team2.getId()).thenReturn(teamId2);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.create()).thenReturn(game1);
        when(game1.getDate()).thenReturn(1);
        when(game1.getResult()).thenReturn(result1);
        when(game1.getHomeTeam()).thenReturn(team1);
        when(game1.getAwayTeam()).thenReturn(team2);
        when(game1.getRound()).thenReturn(round1);
        when(round1.getRoundNumber()).thenReturn(1);
        when(round1.getSeason()).thenReturn(season1);
        when(season1.getYear()).thenReturn(2019);
        when(result1.getHomeScore()).thenReturn(4);
        when(result1.getAwayScore()).thenReturn(2);
        when(result1.getFullTime()).thenReturn(true);
        when(result1.getShotOut()).thenReturn(false);
        when(result1.getOverTime()).thenReturn(false);
        
        expectedString = "GP:" + gamesPlayed + " WinningStreak:" + winningStreak + " TiedStreak:" + tiedStreak + " LostStreak:" + lostStreak;
    }
    
    @Test
    public void testConstructor(){
        try{
            new ListTeamsLongestStreaks(teamId1, startDate, endDate);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ListTeamsLongestStreaks instance = new ListTeamsLongestStreaks(teamId1, startDate, endDate);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        ListTeamsLongestStreaks instance = new ListTeamsLongestStreaks(teamId1, startDate, endDate);
        instance.init(brokerFactory);
        String expResult = JsonOutputformat.create(expectedString);
        String reString = JsonOutputformat.create(instance.execute());
        assertTrue(expResult.equals(reString));
    }
}
