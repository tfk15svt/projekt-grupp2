/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import Domain.Sport;
import Domain.Team;

/**
 *
 * @author Veiret
 */
public class AddTeamToSportService extends Service{
    private final String teamName;
    private final Long sportId;
    public AddTeamToSportService(String teamName, Long sportId){
        this.teamName = teamName;
        
        
        this.sportId = sportId;
        if (this.teamName == null){
            throw new ServiceException("Team is null");
        }
        if (this.sportId == null){
            throw new ServiceException("SportId is null");
        }
    }
    @Override
    public Team execute(){
        Team team = getBrokerFactory().getTeamBroker().create();
        team.setName(teamName);
        BrokerFactory brokerFactory = getBrokerFactory();
        Sport sport = brokerFactory.getSportBroker().findById(sportId);
        if (sport == null) {
            throw new ServiceException("No sport with that Id");
        }
        team.setSport(sport);
        brokerFactory.getTeamBroker().saveTeam(team);
        return team;
    }
    
}
