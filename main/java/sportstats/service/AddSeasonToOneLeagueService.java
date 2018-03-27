/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.League;
import sportstats.domain.Season;


/**
 *
 * @author Simon
 */
public class AddSeasonToOneLeagueService extends BaseService{
    
    private final Long leagueId;
    private final int seasonYear;
    
    public AddSeasonToOneLeagueService(int seasonYear, Long leagueId){
        if(seasonYear < 1){
            throw new SportstatsServiceException("Season cannot be null.");
        }
        if(leagueId == null){
            throw new SportstatsServiceException("ID cannot be null.");
        }
        this.leagueId = leagueId;
        this.seasonYear = seasonYear;
    }
    
    @Override
    public Season execute(){
        Season season = getBrokerFactory().getSeasonBroker().create();
        season.setYear(seasonYear);
        League league = getBrokerFactory().getLeagueBroker().findLeagueById(leagueId);
        season.setLeague(league);
        season.save();
        return season;
    }
}
