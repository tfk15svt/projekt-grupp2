/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowPercentOnArenaForOneSeason;
import Broker.ArenaBroker;
import Broker.BrokerFactory;
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
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class ShowPercentOnArenaForOneSeasonTest {
    private static Long seasonId;
    private static Long arenaId;
    private static BrokerFactory brokerFactory;
    private static ArenaBroker arenaBroker;
    private static List<Game> allGamesForOneArena;
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        arenaBroker = mock(ArenaBroker.class);
        seasonId = 1L;
        arenaId = 1L;
        allGamesForOneArena = new ArrayList<>();
        
        when(brokerFactory.getArenaBroker()).thenReturn(arenaBroker);
        when(arenaBroker.getAllGamesForOneArena(arenaId)).thenReturn(allGamesForOneArena);        
    }
    
    @Test
    public void testConstructor(){
        try{
            new ShowPercentOnArenaForOneSeason(seasonId, arenaId);
            new ShowPercentOnArenaForOneSeason(null, arenaId);
            new ShowPercentOnArenaForOneSeason(seasonId, null);
            new ShowPercentOnArenaForOneSeason(null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ShowPercentOnArenaForOneSeason s = new ShowPercentOnArenaForOneSeason(seasonId, arenaId);
        try{
            s.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        s.init(brokerFactory);
    }
    

    /**
     * Test of execute method, of class ShowPercentOnArenaForOneSeason.
     */
    @Test
    public void testExecute() {
        ShowPercentOnArenaForOneSeason s = new ShowPercentOnArenaForOneSeason(seasonId, arenaId);
        s.init(brokerFactory);
        System.out.println("Execute: " + s.execute());
        
    }
    
}
