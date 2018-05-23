/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import Domain.Game;
import Services.Service;
import Services.ServiceException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Simon
 */
public class GetAllGamesFromDateService extends Service{
    Integer date;
    public GetAllGamesFromDateService(Integer date) {
        this.date = date;
        if(this.date == null){
            throw new ServiceException("date can not be null.");
        }
        if(this.date.toString().length() != 8){
            throw new ServiceException("date should be yyyyMMdd");
        }
    }
    
    @Override
    public List<Game> execute() {
        List<Game> log = getBrokerFactory().getGameBroker().findGamesByDate(date);
        return log;
    }
    
}
