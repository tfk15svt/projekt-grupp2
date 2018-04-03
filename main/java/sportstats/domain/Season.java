/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import sportstats.domain.dao.LeagueDao;
import sportstats.domain.dao.SeasonDao;

/**
 *
 * @author Simon
 */
public class Season{
    
    private final SeasonDao dao;
    
    public Season(){
        this(new SeasonDao());
    }
 
    public Season(SeasonDao dao) {
        this.dao = dao;
    }
 
    public void setYear(int year) throws IllegalArgumentException{
        if(year < 0){
            throw new IllegalArgumentException("Negative number entered.");
        }
        else
            dao.setInteger("year", year);
    }
 
    public int getYear(){
        return dao.getInteger("year");
    }
   
    public void setSummer(boolean summer){
        dao.setBoolean("summer", summer);
    }
  
    public boolean isSummer(){
        return dao.getBoolean("summer");
    }
  
    public String getName() {
        return String.valueOf(getYear()) + 
                (isSummer() ? "" : " - " + (getYear() + 1));
    }
   
    public void setLeague(League league){
        LeagueDao leagueDao = league.getDao();
        dao.setParent(leagueDao);
    }
    @JsonIgnore
    public League getLeague(){
        return new League(dao.parent(LeagueDao.class));
    }
    @JsonIgnore
    public SeasonDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
}
