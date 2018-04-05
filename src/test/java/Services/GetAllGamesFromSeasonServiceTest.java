/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.RoundBroker;
import Broker.SeasonBroker;
import Broker.SportBroker;
import Domain.Game;
import Domain.League;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
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
 * @author Peeftw
 */
public class GetAllGamesFromSeasonServiceTest {
    private static BrokerFactory brokerFactory;
    private static RoundBroker roundBroker;
    private static SeasonBroker seasonBroker;
    private static List<Game> gameList;
    private static List<Game> gameList2;
    private static List<Round> roundList;
    private static Game gameOne;
    private static Game gameTwo;
    private static Game gameThree;
    private static Season season;
    private static Round round;
    private static Round round2;
    
    
    public GetAllGamesFromSeasonServiceTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        roundBroker = mock(RoundBroker.class);
        seasonBroker = mock(SeasonBroker.class);
        season = mock(Season.class);
        round = mock(Round.class);
        round2 = mock(Round.class);
        
        gameOne = mock(Game.class);
        gameList = new ArrayList<Game>();
        gameList.add(gameOne);
        
        gameTwo = mock(Game.class);
        gameThree = mock(Game.class);
        gameList2 = new ArrayList<Game>();
        gameList2.add(gameTwo);
        gameList2.add(gameThree);
        
        roundList = new ArrayList<Round>();
        roundList.add(round);
        roundList.add(round2);
        
        when(brokerFactory.getRoundBroker()).thenReturn(roundBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
        when(roundBroker.getAllGamesByRoundId(1L)).thenReturn(gameList);
        when(roundBroker.getAllGamesByRoundId(2L)).thenReturn(gameList2);
        when(seasonBroker.findSeasonById(1L)).thenReturn(season);
        when(seasonBroker.getAllRoundsfromSeasonId(1L)).thenReturn(roundList);
        when(round.getId()).thenReturn(1L);
        when(round2.getId()).thenReturn(2L);
    }

   @Test
    public void testConstructor(){
        try {
            new GetAllGamesFromSeasonService(null);
            fail();
            
        } catch (ServiceException e){
            
        } 
        new GetAllGamesFromSeasonService(1L);
    }
  
    @Test
    public void testInit(){
        GetAllGamesFromSeasonService instance = new GetAllGamesFromSeasonService(1L);
        try {
            instance.init(null);
            fail();
           
        }catch (ServiceException e) {
            
        }
        instance.init(brokerFactory);
    }
    
    @Test
    public void testExecute() {
        System.out.println("execute test: ");
        GetAllGamesFromSeasonService instance = new GetAllGamesFromSeasonService(1L);
        instance.init(brokerFactory);
        List<Game> lista = instance.execute();
        assertEquals(3, lista.size());
        
              
    }
}
