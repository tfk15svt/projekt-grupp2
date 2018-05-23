/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetGameResultInfoService;
import Broker.BrokerFactory;
import Broker.GameBroker;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import Services.ServiceException;
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
public class GetGameResultInfoServiceTest {
    private static BrokerFactory brokerFactory;
    private static String homeTeamName;
    private static String awayTeamName;
    private static Integer homeScore;
    private static Integer awayScore;
    private static GameBroker gameBroker;
    private static Game game2;
    private static Game game3;
    private static Game game4;
    private static Game game5;
    private static Game game6;
    private static Result result3;
    private static Result result4;
    private static Result result5;
    private static Result result6;
    private static Team homeTeam;
    private static Team awayTeam;
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        homeTeamName = "Real";
        awayTeamName = "Barca";
        homeScore = 20;
        awayScore = 1;
        gameBroker = mock(GameBroker.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        game4 = mock(Game.class);
        game5 = mock(Game.class);
        game6 = mock(Game.class);
        homeTeam = mock(Team.class);
        awayTeam = mock(Team.class);
        result3 = mock(Result.class);
        result4 = mock(Result.class);
        result5 = mock(Result.class);
        result6 = mock(Result.class);
        
        
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(gameBroker.gameExists(1L)).thenReturn(false);
        when(gameBroker.gameExists(2L)).thenReturn(true);
        when(gameBroker.gameExists(3L)).thenReturn(true);
        when(gameBroker.gameExists(4L)).thenReturn(true);
        when(gameBroker.gameExists(5L)).thenReturn(true);
        when(gameBroker.gameExists(6L)).thenReturn(true);
        
        when(gameBroker.findById(2L)).thenReturn(game2);
        when(gameBroker.findById(3L)).thenReturn(game3);
        when(gameBroker.findById(4L)).thenReturn(game4);
        when(gameBroker.findById(5L)).thenReturn(game5);
        when(gameBroker.findById(6L)).thenReturn(game6);
        
        when(game2.getResult()).thenReturn(null);
        when(game3.getResult()).thenReturn(result3);
        when(game4.getResult()).thenReturn(result4);
        when(game5.getResult()).thenReturn(result5);
        when(game6.getResult()).thenReturn(result6);
        when(game2.getHomeTeam()).thenReturn(homeTeam);
        when(game3.getHomeTeam()).thenReturn(homeTeam);
        when(game4.getHomeTeam()).thenReturn(homeTeam);
        when(game5.getHomeTeam()).thenReturn(homeTeam);
        when(game6.getHomeTeam()).thenReturn(homeTeam);
        when(game2.getAwayTeam()).thenReturn(awayTeam);
        when(game3.getAwayTeam()).thenReturn(awayTeam);
        when(game4.getAwayTeam()).thenReturn(awayTeam);
        when(game5.getAwayTeam()).thenReturn(awayTeam);
        when(game6.getAwayTeam()).thenReturn(awayTeam);
        
        when(result3.getHomeScore()).thenReturn(homeScore);
        when(result3.getAwayScore()).thenReturn(awayScore);
        when(result4.getHomeScore()).thenReturn(homeScore);
        when(result4.getAwayScore()).thenReturn(awayScore);
        when(result5.getHomeScore()).thenReturn(homeScore);
        when(result5.getAwayScore()).thenReturn(awayScore);
        when(result6.getHomeScore()).thenReturn(homeScore);
        when(result6.getAwayScore()).thenReturn(awayScore);
        
        when(homeTeam.getName()).thenReturn(homeTeamName);
        when(awayTeam.getName()).thenReturn(awayTeamName);
        
        when(result3.getFullTime()).thenReturn(false);
        when(result3.getShotOut()).thenReturn(false);
        when(result3.getOverTime()).thenReturn(false);
        
        when(result4.getFullTime()).thenReturn(true);
        when(result4.getShotOut()).thenReturn(false);
        when(result4.getOverTime()).thenReturn(false);
        
        when(result5.getFullTime()).thenReturn(false);
        when(result5.getShotOut()).thenReturn(false);
        when(result5.getOverTime()).thenReturn(true);
        
        when(result6.getFullTime()).thenReturn(false);
        when(result6.getShotOut()).thenReturn(true);
        when(result6.getOverTime()).thenReturn(false);
        
    }
    @Test
    public void testConstructor(){
        try{
            new GetGameResultInfoService(null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        GetGameResultInfoService ggr = new GetGameResultInfoService(2L);
        try{
            ggr.init(null);
            fail("fail");
        }catch(ServiceException e){
            e.getMessage();
        }
        ggr.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        GetGameResultInfoService g1 = new GetGameResultInfoService(1L);
        GetGameResultInfoService g2 = new GetGameResultInfoService(2L);
        GetGameResultInfoService g3 = new GetGameResultInfoService(3L);
        GetGameResultInfoService g4 = new GetGameResultInfoService(4L);
        GetGameResultInfoService g5 = new GetGameResultInfoService(5L);
        GetGameResultInfoService g6 = new GetGameResultInfoService(6L); 
        g1.init(brokerFactory);
        g2.init(brokerFactory);
        g3.init(brokerFactory);
        g4.init(brokerFactory);
        g5.init(brokerFactory);
        g6.init(brokerFactory);
        try{
            g1.execute();
            fail();
        }catch(ServiceException e){
            e.getMessage();
        }
        assertEquals("no result for this game", g2.execute());
        assertEquals("" + homeTeamName + " " + homeScore + " - " + awayScore + " " + awayTeamName , g3.execute());
        assertEquals("" + homeTeamName + " " + homeScore + " - " + awayScore + " " + awayTeamName + " : settled in full time" , g4.execute());
        assertEquals("" + homeTeamName + " " + homeScore + " - " + awayScore + " " + awayTeamName + " : settled in overtime", g5.execute());
        assertEquals("" + homeTeamName + " " + homeScore + " - " + awayScore + " " + awayTeamName + " : settled after shootout", g6.execute());
    }
    
    
}
