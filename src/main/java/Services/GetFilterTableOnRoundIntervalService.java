/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.MakeTableFromGameList;
import Domain.Game;
import Domain.Season;
import Domain.Team;
import java.util.List;

/**
 *
 * @author Simon
 */
public class GetFilterTableOnRoundIntervalService extends Service{
    private final Long seasonId;
    private final Long startDate;
    private final Long endDate;
    List<Game> allSeasonGames;
    List<Team> allSeasonTeams;
    List<Game> intervalGames;
    Team team;
    Game game;

    public GetFilterTableOnRoundIntervalService(Long seasonId, Long startDate, Long endDate) {
        this.seasonId = seasonId;
        this.startDate = startDate;
        this.endDate = endDate;
        
        if(seasonId == null){
            throw new ServiceException("seasonId cannot be null");
        }
        if(startDate == null){
            throw new ServiceException("startDate cannot be null");
        }
        if(endDate == null){
            throw new ServiceException("endDate cannot be null");
        }
    }

    @Override
    public String execute() {
        if(getBrokerFactory().getSeasonBroker().findSeasonById(seasonId) == null){
            throw new ServiceException("no season with given id");
        }
        GetAllGamesFromSeasonService getGameService = new GetAllGamesFromSeasonService(seasonId);
        getGameService.init(getBrokerFactory());
        allSeasonGames = getGameService.execute();
        allSeasonTeams = getBrokerFactory().getSeasonBroker().getAllTeamsFromSeasonId(seasonId);
        for(int i = 0; i<allSeasonGames.size(); i++){
            game = allSeasonGames.get(i);
            if(game.getDate() == null){
                throw new ServiceException("Game Date is null");
            }
            if(game.getDate()<= endDate && game.getDate() >= startDate){
                intervalGames.add(game);
            }
        }
        return new MakeTableFromGameList(intervalGames, allSeasonTeams).execute();
    }
}
