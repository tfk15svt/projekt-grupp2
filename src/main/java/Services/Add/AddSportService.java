/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Add;

import Broker.BrokerFactory;
import Broker.SportBroker;
import DB.DbConn;
import Domain.Sport;
import Services.Service;
import Services.ServiceException;

/**
 *
 * @author Veiret
 */
public class AddSportService extends Service {
    private final String name;
    public AddSportService(String name){
        this.name = name;
        if (this.name == null){
            throw new ServiceException("name cannot be null");
        }
        if (this.name == ""){
            throw new ServiceException("name cannot be an empty String");
        }
        if (this.name.charAt(0) == ' '){
            throw new ServiceException("name cannot begin with space");
        }
        
    }
    @Override
    public Sport execute() {
        SportBroker sportBroker = getBrokerFactory().getSportBroker();
        Sport sport = sportBroker.create();
        sport.setName(name);
        sportBroker.saveSport(sport);
        return sport;
    }
    
}
