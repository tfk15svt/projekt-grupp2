/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.SportDao;
import DAO.TeamDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Veiret
 */
public class Team {
    @JsonIgnore
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
    public Long getId () {
        return dao.getLongId();
    }
    public String getName(){
        return dao.getString("name");
    }
    public void setName (String name){
        dao.setString ("name", name);
    }
    public void setSport(Sport sport){
        dao.setParent(sport.getDao());
    }
    @JsonIgnore
    public Sport getSport(){
        return new Sport(dao.parent(SportDao.class));
    }
}
