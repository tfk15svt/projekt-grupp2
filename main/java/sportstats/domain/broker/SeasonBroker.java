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

/**
 *
 * @author Simon
 */
public class SeasonBroker {
    
    public Season create(){
        return new Season();
    }
    
    public List<Season> findAllSeasonsByLeagueId(Long leagueId){
        LeagueDao leagueDao = LeagueDao.findById(leagueId);
        leagueDao.getAll(SeasonDao.class);
        List<Season> result = leagueDao.getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao)seasonDao))
                .collect(Collectors.toList());
        return result;
    }
    
    public Season findSeasonById(Long seasonId){
        return new Season(SeasonDao.findById(seasonId));
    }
}
