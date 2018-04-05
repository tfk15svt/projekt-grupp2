/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.TeamDao;
import Domain.Game;
import java.util.List;
import java.util.stream.Collectors;



/**
 *
 * @author Simon
 */
public class GameBroker {
    public void saveGame(Game game){
        GameDao gameDao = game.getDao();
        gameDao.save();
    }
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
