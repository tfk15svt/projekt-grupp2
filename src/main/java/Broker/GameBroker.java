/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import Domain.Game;



/**
 *
 * @author Simon
 */
public class GameBroker {
    
    /**
     *
     * @return
     */
    public Game create(){
        return new Game();
    }
    
    public Game findById(Long id){
        return new Game(GameDao.findById(id));
    }
}
