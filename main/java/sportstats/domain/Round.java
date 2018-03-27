/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;
import org.javalite.activejdbc.Model;
import sportstats.domain.dao.RoundDao;
/**
 *
 * @author Simon
 */
public class Round{
    
    private final RoundDao dao;
    
    public Round(){
        this(new RoundDao());
    }
    
    public Round(RoundDao dao){
        this.dao = dao;
    }
    
    public void setRoundNumber(int roundNumber) throws IllegalArgumentException{
        if(roundNumber < 0){
            throw new IllegalArgumentException("Negative number entered.");
        }
        else
            dao.setInteger("roundNumber", roundNumber);
    }
    
    public int getRoundNumber(){
        return dao.getInteger("roundNumber");
    }
    
    public RoundDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
}
