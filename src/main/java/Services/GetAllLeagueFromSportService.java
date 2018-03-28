/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SportBroker;
import DAO.LeagueDao;
import DAO.SportDao;
import DB.DbConn;
import com.mycompany.sportstatsveiret.League;
import com.mycompany.sportstatsveiret.Sport;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class GetAllLeagueFromSportService extends Service{
    private final Long sportId;
    public GetAllLeagueFromSportService (Long sportId) {
        this.sportId = sportId;
        if(this.sportId == null){
            throw new ServiceException("Sport id is null");
        }
    }
    @Override
    public List<League> execute() {
        SportBroker sportBroker = getBrokerFactory().getSportBroker();
        if (sportBroker.findById(sportId) == null) {
            throw new ServiceException("There is no sport with that id");
        }
        List<League> result = sportBroker.getAllLeaguesFromSportId(sportId);
        return result;
    }
    
}
