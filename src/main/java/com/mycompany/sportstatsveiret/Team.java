/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.SportDao;
import DAO.TeamDao;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Veiret
 */
public class Team {
    private final TeamDao dao;
    public Team(){
        this(new TeamDao());
    }
    public Team(TeamDao dao){
        this.dao = dao;
    }
    public TeamDao getDao(){
        return dao;
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
    public Sport getSport(){
        return new Sport(dao.parent(SportDao.class));
    }
}
