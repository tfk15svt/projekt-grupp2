/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.sportstatsveiret;

import DAO.GameDao;
import DAO.RoundDao;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class Round {
    private final RoundDao dao;
    public Round(){
        this(new RoundDao());
    }
    public Round(RoundDao dao){
        this.dao = dao;
    }
    public void setSeason (Season season) {
        dao.setParent(season.getDao());
    }
    public void addGame(Game game) {
        game.getDao().setParent(dao);
    }
    public List<Game> getGames() {
        return dao.getAll(GameDao.class).stream()
                .map(dao -> new Game(dao))
                .collect(Collectors.toList());
    }
    public void setNumber(int i){
        dao.set("number", i);
    }
    public int getNumber(){
        return dao.getInteger("number");
    }
    public RoundDao getDao() {
        return dao;
    }
}
