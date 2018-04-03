/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.League;
import sportstats.domain.Sport;

/**
 *
 * @author Simon
 */
public class AddLeagueToOneSportService extends BaseService<League>{
    private final Long sportId;
    private final String leagueName;
    
    public AddLeagueToOneSportService(String leagueName, Long sportId){
        if(leagueName == null){
            throw new SportstatsServiceException("league cannot be null.");
        }
        if(sportId == null){
            throw new SportstatsServiceException("Sport cannot be null. ");
        }
        this.leagueName = leagueName;
        this.sportId = sportId;
    }
    
    @Override
    public League execute(){
        League league = getBrokerFactory().getLeagueBroker().create();
        league.setName(leagueName);
        Sport sport = getBrokerFactory().getSportBroker().findById(sportId);
        league.setSport(sport);
        league.save();
        return league;
    }
}
