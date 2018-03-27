/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.Season;
import sportstats.domain.Team;
import sportstats.domain.dao.TeamsSeasonsDao;

/**
 *
 * @author Simon
 */
public class ConnectTeamToSeasonService extends BaseService{
    private final Long teamId;
    private final Long seasonId;

    public ConnectTeamToSeasonService(Long teamId, Long seasonId) {
        if(teamId == null){
            throw new SportstatsServiceException("teamname can not be null. ");
        }
        if(seasonId == null){
            throw new SportstatsServiceException("seasonId can not be null. ");
        }
        this.teamId = teamId;
        this.seasonId = seasonId;
    }
    
    @Override
    public Boolean execute(){
        TeamsSeasonsDao teamSeason = getBrokerFactory().getTeamsSeasonsBroker().create();
        Team team = getBrokerFactory().getTeamBroker().findById(teamId);
        if(team == null){
            throw new SportstatsServiceException("name can not be null.");
        }
        Season season = getBrokerFactory().getSeasonBroker().findSeasonById(seasonId);
        if(season == null ){
            throw new SportstatsServiceException("season can not be null.");
        }
        teamSeason.setSeason(season);
        teamSeason.setTeam(team);
        teamSeason.save();
        return true;
    }    
}
