/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

/**
 *
 * @author Veiret
 */
public class BrokerFactory {
    public LeagueBroker getLeagueBroker(){
        return new LeagueBroker();
    }
    public SeasonBroker getSeasonBroker(){
        return new SeasonBroker();
    }
    public SportBroker getSportBroker(){
        return new SportBroker();
    }
    public TeamBroker getTeamBroker(){
        return new TeamBroker();
    }
    public TeamSeasonBroker getTeamSeasonBroker () {
        return new TeamSeasonBroker();
    }
}
