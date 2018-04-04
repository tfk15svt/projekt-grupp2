package Broker;

import DAO.RoundDao;
import DAO.SeasonDao;
import com.mycompany.sportstatsveiret.Round;
import com.mycompany.sportstatsveiret.Season;
import java.util.List;
import java.util.stream.Collectors;

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
    public List<Round> getAllRoundsfromSeasonId(Long id){
        return SeasonDao.findById(id).getAll(RoundDao.class)
                .stream().map(dao -> new Round(dao))
                .collect(Collectors.toList());
    }
    public Season create(){
        return new Season();
    }
}
