/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.LeagueDao;
import DAO.SeasonDao;
import DAO.TeamDao;
import DAO.TeamsSeasonsDao;
import DB.DbConn;
import Domain.League;
import Domain.Season;
import Domain.Sport;
import Domain.Team;
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
public class ConnectTeamToSeasonServiceIT {
    private static Sport sport;
    private static League league;
    private static Team team;
    private static Season season;
    private static Long expectedTeamId;
    private static Long expectedSeasonId;
    @BeforeClass
    public static void setUp(){
        DbConn.staticOpen();
        sport = new Sport();
        sport.setName("sportTeamSeason");
        sport.getDao().save();
        
        team = new Team();
        team.setName("teamTeamSeason");
        team.setSport(sport);
        team.getDao().save();
        expectedTeamId = team.getDao().getLongId();
        
        league = new League();
        league.setName("ligaTeamSeason");
        league.setSport(sport);
        league.getDao().save();
        
        season = new Season();
        league.addSeason(season);
        season.getDao().save();
        expectedSeasonId = season.getDao().getLongId();
        DbConn.staticClose();
    }
    @AfterClass
    public static void tearDown() {
        DbConn.staticOpen();
        season.getDao().delete();
        league.getDao().delete();
        team.getDao().delete();
        sport.getDao().delete();
        DbConn.staticClose();
    }
    @Test
    public void testSomeMethod() {
        
        ConnectTeamToSeasonService connect = new ConnectTeamToSeasonService(expectedTeamId, expectedSeasonId);
        connect.init(new BrokerFactory ());
        connect.execute();
        
        DbConn.staticOpen();
        TeamsSeasonsDao teamSeasonFromTeam = TeamDao.findById(expectedTeamId).getAll(TeamsSeasonsDao.class).get(0);
        TeamsSeasonsDao teamSeasonFromSeason = SeasonDao.findById(expectedSeasonId).getAll(TeamsSeasonsDao.class).get(0);
        
        assertEquals(expectedTeamId, teamSeasonFromTeam.parent(TeamDao.class).getLongId());
        assertEquals(expectedSeasonId, teamSeasonFromTeam.parent(SeasonDao.class).getLongId());
        assertEquals(expectedTeamId, teamSeasonFromSeason.parent(TeamDao.class).getLongId());
        assertEquals(expectedSeasonId, teamSeasonFromSeason.parent(SeasonDao.class).getLongId());
        assertEquals(teamSeasonFromTeam.getLongId(), teamSeasonFromSeason.getLongId());
        
        teamSeasonFromTeam.delete();
        DbConn.staticClose();
    }
    
}
