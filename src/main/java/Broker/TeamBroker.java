/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.TeamDao;
import Domain.Game;
import Domain.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Veiret
 */
public class TeamBroker {
    public void saveTeam(Team team){
        team.getDao().save();
    }
    public Team findTeamById(Long id) {
        return new Team (TeamDao.findById(id));
    }
    public Team create(){
        return new Team();
    }
    
    public List<Game> getAllGamesForOneTeam(Long teamId){
        
        List<Game> logH = GameDao.find("home_team_id=?", teamId).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
        
        List<Game> logA = GameDao.find("away_team_id=?", teamId).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
        
        List<Game> listOfGames = Stream.concat(logH.stream(), logA.stream()).collect(Collectors.toList());
        
        return listOfGames;
    }
}
