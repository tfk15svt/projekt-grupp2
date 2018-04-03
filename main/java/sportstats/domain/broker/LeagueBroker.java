/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import java.util.stream.Collectors;
import sportstats.domain.League;
import sportstats.domain.Season;
import sportstats.domain.dao.LeagueDao;
import sportstats.domain.dao.SeasonDao;
import sportstats.domain.dao.SportDao;

/**
 *
 * @author Simon
 */
public class LeagueBroker {
    
    public List<League> findAllLeaguesBySportId(Long sportId){
        SportDao sportDao = SportDao.findById(sportId);
        
        List<League> result = sportDao.getAll(LeagueDao.class).stream()
                .map(leagueDao -> new League((LeagueDao)leagueDao))
                .collect(Collectors.toList());
        return result;
    }
    
    public League create(){
        return new League();
    }
    
    public League findLeagueById(Long sportId){
        return new League(LeagueDao.findById(sportId));
    }
    
    
}
