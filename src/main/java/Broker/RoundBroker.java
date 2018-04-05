/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.ArenaDao;
import DAO.GameDao;

import DAO.RoundDao;
import Domain.Arena;
import Domain.Game;

import Domain.Round;
import java.util.List;
import java.util.stream.Collectors;


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
    
    public List<Game> getAllGamesByRoundId(Long id){
        RoundDao roundDao = RoundDao.findById(id);
        return roundDao.getAll(GameDao.class).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
    
    }

}
