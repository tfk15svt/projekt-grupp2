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
import static org.mockito.Mockito.*;

/**
 *
 * @author Simon
 */
public class ListTeamsLongestStreaksTest {
    private static Long teamId;
    private static Integer startDate;
    private static Integer endDate;
    private static BrokerFactory brokerFactory;
    
    
    @BeforeClass
    public static void setUpClass() {
        brokerFactory = mock(BrokerFactory.class);
        teamId = 1L;
        startDate = 20180424;
        endDate = 20180426;
    }
    
    @Test
    public void testConstructor(){
        try{
            new ListTeamsLongestStreaks(teamId, startDate, endDate);
        }catch(ServiceException e){
            e.getMessage();
        }
    }
    
    @Test
    public void testInit(){
        ListTeamsLongestStreaks instance = new ListTeamsLongestStreaks(teamId, startDate, endDate);
        try{
            instance.init(null);
        }catch(ServiceException e){
            e.getMessage();
        }
        instance.init(brokerFactory);
    }

    @Test
    public void testExecute() {
        
    }
    
}
