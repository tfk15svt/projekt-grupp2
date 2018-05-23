/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.ArenaDao;
import DAO.GameDao;
import Domain.Arena;
import Domain.Game;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Simon
 */
public class ArenaBroker {
    
    public Arena findById(Long arenaId){
        return new Arena(ArenaDao.findById(arenaId));
    }
    
    public Arena create(){
        return new Arena();
    }
    
    public List<Game> getAllGamesForOneArena(Long arenaId){
        ArenaDao arenaDao = ArenaDao.findById(arenaId);
        return arenaDao.getAll(GameDao.class).stream()
                .map(gameDao -> new Game ((GameDao) gameDao))
                .collect(Collectors.toList());
    }
}
