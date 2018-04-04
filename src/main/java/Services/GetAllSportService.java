/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DAO.SportDao;
import DB.DbConn;
import Domain.Sport;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class GetAllSportService extends Service{

    /**
     *
     * @return
     */
    @Override
    public List<Sport> execute(){
        List<Sport> result = getBrokerFactory().getSportBroker().getAll();
        return result;
    }
}
