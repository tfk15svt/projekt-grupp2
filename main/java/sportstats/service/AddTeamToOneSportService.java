/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.db.DBConn;
import sportstats.domain.Sport;
import sportstats.domain.Team;
import sportstats.domain.broker.BrokerFactory;
import sportstats.domain.dao.SportDao;
import sportstats.domain.dao.TeamDao;

/**
 *
 * @author Simon
 */
public class AddTeamToOneSportService extends BaseService{
    private final Long sportId;
    private final String teamName;
    
    public AddTeamToOneSportService(String teamName, Long sportId){
        if(teamName == null){
            throw new SportstatsServiceException("Team should not bu null");
        }
        if(sportId == null){
            throw new SportstatsServiceException("ID cannot be null");
        }
        this.teamName = teamName;
        this.sportId = sportId;
    }
    
    /**public void init(DBConn conn, BrokerFactory brokerFactory){
        this.conn = conn;
        this.brokerFactory = brokerFactory;
    }*/
    
    @Override
    public Team execute(){
        Team team = getBrokerFactory().getTeamBroker().create();
        team.setName(teamName);
        Sport sport = getBrokerFactory().getSportBroker().findById(sportId);
        team.setSport(sport);
        team.save();
        return team;
    }
}
