/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import DAO.GameDao;
import DAO.RoundDao;
import DAO.SeasonDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    public List<Game> getGames() {
        return dao.getAll(GameDao.class).stream()
                .map(dao -> new Game(dao))
                .collect(Collectors.toList());
    }
    
    public Long getId(){
        return dao.getLongId();
    }
    @JsonIgnore
    public RoundDao getDao(){
        return dao;
    }
    
    public void setRoundNumber(int roundNumber){
        dao.setInteger("number", roundNumber);
    }
    
    public int getRoundNumber(){
        return dao.getInteger("number");
    }
    
    public void setSeason(Season season){
        dao.setParent(season.getDao());
    }
    @JsonIgnore
    public Season getSeason(){
        return new Season(dao.parent(SeasonDao.class));
    }

    public void addGame(Game game) {
        game.getDao().setParent(dao);
    }
    
}
