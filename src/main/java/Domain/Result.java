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
        if (score == null || dao.getString("score") != null){
            throw (new Exception());
        }
        dao.setInteger("homeScore", score);
    }
    public void setAwayScore(Integer score) throws Exception {
        if (score == null || dao.getString("score") != null){
            throw (new Exception());
        }
        System.out.println(dao.getString("score"));
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
    public void setScore(String score, Integer homeScore, Integer awayScore) throws Exception {
        if (score == null){
            throw (new Exception());
        }
        dao.setString("score", score);
        dao.setInteger("awayScore", awayScore);
        dao.setInteger("homeScore", homeScore);
    }
    public String getScore(){
        return dao.getString("score");
    }

    @JsonIgnore
    public boolean getHomeTeamFirstGoal() {
        Boolean res = dao.getBoolean("firstScoreByHomeTeam");
        if (res == null) res = false;
        return (boolean) res;
    }
    @JsonIgnore
    public boolean getHomeTeamLastGoal() {
        Boolean res = dao.getBoolean("lastScoreByHomeTeam");
        if (res == null) res = false;
        return (boolean) res;
    }
    @JsonIgnore
    public boolean getAwayTeamFirstGoal() {
        Boolean res = dao.getBoolean("firstScoreByHomeTeam");
        if (res == null) {
            res = false;
        } else {
            res = !res;
        }
        return res;
    }
    @JsonIgnore
    public boolean getAwayTeamLastGoal() {
        Boolean res = dao.getBoolean("lastScoreByHomeTeam");
        if (res == null) {
            res = false;
        } else {
            res = !res;
        }
        return res;
    }
}
