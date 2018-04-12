/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.ResultDao;
import org.javalite.activejdbc.Model;
import java.lang.Exception;

/**
 *
 * @author Veiret
 */
public class Result {
    
    private final ResultDao dao;
    
    public Result(){
        this(new ResultDao());
    }
    public Result(ResultDao dao){
        this.dao = dao;
    }
    public ResultDao getDao(){
        return dao;
    }
    public void setHomeScore (Integer score) throws Exception {
        if (score == null){
            throw (new Exception());
        }
        dao.setInteger("homeScore", score);
    }
    public void setAwayScore(Integer score) throws Exception {
        if (score == null){
            throw (new Exception());
        }
        dao.setInteger("awayScore", score);
    }
    public Integer getHomeScore(){
        return dao.getInteger("homeScore");
    }
    public Integer getAwayScore(){
        return dao.getInteger("awayScore");
    }
    public Long getGameId(){
        return dao.getLong("game_id");
    }

    public void setFullTime(){
        dao.setLong("time", 1);
    }
    
    public void setOverTime(){
        dao.setLong("time", 2);
    }
    
    public void setShotOut(){
        dao.setLong("time", 3);
    }
    
    public boolean getFullTime(){
        return 1L == dao.getLong("time");
    }
    
    public boolean getOverTime(){
        return 2L == dao.getLong("time");
    }
        
    public boolean getShotOut(){
        return 3L == dao.getLong("time");
    }
        
        
}
