/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import Broker.SeasonBroker;
import Domain.Game;
import Domain.Round;
import Domain.Season;

/**
 *
 * @author Veiret
 */
public class AddRoundToSeasonService extends Service{
    private final Long seasonId;
    private final Long numberOfGames;
    private Long maxRoundsInSeason;
    private int numberOfRoundsInSeason;
    public AddRoundToSeasonService (Long seasonId, Long numberOfGames) {
        this.seasonId = seasonId;
        if (seasonId == null) {
            throw new ServiceException("Season id is null");
        }
        this.numberOfGames = numberOfGames;
        if (numberOfGames == null) {
            throw new ServiceException("numberOfGames is null");
        }
    }
    @Override
    public Boolean execute() {
        //Season season = getBrokerFactory().getSeasonBroker().findSeasonById(seasonId);
        BrokerFactory brokerFactory = getBrokerFactory();
        SeasonBroker sb = brokerFactory.getSeasonBroker();
        Season season = sb.findSeasonById(seasonId);
        
        if (season == null) {
            throw new ServiceException("No season with that id");
        }
        Round round = getBrokerFactory().getRoundBroker().create();
        maxRoundsInSeason = season.getMaxRounds();
        if (maxRoundsInSeason == null) {
            throw new ServiceException("Max number of rounds not initialized");
        }
        numberOfRoundsInSeason = getBrokerFactory().getSeasonBroker().getAllRoundsfromSeasonId(seasonId).size();
        if (maxRoundsInSeason <= numberOfRoundsInSeason) {
            throw new ServiceException("All rounds created");
        }
        round.setSeason(season);
        round.setRoundNumber(numberOfRoundsInSeason + 1);
        round.getDao().save();
        for(int i = 0; i < numberOfGames; i++){
            Game game = getBrokerFactory().getGameBroker().create();
            round.addGame(game);
            game.getDao().save();
        }
        return true; 
    }
    
}
