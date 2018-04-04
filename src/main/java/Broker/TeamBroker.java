/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.TeamDao;
import Domain.Team;

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
}
