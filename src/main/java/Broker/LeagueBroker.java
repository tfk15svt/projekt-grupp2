/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.LeagueDao;
import DAO.RoundDao;
import DAO.SeasonDao;
import Domain.Game;
import Domain.League;
import Domain.Season;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class LeagueBroker {

    public void saveLeague(League league) {
        LeagueDao leagueDao = league.getDao();
        leagueDao.save();
    }

    public League findLeagueById(Long id) {
        return new League(LeagueDao.findById(id));
    }

    public List<Season> getAllSeasonsFromLeagueId(Long id) {
        LeagueDao leagueDao = LeagueDao.findById(id);
        List<Season> result = leagueDao.getAll(SeasonDao.class).stream()
                .map(seasonDao -> new Season((SeasonDao) seasonDao))
                .collect(Collectors.toList());
        return result;
    }

    public List<Game> getGamesWithinDateInterVal(long leagueId, int startDate, int endDate) {
        return LeagueDao.findById(leagueId).getAll(SeasonDao.class).stream()
                .map(seasonDao -> ((SeasonDao) seasonDao).getAll(RoundDao.class))
                .flatMap(roundList -> roundList.stream())
                .map(roundDao -> ((RoundDao) roundDao).getAll(GameDao.class))
                .flatMap(gameDaoList -> gameDaoList.stream())
                .filter(gameDao -> 
                        endDate >= (Integer)((GameDao) gameDao).get("date") &&
                                (Integer)((GameDao) gameDao).get("date") >= startDate)
                .map(gameDao -> new Game(gameDao))
                .collect(Collectors.toList());
        
    }
    public List<Game> getAllGames(long leagueId) {
        return LeagueDao.findById(leagueId).getAll(SeasonDao.class).stream()
                .map(seasonDao -> ((SeasonDao) seasonDao).getAll(RoundDao.class))
                .flatMap(roundList -> roundList.stream())
                .map(roundDao -> ((RoundDao) roundDao).getAll(GameDao.class))
                .flatMap(gameDaoList -> gameDaoList.stream())
                .map(gameDao -> new Game(gameDao))
                .collect(Collectors.toList());
    }

    public League create() {
        return new League();
    }
    public boolean leagueExists (Long id){
        return LeagueDao.findById(id) != null;
    }
}
