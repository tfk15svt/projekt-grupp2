/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.LeagueDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Sport;

/**
 *
 * @author Veiret
 */

//hejhejhej
public class AddLeagueToSportService extends Service{
    private final Long sportId;
    private final League league;
    public AddLeagueToSportService(Long sportId, League league){
        this.sportId = sportId;
        if (sportId == null){
            throw new ServiceException("Sport is null");
        }
        this.league = league;
        if(league == null){
            throw new ServiceException("League is null");
        }
    }
    @Override
    public Boolean execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        Sport sport = brokerFactory.getSportBroker().findById(sportId);
        if (sport == null){
            throw new ServiceException("There is no sport with that Id");
        }
        league.setSport(sport);
        brokerFactory.getLeagueBroker().saveLeague(league);
        return true;
    }
    
}
