package Domain;

import DAO.SportDao;
import com.fasterxml.jackson.annotation.JsonIgnore;


import org.javalite.activejdbc.Model;

public class Sport {
    
    private final SportDao dao;
    
    public Sport(){
        this(new SportDao());
    }
    
    public Sport(SportDao dao){
        this.dao = dao;
    }
    @JsonIgnore
    public SportDao getDao(){
        return dao;
    }
    public String getName() {
        return dao.getString("name");
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    public Long getId(){
        return dao.getLongId();
    }
}
