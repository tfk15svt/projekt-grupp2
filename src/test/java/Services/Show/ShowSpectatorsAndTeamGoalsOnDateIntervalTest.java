/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowSpectatorsAndTeamGoalsOnDateInterval;
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
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class ShowSpectatorsAndTeamGoalsOnDateIntervalTest {
    private static BrokerFactory brokerFactory;
    private static LeagueBroker leagueBroker;
    private static List<Game> listOfGames;
    private static Long leagueId;
    private static Integer startDate;
    private static Integer endDate;
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        leagueBroker = mock(LeagueBroker.class);
        listOfGames = new ArrayList<>();
        startDate = 1;
        endDate = 2;
        leagueId = 1L;
        
        when(brokerFactory.getLeagueBroker()).thenReturn(leagueBroker);
        when(leagueBroker.getAllGames(leagueId)).thenReturn(listOfGames);
        
    }
    
    @Test
    public void testConstructor(){
        try{
            new ShowSpectatorsAndTeamGoalsOnDateInterval(null, startDate, endDate);
            new ShowSpectatorsAndTeamGoalsOnDateInterval(leagueId, null, endDate);
            new ShowSpectatorsAndTeamGoalsOnDateInterval(leagueId, startDate, null);
            new ShowSpectatorsAndTeamGoalsOnDateInterval(null, null, null);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ShowSpectatorsAndTeamGoalsOnDateInterval s = new ShowSpectatorsAndTeamGoalsOnDateInterval(leagueId, startDate, endDate);
        try{
            s.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        s.init(brokerFactory);
    }

    /**
     * Test of execute method, of class ShowSpectatorsAndTeamGoalsOnDateInterval.
     */
    @Test
    public void testExecute() {
        ShowSpectatorsAndTeamGoalsOnDateInterval s = new ShowSpectatorsAndTeamGoalsOnDateInterval(leagueId, startDate, endDate);
        s.init(brokerFactory);
        System.out.println("EXE: " + s.execute());
    }
    
}
