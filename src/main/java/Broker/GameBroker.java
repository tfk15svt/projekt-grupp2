/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.TeamDao;
import Domain.Game;
import java.text.SimpleDateFormat;
import java.util.Date;
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
    
    public Game create(GameDao gameDao){
        return new Game(gameDao);
    }
    
    public Game findById(Long id){
        return new Game(GameDao.findById(id));
    }
    
    public List<Game> findGamesByDate(Long date){
        List<Game> listOfGames = GameDao.find("date=?", date).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
                
        return listOfGames;
    }
    public boolean gameExists (Long id){
        return GameDao.findById(id) != null;
    }
}
