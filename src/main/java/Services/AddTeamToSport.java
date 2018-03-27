/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Sport;
import com.mycompany.sportstatsveiret.Team;

/**
 *
 * @author Veiret
 */
public class AddTeamToSport extends Service{
    private String name;
    private final Long sportId;
    public AddTeamToSport(String name, Long sportId){
        this.name = name;
        
        
        this.sportId = sportId;
        if (this.name == null){
            throw new ServiceException("Team is null");
        }
        if (this.sportId == null){
            throw new ServiceException("SportId is null");
        }
    }
    @Override
    public Boolean execute(){
        Team team = getBrokerFactory().getTeamBroker().create();
        team.setName(name);
        BrokerFactory brokerFactory = getBrokerFactory();
        Sport sport = brokerFactory.getSportBroker().findById(sportId);
        if (sport == null) {
            throw new ServiceException("No sport with that Id");
        }
        team.setSport(sport);
        brokerFactory.getTeamBroker().saveTeam(team);
        return true;
    }
    
}
