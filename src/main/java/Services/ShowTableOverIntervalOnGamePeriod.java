/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon
 */
public class ShowTableOverIntervalOnGamePeriod extends Service{
    private final Integer gamePeriod;
    private final Integer start;
    private final Integer end;

    public ShowTableOverIntervalOnGamePeriod(Integer gamePeriod, Integer start, Integer end) {
        this.gamePeriod = gamePeriod;
        this.start = start;
        this.end = end;
        
        if(gamePeriod == null || gamePeriod < 1){
            throw new ServiceException("Gameperiod cannot be null or < 0");
        }
        
        if(start == null){
            throw new ServiceException("start cannot be null");
        }
        
        if(end == null){
            throw new ServiceException("end cannot be null");
        }
    }
    

    @Override
    public String execute() {
        String a = "";
        
        return a;
    }
}
