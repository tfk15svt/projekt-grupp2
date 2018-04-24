/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.ResultDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
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
    @JsonIgnore
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
    @JsonIgnore
    public boolean getFullTime(){
        return 1L == dao.getLong("time");
    }
    @JsonIgnore
    public boolean getOverTime(){
        return 2L == dao.getLong("time");
    }
    @JsonIgnore    
    public boolean getShotOut(){
        return 3L == dao.getLong("time");
    }
    
    @JsonIgnore
    public void setScore(String score) throws Exception {
        if (score == null){
            throw (new Exception());
        }
        System.out.println("SETTING SCORE:    " + score);
        dao.setString("score", score);
    }
    @JsonIgnore
    public String getScore(){
        System.out.println("GETTING SCORE:   " + dao.getString("score"));
        return dao.getString("score");
    }
}