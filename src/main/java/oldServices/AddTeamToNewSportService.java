/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oldServices;

import Broker.BrokerFactory;
import DAO.SportDao;
import DB.DbConn;
import Domain.Sport;
import Domain.Team;

/**
 *
 * @author Veiret
 */
public class AddTeamToNewSportService {
    private final Team team;
    private final String sportnamn;
    private DbConn conn;
    private BrokerFactory brokerFactory;
    public AddTeamToNewSportService(Team team, String sportnamn) {
        this.team = team;
        this.sportnamn = sportnamn;
    }
    public void init(DbConn conn, BrokerFactory brokerFactory){
        this.conn = conn;
        this.brokerFactory = brokerFactory;
    }
    public void execute() {
        conn.open();
        Sport sport = brokerFactory.getSportBroker().create();
        sport.setName(sportnamn);
        
        if (SportDao.find("name=?", sportnamn).size() == 0){
            sport.getDao().save();
            team.setSport(sport);
            team.getDao().save();
        } else {
            SportDao oldSport = (SportDao) SportDao.find("name=?", sportnamn).get(0);
            team.setSport(new Sport (oldSport));
            team.getDao().save();
        }
        conn.close();
    }
    
}
