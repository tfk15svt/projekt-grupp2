/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import java.util.List;
import java.util.stream.Collectors;
import sportstats.domain.Team;
import sportstats.domain.dao.TeamDao;

/**
 *
 * @author Simon
 */
public class TeamBroker {
    
    public Team findById(Long teamId){
        return new Team(TeamDao.findById(teamId));
    }
    
    public Team create() {
        return new Team(new TeamDao());
    }
    
    public List<Team> findAllTeamsBySportId(Long sportId){
        List<Team> result = TeamDao.find("sport_id = ?", sportId).stream()
        .map(teamDao -> new Team((TeamDao)teamDao))
        .collect(Collectors.toList());
        return result;
    }
}
