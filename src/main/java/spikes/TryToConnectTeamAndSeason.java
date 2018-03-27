/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import Broker.BrokerFactory;
import DAO.SeasonDao;
import DAO.TeamDao;
import DAO.TeamsSeasonsDao;
import DB.DbConn;
import Services.ConnectTeamToSeasonService;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;
import com.mycompany.sportstatsveiret.Sport;
import com.mycompany.sportstatsveiret.Team;

/**
 *
 * @author Veiret
 */
public class TryToConnectTeamAndSeason {
    public static void main(String[] args){
        DbConn conn = new DbConn();
        conn.open();
        Sport sport = new Sport();
        sport.setName("sport");
        sport.getDao().save();
        
        Team team = new Team();
        team.setName("team");
        team.setSport(sport);
        team.getDao().save();
        
        League league = new League();
        league.setName("liga");
        league.setSport(sport);
        league.getDao().save();
        
        Season season = new Season();
        league.addSeason(season);
        season.getDao().save();
        
        TeamsSeasonsDao teamsSeasons = new TeamsSeasonsDao();
        teamsSeasons.setParent(team.getDao());
        teamsSeasons.setParent(season.getDao());
        teamsSeasons.save();
        
        
        //int seasonInt = (int) league.getDao().getId();
        //int realSeasonInt = (int) sport.getDao().getAll(TeamsSeasonsDao.class).get(0).parent(SeasonDao.class).getId();
                
        //int sportInt = (int) sport.getDao().getId();
        //int realSportInt = (int) season.getDao().getAll(TeamsSeasonsDao.class).get(0).parent(TeamDao.class).getId();
        conn.close();
    }
}
