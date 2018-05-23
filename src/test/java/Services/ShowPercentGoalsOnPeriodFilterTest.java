/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.ServiceBroker;
import Domain.Game;
import Domain.Result;
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
 * @author Simon
 */
public class ShowPercentGoalsOnPeriodFilterTest {
    
    private static Integer startDate;
    private static Integer endDate;
    private static Long seasonId;
    private static BrokerFactory brokerFactory;
    private static ServiceBroker serviceBroker;
    private static GetAllGamesFromSeasonService allGames;
    private static List<Game>log;
    private static Game game;
    private static Result result;
    private static String scoreString;
    
    
    
    @BeforeClass
    public static void setUpClass() {
        game = mock(Game.class);
        result = mock(Result.class);
        log = new ArrayList<>();
        serviceBroker = mock(ServiceBroker.class);
        brokerFactory = mock(BrokerFactory.class);
        allGames = mock(GetAllGamesFromSeasonService.class);
        startDate = 1;
        endDate = 4;
        seasonId = 1L;
        scoreString = "1:2-1:4-5:3";
        
        when(brokerFactory.getServiceBroker()).thenReturn(serviceBroker);
        when(serviceBroker.getAllGamesFromSeasonService(seasonId)).thenReturn(allGames);
        when(allGames.execute()).thenReturn(log);
        when(game.getResult()).thenReturn(result);
        when(result.getScore()).thenReturn(scoreString);
        
    }
    
    @Test
    public void testConstructor(){
        try{
            new ShowPercentGoalsOnPeriodFilter(null, startDate, endDate);
            new ShowPercentGoalsOnPeriodFilter(seasonId, null, endDate);
            new ShowPercentGoalsOnPeriodFilter(seasonId, startDate, null);
            new ShowPercentGoalsOnPeriodFilter(null, null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit() {
        ShowPercentGoalsOnPeriodFilter s = new ShowPercentGoalsOnPeriodFilter(seasonId, startDate, endDate);
        try{
            s.init(null);
        }catch(ServiceException e){
           e.getMessage();
        }
        s.init(brokerFactory);
    }
    
    @Test
    public void testExecute(){
        ShowPercentGoalsOnPeriodFilter s1 = new ShowPercentGoalsOnPeriodFilter(seasonId, startDate, endDate);
        s1.init(brokerFactory);
        System.out.println("Show Goals: " + "\n" + s1.execute());
    }
    
}
