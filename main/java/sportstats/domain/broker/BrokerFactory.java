/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

/**
 *
 * @author Simon
 */
public class BrokerFactory {
    
    public TeamBroker getTeamBroker() {
        return new TeamBroker();
    }
    
    public SportBroker getSportBroker() {
        return new SportBroker();
    }
    
    public GameBroker getGameBroker(){
        return new GameBroker();
    }
    
    public ArenaBroker getArenaBroker(){
        return new ArenaBroker();
    }
    
    public LeagueBroker getLeagueBroker(){
        return new LeagueBroker();
    }
    
    public ResultBroker getResultBroker(){
        return new ResultBroker();
    }
    
    public RoundBroker getRoundBroker(){
        return new RoundBroker();
    }
    
    public SeasonBroker getSeasonBroker(){
        return new SeasonBroker();
    }
    
    public TableBroker getTableBroker(){
        return new TableBroker();
    }
    
    public TeamsSeasonsBroker getTeamsSeasonsBroker(){
        return new TeamsSeasonsBroker();
    }
}
