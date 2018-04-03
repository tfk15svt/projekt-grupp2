/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import java.util.Date;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.GameDao;
import sportstats.domain.dao.TeamDao;
/**
 *
 * @author Simon
 */
public class Game{
    
    private final GameDao dao;
    
    public Game(){
        this(new GameDao());
    }
    
    public Game(GameDao dao){
        this.dao = dao;
    }
    
    public void setSpectators(int spectators) throws IllegalArgumentException{
       if(spectators < 0 || spectators > 100000){
           throw new IllegalArgumentException("Negative number entered or to high number entered.");
        }
        else
            dao.setInteger("spectators" , spectators);
    }
    
    public int getSpectators(){
       return dao.getInteger("spectators");
    }
    
    public void setDate(Date date){
        dao.setDate("date" , date);
    }
    
    public Date getDate(){
        return dao.getDate("date");
    }
    
    public Team getHomeTeam() {
        return new Team(dao.get(TeamDao.class, "id = ?", dao.getLong("home_team_id")).get(0));
    }

    public Team getAwayTeam() {
        return new Team(dao.get(TeamDao.class, "id = ?", dao.getLong("away_team_id")).get(0));
    }
    
    public void setHomeTeam(Team homeTeam){
        if(homeTeam.getId() == null){
            homeTeam.save();
        }
        dao.setLong("home_team_id", homeTeam.getId());
    }
    
    public void setAwayTeam(Team awayTeam){
        if(awayTeam.getId() == null){
            awayTeam.save();
        }
        dao.setLong("away_team_id", awayTeam.getId());
    }
    
    public GameDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
}
