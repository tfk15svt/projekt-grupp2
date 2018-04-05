/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.RoundBroker;
import Domain.Game;
import java.util.List;

/**
 *
 * @author Peeftw
 */
public class GetAllGamesFromRoundService extends Service {
    private final Long roundId;
    
    public GetAllGamesFromRoundService(Long roundId) {
        this.roundId = roundId;
        if(roundId == null){
            throw new ServiceException ("No round with that id");
        }
    }
    public List<Game> execute (){
        RoundBroker roundBroker = getBrokerFactory().getRoundBroker();
        if (roundBroker.findById(roundId) == null){
            throw new ServiceException("No round with that id");
        }
        return getBrokerFactory().getRoundBroker().getAllGamesByRoundId(roundId);
    }
    
}
