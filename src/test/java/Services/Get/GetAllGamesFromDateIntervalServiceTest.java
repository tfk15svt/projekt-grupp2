/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllGamesFromDateIntervalService;
import Broker.BrokerFactory;
import Broker.LeagueBroker;
import Domain.Game;
import Services.ServiceException;
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
public class GetAllGamesFromDateIntervalServiceTest {
    private static Long leagueId = 1L;
    private static Integer startDate = 20120313;
    private static Integer endDate = 20180416;
    private static BrokerFactory brokerFactory;
    private static LeagueBroker leagueBroker;
    private static List<Game> resultGameList;
    private static List<Game> returnedList;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        leagueBroker = mock(LeagueBroker.class);
        game1 = mock(Game.class);
        game2 = mock(Game.class);
        game3 = mock(Game.class);
        resultGameList = new ArrayList<Game>();
        resultGameList.add(game1);
        resultGameList.add(game2);
        resultGameList.add(game3);
        returnedList = new ArrayList<Game>();
        returnedList.add(game1);
        returnedList.add(game2);
        returnedList.add(game3);
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(leagueBroker.getGamesWithinDateInterVal((long)leagueId, (int)startDate, (int)endDate)).thenReturn(returnedList);
        
    }
    @Test
    public void testConstructor(){
        try {
            new GetAllGamesFromDateIntervalService(null, startDate, endDate);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new GetAllGamesFromDateIntervalService(leagueId, startDate, null);
            fail();
        } catch (ServiceException e) {
        }
        try {
            new GetAllGamesFromDateIntervalService(leagueId, null, endDate);
            fail();
        } catch (ServiceException e) {
        }
        new GetAllGamesFromDateIntervalService(leagueId, startDate, endDate);
    }
    @Test
    public void testInit() {
        GetAllGamesFromDateIntervalService instance = new GetAllGamesFromDateIntervalService(leagueId, startDate, endDate);
        try {
            instance.init(null);
            fail();
        } catch (Exception e) {
        }
        instance.init(brokerFactory);
    }
    /**
     * Test of execute method, of class GetAllGamesFromDateIntervalService.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        GetAllGamesFromDateIntervalService instance = new GetAllGamesFromDateIntervalService(leagueId, startDate, endDate);
        instance.init(brokerFactory);
        
        List<Game> result = instance.execute();
        int i = 0;
        for (Game game: resultGameList) {
            assertEquals(resultGameList.get(i), result.get(i));
            i++;
        }
        //resultGameList.stream().map(game -> assertEquals((Game) game), result
        //     .get(resultGameList.indexOf((Game) game)));
    }
    
}
