/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.TeamDao;
/**
 *
 * @author Simon
 */
public class Team{
    
    private final TeamDao dao;
    
    public Team(){
        this(new TeamDao());
    }
    
    public Team(TeamDao dao){
        this.dao = dao;
    }
    
    @JsonIgnore
    public TeamDao getDao(){
        return dao;
    }
    
    @JsonIgnore
    public Long getId() {
        return dao.getLong("id");
    }
    
    public void setSport(Sport sport) {
        dao.setLong("sport_id", sport.getId());
    }
    
    public void save() {
        dao.save();
    }
    
    public String getName() {
        return dao.getString("name");
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    
    @Override
    public String toString() {
        return getName() + " (id: " + getId() + ")";
    }
    
    public void setSeason(Season season){
        dao.setLong("season_id", season);
    }
}
