package Broker;

import DAO.SeasonDao;
import Domain.Season;

/**
 *
 * @author Veiret
 */
public class SeasonBroker {
    public void saveSeaon(Season season){
        season.getDao().save();
    }
    public Season findSeasonById (Long id) {
        return new Season (SeasonDao.findById(id));
    }
    
    public Season create(){
        return new Season();
    }
}
