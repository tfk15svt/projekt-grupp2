/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.Sport;


/**
 *
 * @author Simon
 */
public class AddSportService extends BaseService<Sport>{
    
    private final String name;
    
    public AddSportService(String name){
        if(name == null){
            throw new SportstatsServiceException("Name cannot be null. ");
        }
        this.name = name;
    }
    
    @Override
    public Sport execute(){
        Sport sport = getBrokerFactory().getSportBroker().create();
        sport.setName(name);
        if(name == null){
            throw new SportstatsServiceException("name should not be null.");
        }
        sport.save();
        return sport;
    }
}
