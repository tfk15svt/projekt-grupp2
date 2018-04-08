/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import Domain.Round;
import Domain.Team;

/**
 *
 * @author slett
 */
public class AddGameService extends Service{
    private Long homeTeamId;
    private Long awayTeamId;
    private final Long roundId;
    
    public AddGameService(Long roundId){
        if (roundId == null)
            throw new ServiceException("Round is null");
        else
            this.roundId = roundId;
    }
    public AddGameService(Long roundId, Long homeTeamId, Long awayTeamId){
        if (roundId == null)
            throw new ServiceException("Round is null");
        else
            this.roundId = roundId;
        if (homeTeamId == null)
            throw new ServiceException("Home Team is null");
        else
            this.homeTeamId = homeTeamId;
        if (awayTeamId == null)
            throw new ServiceException("Away Team is null");
        else
            this.awayTeamId = awayTeamId;
    }
    @Override
    public Boolean execute(){
        Game game = getBrokerFactory().getGameBroker().create();
        Round round = getBrokerFactory().getRoundBroker().findById(roundId);
        if (round == null)
            throw new ServiceException("No round with that Id");
        else
            game.setRound(round);
        Team homeTeam;
        Team awayTeam;
        if (homeTeamId != null || awayTeamId != null){
            homeTeam = getBrokerFactory().getTeamBroker().findTeamById(homeTeamId);
            awayTeam = getBrokerFactory().getTeamBroker().findTeamById(awayTeamId);
            if (homeTeam == null || awayTeam == null)
                throw new ServiceException("No team with that Id");
            else
            {
                game.setHomeTeam(homeTeam);
                game.setAwayTeam(awayTeam);
            }
        }
        getBrokerFactory().getGameBroker().saveGame(game);
        return true;
    }
    
}
