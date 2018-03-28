/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.TeamDao;
import DAO.TeamsSeasonsDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.Season;
import com.mycompany.sportstatsveiret.Team;

/**
 *
 * @author Veiret
 */
public class ConnectTeamToSeasonService extends Service {
    private final Long teamId;
    private final Long seasonId;
    public ConnectTeamToSeasonService(Long team, Long season){
        this.teamId = team;
        this.seasonId = season;
        
        if (this.teamId == null) {
            throw new ServiceException("Team Id is null");
        }
        if (this.seasonId == null) {
            throw new ServiceException("Season Id is null");
        }
    }

    /**
     *
     * @return
     */
    @Override
    public Boolean execute(){
        BrokerFactory brokerFactory = getBrokerFactory();
        TeamsSeasonsDao teamSeason = brokerFactory.getTeamSeasonBroker().create();
        Team team = brokerFactory.getTeamBroker().findTeamById(teamId);
        if (team == null) {
            throw new ServiceException("There is no team with that id");
        }
        Season season = brokerFactory.getSeasonBroker().findSeasonById(seasonId);
        if (season == null) {
            throw new ServiceException("There is no season with that id");
        }
        teamSeason.setSeason(season);
        teamSeason.setTeam(team);
        teamSeason.save();
        return true;
    }
}
