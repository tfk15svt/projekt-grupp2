/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.RoundBroker;
import Broker.SeasonBroker;
import Domain.Game;
import Domain.Round;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author Peeftw
 */
public class GetAllGamesFromSeasonService extends Service {
    private final Long seasonId;
    private List<Game> gameList;
    public GetAllGamesFromSeasonService(Long seasonId) {
        this.seasonId = seasonId;
        if(seasonId == null){
            throw new ServiceException ("No round with that id");
        }
    }
    @Override
    public List<Game> execute (){
        SeasonBroker seasonBroker = getBrokerFactory().getSeasonBroker();
        if (seasonBroker.findSeasonById(seasonId) == null){
            throw new ServiceException("No round with that id");
        }
        List<Round> roundList = seasonBroker.getAllRoundsfromSeasonId(seasonId);
        RoundBroker roundBroker = getBrokerFactory().getRoundBroker();
        gameList = new ArrayList<>(); 
        for(Round round : roundList){
           List<Game> gamesFromRound = roundBroker.getAllGamesByRoundId(round.getId());
           gameList = Stream.concat(gameList.stream(), gamesFromRound.stream()).collect(Collectors.toList());
         
        }
        return gameList;   
        }
    
    }
    

