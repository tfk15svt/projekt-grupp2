/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services.Get;

import DAO.GameDao;
import Domain.Game;
import Domain.Result;
import Domain.Team;
import Services.Service;
import Services.ServiceException;

/**
 *
 * @author Simon
 */
public class GetBiggestWinLoseForTwoTeamsService extends Service{
    private final Long teamId1;
    private final Long teamId2;

    public GetBiggestWinLoseForTwoTeamsService(Long teamId1, Long teamId2) {
        this.teamId1 = teamId1;
        this.teamId2 = teamId2;
        
        if(teamId1 == null){
            throw new ServiceException("team can not be null");
        }
        if(teamId2 == null){
            throw new ServiceException("team can not be null");
        }
    }

    @Override
    public Game execute() {
        Result result = getBrokerFactory().getResultBroker().getBiggestDifferensBetweenTwoTeams(teamId1, teamId2);
        GameDao gameDao = result.getDao().parent(GameDao.class);
        Game game = getBrokerFactory().getGameBroker().create(gameDao);
        
//        return "" + game.getHomeTeam().getName() + " " + result.getHomeScore() + " - " + result.getAwayScore() + " " + game.getAwayTeam().getName() ;
        return game;
    }
}