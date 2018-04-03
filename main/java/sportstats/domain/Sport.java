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
import sportstats.domain.dao.SportDao;

/**
 *
 * @author Simon
 */
public class Sport{
    
    private final SportDao dao;
    
    public Sport(){
        this(new SportDao());
    }
    
    public Sport(SportDao dao){
        this.dao = dao;
    }
    
    public Long getId() {
        return dao.getLong("id");
    }
    
    @JsonIgnore
    public SportDao getDao(){
        return dao;
    }
    
    public String getName() {
        return dao.getString("name");
    }
    
    public void save(){
        dao.save();
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    
    @JsonIgnore
    public List<League> getLeagues(){
        return dao.getAll(LeagueDao.class).stream()
                .map(leagueDao -> new League(leagueDao))
                .collect(Collectors.toList());
    }
    
}
