/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.spikes;

import java.util.ArrayList;
import java.util.List;
import sportstats.db.DBConn;
import sportstats.domain.Sport;
import static sportstats.db.DBConn.*;
import sportstats.domain.League;
import sportstats.domain.dao.SportDao;
import sportstats.service.GetAllLeaguesForOneSportService;
import sportstats.service.GetAllSportsService;
import sportstats.service.GetTeamsBySportIdService;

/**
 *
 * @author Simon
 */
public class FirstShot {
    
    public static void main(String [] args){
        GetAllSportsService allSports = new GetAllSportsService();
        List<Sport> listOfSports = allSports.execute();
        
        System.out.println("Sporter: ");
        for(Sport s : listOfSports){
            System.out.println("SportNamn: " + s.getName() + " " + s.getId());
        }  
        
       
        DBConn.open();
        SportDao sportDao = SportDao.findById(20);
        Sport sport = new Sport(sportDao);
        DBConn.close();
        GetAllLeaguesForOneSportService gl = new GetAllLeaguesForOneSportService(2L);
        List<League> leagues = gl.execute();
            System.out.println("Ligor me sportid 2o:");
            for(League l : leagues ){
                System.out.println("Liganamn: " + l.getName());
            }
            
        
        GetTeamsBySportIdService gt = new GetTeamsBySportIdService(2L);
        System.out.println("LLAG: " + gt.execute());
    }
  
}
