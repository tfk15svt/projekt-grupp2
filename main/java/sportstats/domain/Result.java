/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.ResultDao;

/**
 *
 * @author Simon
 */
public class Result{
    
    private final ResultDao dao;
    
    public Result(){
        this(new ResultDao());
    }
    
    public Result(ResultDao dao){
        this.dao = dao;
    }
    
    public void setHomeScore(int homeScore) throws IllegalArgumentException{
        if(homeScore < 0 || homeScore > 400){
            throw new IllegalArgumentException("Negative number entered or to high number entered.");
        }
        else
            dao.setInteger("homeScore" , homeScore);
    }
    
    public int getHomeScore(){
        return dao.getInteger("homeScore");
    }
    
    public void setAwayScore(int awayScore) throws IllegalArgumentException{
         if(awayScore < 0 ||awayScore > 400){
            throw new IllegalArgumentException("Negative number entered or to high number entered.");
        }
        else
            dao.setInteger("homeScore" , awayScore);
    }
    
    public int getAwayScore(){
        return dao.getInteger("awayScore");
    }
    
    public ResultDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
}
