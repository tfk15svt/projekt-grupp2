/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Show;

import Services.Show.ShowTeamWinLossStatistics;
import Broker.BrokerFactory;
import Services.SetUpTestObjects;
import java.util.ArrayList;
import java.util.List;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Veiret
 */
public class ShowTeamWinLossStatisticsIT {
    
    public ShowTeamWinLossStatisticsIT() {
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
     * Test of execute method, of class ShowTeamWinLossStatistics.
     */
    @Test
    public void testExecute() {
        System.out.println("execute");
        List<Long> teamIds = new ArrayList<>();
        teamIds.add(SetUpTestObjects.getTeamId1());
        teamIds.add(SetUpTestObjects.getTeamId2());
        teamIds.add(SetUpTestObjects.getTeamId3());
        teamIds.add(SetUpTestObjects.getTeamId4());
        teamIds.add(SetUpTestObjects.getTeamId5());
        teamIds.add(SetUpTestObjects.getTeamId6());
        
        Boolean[] firstLastGoal = {false, false};
        Boolean[] fullOvertime = {true, true};
        Boolean[] homeAway = {true, true};
        ShowTeamWinLossStatistics instance = new ShowTeamWinLossStatistics(firstLastGoal, fullOvertime, 0, teamIds, homeAway);
        instance.init(new BrokerFactory());
        System.out.println("Services.ShowTeamWinLossStatisticsIT.testExecute() \n ");

        try {
            List<String> result = instance.execute();
            result.stream().forEach(str -> System.out.println(str));
        } catch (Exception e) {
        }
        
        
    }
    
}
