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
    private final int seasonYear;
    private final Long leagueId;
    
    public AddSeasonToLeagueService(int seasonYear, Long leagueId){
        this.seasonYear = seasonYear;
        if (seasonYear < 1){
            throw new ServiceException("Season is null");
        }
        this.leagueId = leagueId;
        if (leagueId == null){
            throw new ServiceException("League id is null");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Season execute() {
        BrokerFactory brokerFactory = getBrokerFactory();
        Season season = brokerFactory.getSeasonBroker().create();
        season.setYear(seasonYear);
        League league = brokerFactory.getLeagueBroker().findLeagueById(leagueId);
        if (league == null) {
            throw new ServiceException("No league with that ID");
        }
        league.addSeason(season);
        brokerFactory.getSeasonBroker().saveSeaon(season);
        return season;
    }
    
}
