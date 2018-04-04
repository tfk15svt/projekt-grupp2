/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.GameBroker;
import Broker.RoundBroker;
import Broker.SeasonBroker;
import DAO.GameDao;
import DAO.RoundDao;
import com.mycompany.sportstatsveiret.Game;
import com.mycompany.sportstatsveiret.Round;
import com.mycompany.sportstatsveiret.Season;
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
public class AddRoundToSeasonServiceTest {
    private Long nullInteger;
    private static BrokerFactory brokerFactory;
    private static GameBroker gameBroker;
    private static RoundBroker roundBroker;
    private static SeasonBroker seasonBroker;
    private static Season season;
    private static List<Round> roundList;
    private static Round round;
    private static Game game;
    private static RoundDao roundDao;
    @BeforeClass
    public static void setUpClass() {
        season = mock(Season.class);
        when(season.getMaxRounds()).thenReturn(5L);
        round = mock(Round.class);
        game = mock(Game.class);
        when(game.getDao()).thenReturn(mock(GameDao.class));
        roundList = new ArrayList<Round>();
        roundDao = mock(RoundDao.class);
        
        when(round.getDao()).thenReturn(roundDao);
        
        seasonBroker = mock(SeasonBroker.class);
        when(seasonBroker.findSeasonById(1L)).thenReturn(season);
        when(seasonBroker.getAllRoundsfromSeasonId(1L)).thenReturn(roundList);
        
        roundBroker = mock(RoundBroker.class);
        when(roundBroker.create()).thenReturn(round);
        
        gameBroker = mock(GameBroker.class);
        when(gameBroker.create()).thenReturn(game);
        brokerFactory = mock(BrokerFactory.class);
        when(brokerFactory.getGameBroker()).thenReturn(gameBroker);
        when(brokerFactory.getRoundBroker()).thenReturn(roundBroker);
        when(brokerFactory.getSeasonBroker()).thenReturn(seasonBroker);
    }
    @Test
    public void testConstructor() {
        try {
            new AddRoundToSeasonService(null, 3L);
            fail();
        } catch (ServiceException e){
        }
        try {
            new AddRoundToSeasonService(1L, nullInteger);
        } catch (ServiceException e){
        }
        new AddRoundToSeasonService(1L, 3L);
    }
    @Test
    public void testInit() {
        AddRoundToSeasonService service = new AddRoundToSeasonService(1L, 1L);
        try {
            service.init(null);
            fail();
        } catch (ServiceException e) {
        }
        service.init(brokerFactory);
    }
    /**
     * Test of execute method, of class AddRoundToSeasonService.
     */
    @Test
    public void testExecute() {
        AddRoundToSeasonService service = new AddRoundToSeasonService(1L, 4L);
        service.init(brokerFactory);
       // AddRoundToSeasonService service2 = new AddRoundToSeasonService(2L, 4L);
       // service2.init(brokerFactory);
        try {
          //  service2.execute();
           // fail();
        } catch (ServiceException e) {
        }
        service.execute();
        
    }
    
}
