/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;
import com.mycompany.sportstatsveiret.Sport;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class SecondShot {
    
    public static void main(String[] args) {
        DbConn.staticOpen();
        Season season = new Season();
        season.setYear(2016);
        season.setSummer(Boolean.TRUE);
        System.out.println(season.getName());
        season.setSummer(Boolean.FALSE);
        System.out.println(season.getName());
        
        Season testOneSeason = new Season();
        testOneSeason.setYear(2017);
        testOneSeason.setSummer(Boolean.TRUE);
        Season testTwoSeason = new Season();
        testTwoSeason.setYear(2018);
        testTwoSeason.setSummer(Boolean.TRUE);
        Season testThreeSeason = new Season();
        testThreeSeason.setYear(2019);
        testThreeSeason.setSummer(Boolean.TRUE);
        
        Sport testSport = new Sport();
        testSport.setName("testSport");
        testSport.getDao().save();
        
        League testLeague = new League();
        testLeague.setName("testLiga");
       
        testLeague.setSport(testSport);
        
        testLeague.getDao().save();
        
        testLeague.addSeason(testOneSeason);
        testLeague.addSeason(testTwoSeason);
        testLeague.addSeason(testThreeSeason);
        
        testOneSeason.getDao().save();
        testTwoSeason.getDao().save();
        testThreeSeason.getDao().save();
        
        

        List<Season> listaAvSeason = testLeague.getSeasons();
        System.out.println("Antal säsonger i testLeague: " + listaAvSeason.size());
        
        
        testOneSeason.getDao().delete();
        testTwoSeason.getDao().delete();
        testThreeSeason.getDao().delete();
        testLeague.getDao().delete();
        testSport.getDao().delete();

        DbConn.staticClose();
    }


}
