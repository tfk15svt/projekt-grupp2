/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.ArenaDao;
import DAO.TeamDao;
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
    public ArenaDao getDao() {
        return dao;
    }
    public String getName(){
        return dao.getString("name");
    }
    public Team getTeam(){
        return new Team (dao.parent(TeamDao.class));
    }
    public void setTeam (Team team){
        dao.setParent(team.getDao()); //Lista?
    }
}
