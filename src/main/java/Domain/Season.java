/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.LeagueDao;
import DAO.SeasonDao;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 *
 * @author Veiret
 */
public class Season {
    @JsonIgnore
    private final SeasonDao dao;
    
    public Season() {
        this(new SeasonDao());
    }
    public Season(SeasonDao dao){
        this.dao = dao;
    }
    @JsonIgnore
    public Integer getYear(){
        return dao.getInteger("year");
    }
    public void setYear(Integer year){
        dao.setInteger("year", year);
    }
    @JsonIgnore
    public Boolean isSummer(){
        return dao.getBoolean("summer");
    }
    public void setSummer(Boolean summer){
        dao.setBoolean("summer", summer);
    }
    @JsonIgnore
    public SeasonDao getDao(){
        return dao;
    }
    public String getName(){
        return String.valueOf(getYear()) +
                (isSummer() ? "" : " - " + 
                (getYear() + 1));
    }
    @JsonIgnore
    public Long getId() {
        return dao.getLongId();
    }
    @JsonIgnore
    public void setMaxRounds (long rounds) {
        dao.set("maxround", rounds);
    }
    @JsonIgnore
    public Long getMaxRounds() {
        return dao.getLong("maxround");
    }
    @JsonIgnore
    public League getLeague(){
        return new League (dao.parent(LeagueDao.class));
    }
}
