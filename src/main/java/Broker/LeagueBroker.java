/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.LeagueDao;
import DAO.SeasonDao;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class LeagueBroker {
    public void saveLeague(League league){
        LeagueDao leagueDao = league.getDao();
        leagueDao.save();
    }
    public League findLeagueById(Long id){
        return new League(LeagueDao.findById(id));
    }
    public List<Season> getAllSeasonsFromLeagueId (Long id) {
        LeagueDao leagueDao = LeagueDao.findById(id);
        List<Season> result = leagueDao.getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao) seasonDao))
                .collect(Collectors.toList());
        return result;
    }
    
    public League create(){
        return new League();
    }
}
