/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.LeagueDao;
import DAO.SportDao;
import Domain.League;
import Domain.Sport;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Veiret
 */
public class SportBroker {
    public Sport create(){
        return new Sport();
    }
    public Sport findById(Long id){
        return new Sport(SportDao.findById(id));
    }
    public void saveSport(Sport sport) {
        sport.getDao().save();
    }
    public List<League> getAllLeaguesFromSportId (Long id) {
        SportDao sportDao = SportDao.findById(id);
        List<League> result = sportDao.getAll(LeagueDao.class).stream()
                .map(leagueDao -> new League((LeagueDao) leagueDao))
                .collect(Collectors.toList());
        return result;
    }
    public List<Sport> getAll() {
        return SportDao.findAll().stream()
                .map(dao -> new Sport((SportDao) dao))
                .collect(Collectors.toList());
    }
}
