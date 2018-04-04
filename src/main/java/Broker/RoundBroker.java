/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.ArenaDao;
import DAO.RoundDao;
import Domain.Arena;
import Domain.Round;

/**
 *
 * @author Simon
 */
public class RoundBroker {
    
    /**
     *
     * @return
     */
    public Round create(){
        return new Round();
    }
    
    public Round findById(Long roundId){
        return new Round(RoundDao.findById(roundId));
    }
}
