/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Services.Get.GetAllGamesFromSeasonService;
import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Game;
import Domain.League;
import Domain.Round;
import Domain.Season;
import Domain.Sport;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Peeftw
 */
public class GetAllGamesFromSeasonServiceIT {
    private static Sport sport;
    private static League league;
    private static Season season;
    private static Round round1;
    private static Round round2;
    private static Game game1;
    private static Game game2;
    private static Game game3;
    private static Long roundOneId;
    private static Long roundTwoId;
    private static Long seasonId;
    
    public GetAllGamesFromSeasonServiceIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("Fotboll");
        sport.getDao().save();
      
        league = new League();
        league.setName("Premier League");
        league.setSport(sport);
        league.getDao().save();
        
        season = new Season();
        league.addSeason(season);
        season.getDao().save();
        seasonId = season.getId();
        
        round1 = new Round();
        round1.setRoundNumber(1);
        round1.setSeason(season);
        round1.getDao().save();
        roundOneId = round1.getId();
        
        round2 = new Round();
        round2.setRoundNumber(2);
        round2.setSeason(season);
        round2.getDao().save();
        roundTwoId = round2.getId();
     
        game1 = new Game();
        game1.setRound(round1);
        game1.getDao().save();
        
        game2 = new Game();
        game2.setRound(round2);
        game2.getDao().save();
        
        game3 = new Game();
        game3.setRound(round2);
        game3.getDao().save();
    }
    
    @AfterClass
    public static void tearDownClass() {
        game3.getDao().delete();
        game2.getDao().delete();
        game1.getDao().delete();
        
        round2.getDao().delete();
        round1.getDao().delete();
        
        season.getDao().delete();
        
        league.getDao().delete();
        
        sport.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testExecute() {    
        GetAllGamesFromSeasonService instance = new GetAllGamesFromSeasonService(seasonId);
        instance.init(new BrokerFactory());
        assertEquals(3, instance.execute().size());
        
        
    }
    
}
