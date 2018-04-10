/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.ArenaDao;
import DAO.GameDao;
import DAO.ResultDao;
import DAO.RoundDao;
import DAO.TeamDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.javalite.activejdbc.Model;

/**
 *
 * @author Veiret
 */
public class Game {
    private final GameDao dao;
    public Game(){
        this(new GameDao());
    }
    public Game(GameDao dao){
        this.dao = dao;
    }
    public void setName(String name){
        dao.setString("name", name);
    }
    public String getName(){
        return dao.getString("name");
    }
    public void setResult(Result result){
        ResultDao resultDao = result.getDao();
        resultDao.setParent(dao);
    }
    public Result getResult(){
        return new Result(dao.parent(ResultDao.class));
    }
    public void setHomeTeam(Team team){
        TeamDao teamDao = team.getDao();
        dao.setLong("home_team_id", teamDao.getLongId());
    }
    public void setAwayTeam(Team team){
        TeamDao teamDao = team.getDao();
        dao.setLong("away_team_id", teamDao.getLongId());              
    }
    public Team getHomeTeam(){
        return new Team(TeamDao.findById(dao.getLong("home_team_id")));
    }
    public Team getAwayTeam(){
        return new Team(TeamDao.findById(dao.getLong("away_team_id")));
    }
    public void setArena(Arena arena){
        dao.setParent(arena.getDao());
    }
    public Arena getArena(){
        return new Arena (dao.parent(ArenaDao.class));
    }
    public void setDate(Long date) {
        dao.set("date", date);
    }
    public Long getDate() {
        return dao.getLong("date");
    }
    public void setRound(Round round){
        dao.setParent(round.getDao());
    }
    
    public Round getRound(){
        return new Round(dao.parent(RoundDao.class));
    }
    @JsonIgnore
    public GameDao getDao(){
        return dao;
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
    
}
