/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
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
public class ListTeamsLongestStreaksIT {
    Integer startDate = 20190424;
    Integer endDate = 20190432;
    
    @BeforeClass
    public static void setUpClass() {
        SetUpTestObjects.setUp();
    }
    
    @AfterClass
    public static void tearDownClass() {
        SetUpTestObjects.tearDown();
    }

    @Test
    public void testExecute() {
        ListTeamsLongestStreaks instance = new ListTeamsLongestStreaks(SetUpTestObjects.getTeamId3(), startDate, endDate);
        instance.init(new BrokerFactory());
        System.out.println("Streak: " + instance.execute());
        
        
    } 
}
