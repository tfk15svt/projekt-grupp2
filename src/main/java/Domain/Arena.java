/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.ArenaDao;
import DAO.TeamDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Veiret
 */
public class Arena {
    private final ArenaDao dao;
    
    public Arena(){
        this(new ArenaDao());
    }
    public Arena(ArenaDao dao){
        this.dao = dao;
    }
    @JsonIgnore
    public ArenaDao getDao() {
        return dao;
    }
    public void setArenaName(String arenaName){
        dao.setString("name", arenaName);
    }
    public String getArenaName(){
        return dao.getString("name");
    }
    @JsonIgnore
    public Team getTeam(){
        return new Team (dao.parent(TeamDao.class));
    }
    public void setTeam (Team team){
        dao.setParent(team.getDao()); //Lista?
    }
}
