package Broker;

import DAO.RoundDao;
import DAO.SeasonDao;
import DAO.TeamDao;
import DAO.TeamsSeasonsDao;

import Domain.Round;
import java.util.List;
import java.util.stream.Collectors;
import Domain.Season;
import Domain.Team;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    public List<Team> getAllTeamsFromSeasonId(Long id) {
        TeamBroker teamBroker = new TeamBroker();
        List<TeamsSeasonsDao> teamSeasonsFromSeason = SeasonDao.findById(id).getAll(TeamsSeasonsDao.class);
        List<Team> teamList = teamSeasonsFromSeason.stream().map(dao -> teamBroker.findTeamById(dao.getLong("team_id"))).collect(Collectors.toList());
        
        return teamList;
    }
    public Season create(){
        return new Season();
    }
    
    public boolean seasonExists (Long id){
        return SeasonDao.findById(id) != null;
    }

   
    
    
}
