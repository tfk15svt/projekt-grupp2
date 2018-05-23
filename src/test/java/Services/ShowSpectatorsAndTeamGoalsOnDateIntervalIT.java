/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
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
public class ShowSpectatorsAndTeamGoalsOnDateIntervalIT {
    
    public ShowSpectatorsAndTeamGoalsOnDateIntervalIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }
    /**
     * Test of execute method, of class ShowSpectatorsAndTeamGoalsOnDateInterval.
     */
    @Test
    public void testExecute() {
        ShowSpectatorsAndTeamGoalsOnDateInterval s = new ShowSpectatorsAndTeamGoalsOnDateInterval(SetUpTestObjects.getLeagueId(), 20190432, 20190433);
        s.init(new BrokerFactory());
        System.out.println("EXE: " + s.execute());
    }
}
