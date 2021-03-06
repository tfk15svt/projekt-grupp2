/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;

import Broker.BrokerFactory;
import DAO.LeagueDao;
import DB.DbConn;
import Domain.League;
import Domain.Sport;
import Services.Service;
import Services.ServiceException;

/**
 *
 * @author Veiret
 */

//hejhejhej
public class AddLeagueToSportService extends Service{
    private final Long sportId;
    private final String leagueName;
    
    public AddLeagueToSportService(Long sportId, String leagueName){
        this.sportId = sportId;
        if (sportId == null){
            throw new ServiceException("Sport is null");
        }
        this.leagueName = leagueName;
        if(leagueName == null){
            throw new ServiceException("League is null");
        }
    }
    @Override
    public League execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        League league = brokerFactory.getLeagueBroker().create();
        league.setName(leagueName);
        Sport sport = brokerFactory.getSportBroker().findById(sportId);
        if (sport == null){
            throw new ServiceException("There is no sport with that Id");
        }
        league.setSport(sport);
        brokerFactory.getLeagueBroker().saveLeague(league);
        return league;
    }
    
}
