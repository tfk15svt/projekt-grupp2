/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;

import Services.Add.AddSeasonToLeagueService;
import Broker.BrokerFactory;
import DAO.SeasonDao;
import DB.DbConn;
import Domain.League;
import Domain.Season;
import Domain.Sport;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Veiret
 */
public class AddSeasonToLeagueServiceIT {
    private static Sport sport;
    private static League league;
    private static Season season1;
    private static Season season2;
    private static Season season3;
    private static Long leagueId;
    private static List<Season> list1;
    private static List<Season> list2;
    private static List<Season> list3;
    @BeforeClass
    public static void setUp(){
        // Create test objects
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("sportSeasonLeagueIT");
        sport.getDao().save();
        league = new League();
        league.setName("leagueSeasonLeagueIT");
        league.setSport(sport);
        
        
        league.getDao().save();
        leagueId = league.getDao().getLongId();
        list1 = league.getDao().getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao) seasonDao))
                .collect(Collectors.toList());
        
    }
    @AfterClass
    public static void tearDown(){
        // Delete test object
        league.getDao().getAll(SeasonDao.class).get(2).delete();
        league.getDao().getAll(SeasonDao.class).get(1).delete();
        league.getDao().getAll(SeasonDao.class).get(0).delete();
        league.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testExecute() {
        
        AddSeasonToLeagueService instance1 = new AddSeasonToLeagueService(1, leagueId);
        instance1.init(new BrokerFactory());
        instance1.execute();
        
        
        league.getDao().save();
        list2 = league.getDao().getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao) seasonDao))
                .collect(Collectors.toList());
    
        AddSeasonToLeagueService instance2 = new AddSeasonToLeagueService(2, leagueId);
        instance2.init(new BrokerFactory());
        instance2.execute();
        
       
        league.getDao().save();
        list3 = league.getDao().getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao) seasonDao))
                .collect(Collectors.toList());
    
        AddSeasonToLeagueService instance3 = new AddSeasonToLeagueService(3, leagueId);
        instance3.init(new BrokerFactory());
        instance3.execute();
        
        
        
    }
    
}
