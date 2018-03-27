/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.ArenaDao;

/**
 *
 * @author Simon
 */
public class Arena{
    
    private final ArenaDao dao;
    
    public Arena(){
       this(new ArenaDao()); 
    }
    
    public Arena(ArenaDao dao){
        this.dao = dao;
    }
    
    public String getName() {
        return dao.getString("name");
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    
    public ArenaDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
    
}
