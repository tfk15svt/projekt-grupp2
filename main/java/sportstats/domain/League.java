/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.LeagueDao;
import sportstats.domain.dao.SeasonDao;
import sportstats.domain.dao.SportDao;

/**
 *
 * @author Simon
 */
public class League{
    
    private final LeagueDao dao;
    
    public League(){
        this(new LeagueDao());
    }
    
    public League(LeagueDao dao){
        this.dao = dao;
    }
    @JsonIgnore
    public LeagueDao getDao(){
        return dao;
    }
    
    public String getName() {
        return dao.getString("name");
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    @JsonIgnore
    public Sport getSport() {
        return new Sport(dao.parent(SportDao.class));
    }
    
    public void setSport(Sport sport) {
       SportDao sportDao = sport.getDao();
        dao.setParent(sportDao);
    }

    @JsonIgnore
    public List<Season> getSeasons(){
        return dao.getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season(seasonDao))
                .collect(Collectors.toList());
    }
    
    public void save(){
        dao.save();
    }
}
