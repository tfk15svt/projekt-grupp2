/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;

/**
 *
 * @author Veiret
 */
public class AddSeasonToLeagueService extends Service{
    private final Season season;
    private final Long leagueId;
    public AddSeasonToLeagueService(Season season, Long leagueId){
        this.season = season;
        if (season == null){
            throw new ServiceException("Season is null");
        }
        this.leagueId = leagueId;
        if (leagueId == null){
            throw new ServiceException("League id is null");
        }
    }
    public Boolean execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        League league = brokerFactory.getLeagueBroker().findLeagueById(leagueId);
        if (league == null) {
            throw new ServiceException("No league with that ID");
        }
        league.addSeason(season);
        brokerFactory.getSeasonBroker().saveSeaon(season);
        return true;
    }
    
}
