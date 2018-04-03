/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.List;
import sportstats.domain.Team;


/**
 *
 * @author Simon
 */
public class GetTeamsBySportIdService extends BaseService<List<Team>>{
    
    private final Long sportId;
    
    public GetTeamsBySportIdService(Long sportId){
        this.sportId = sportId;
    }
    
    @Override
    public List<Team> execute(){
        List<Team> result = getBrokerFactory().getTeamBroker().findAllTeamsBySportId(sportId);
        return result;
    }
}
