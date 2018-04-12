/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Result;
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
public class GetBiggestWinLoseForTwoTeamsServiceIT {

    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }

    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    /**
     * Test of execute method, of class GetBiggestWinLoseForTwoTeamsService.
     */
    @Test
    public void testExecute() {
        Long teamId1 = SetUpTestObjects.getTeamId1();
        Long teamId2 = SetUpTestObjects.getTeamId2();
        GetBiggestWinLoseForTwoTeamsService gbw = new GetBiggestWinLoseForTwoTeamsService(teamId1, teamId2);
        gbw.init(new BrokerFactory());
        System.out.println("Biggest WIN: " + gbw.execute());
    }

}
