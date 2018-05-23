/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowArenaPercentAndTeamGoalsOnDateInterval;
import Broker.BrokerFactory;
import Services.SetUpTestObjects;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Simon
 */
public class ShowArenaPercentAndTeamGoalsOnDateIntervalIT {
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    /**
     * Test of execute method, of class ShowArenaPercentAndTeamGoalsOnDateInterval.
     */
    @Test
    public void testExecute() {
        ShowArenaPercentAndTeamGoalsOnDateInterval s = new ShowArenaPercentAndTeamGoalsOnDateInterval(SetUpTestObjects.getArenaId1(), SetUpTestObjects.getSeasonId2(), 20190432, 20190433);
        s.init(new BrokerFactory());
        System.out.println("EX: " + s.execute());
    }
    
}
