package com.mycompany.sportstatsveiret;

import DAO.LeagueDao;
import DAO.SeasonDao;
import DAO.SportDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Veiret
 */
public class League {
    
    private final LeagueDao dao;
    
    public League(){
        this(new LeagueDao());
    }
    public League(LeagueDao dao){
        this.dao = dao;
    }
    
    public String getName() {
        return dao.getString("name");
    }
    
    public void setName(String name) {
        dao.setString("name", name);
    }
    @JsonIgnore
    public Sport getSport() {
        return new Sport (dao.parent(SportDao.class));
    }
    
    public void setSport(Sport sport) {
        SportDao sportDao = sport.getDao();
        if (sportDao.getId() == null){
            sportDao.save();
        }
        dao.setParent(sportDao);
    }
    public void addSeason(Season season){
        SeasonDao seasonDao = season.getDao();
        seasonDao.setParent(dao);
    }
    @JsonIgnore
    public LeagueDao getDao(){
        return dao;
    }
    @JsonIgnore
    public List<Season> getSeasons() {
        return dao.getAll(SeasonDao.class).stream()
                .map(dao -> new Season(dao))
                .collect(Collectors.toList());
    }
    public Long getId(){
        return dao.getLongId();
    }
}
