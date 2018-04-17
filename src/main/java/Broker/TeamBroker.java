/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.GameDao;
import DAO.ResultDao;
import DAO.TeamDao;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Veiret
 */
public class TeamBroker {

    public void saveTeam(Team team) {
        team.getDao().save();
    }

    public Team findTeamById(Long id) {
        return new Team(TeamDao.findById(id));
    }

    public Team create() {
        return new Team();
    }
    
    public List<Game> getAllGamesForTwoTeams(Long team1Id, Long team2Id)
    {
        List<Game> listOfGames = GameDao.find("(home_team_id=? AND away_team_id=?) OR (home_team_id=? AND away_team_id=?)", team1Id, team2Id, team2Id, team1Id).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
        
        return listOfGames;
    }   

    public List<Game> getAllGamesForOneTeam(Long teamId) {
        List<Game> listOfGames = GameDao.find("home_team_id=? OR away_team_id=?", teamId, teamId).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
        return listOfGames;
    }

    public List<Game> getAllGamesForHomeTeam(Long teamId) {
        List<Game> logH = GameDao.find("home_team_id=?", teamId).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());
        return logH;
    }

    public List<Game> getAllGamesForAwayTeam(Long teamId) {
        List<Game> logA = GameDao.find("away_team_id=?", teamId).stream()
                .map(gameDao -> new Game((GameDao) gameDao))
                .collect(Collectors.toList());

        return logA;
    }
    
    public boolean teamExists (Long id){
        return TeamDao.findById(id) != null;
    }
}
