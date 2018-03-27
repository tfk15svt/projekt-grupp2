/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.LeagueBroker;
import DAO.LeagueDao;
import DAO.SeasonDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Season;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class GetAllSeasonsFromLeagueService extends Service{
    private Long leagueId;
    public GetAllSeasonsFromLeagueService(Long leagueId) {
        this.leagueId = leagueId;
        if (leagueId == null) {
            throw new ServiceException("league id is null");
        }
    }
    public List<Season> execute() {
        LeagueBroker leagueBroker = getBrokerFactory().getLeagueBroker();
        if(leagueBroker.findLeagueById(leagueId) == null){
            throw new ServiceException("There is no league with that id");
        }
        List<Season> result = leagueBroker.getAllSeasonsFromLeagueId(leagueId);
        return result;
    }
    
}
