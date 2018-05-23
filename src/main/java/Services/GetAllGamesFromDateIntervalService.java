/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Game;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class GetAllGamesFromDateIntervalService extends Service {
    private final Long leagueId;
    private Integer startDate;
    private Integer endDate;
    
    public GetAllGamesFromDateIntervalService (Long leagueId, Integer startDate, Integer endDate) {
        this.leagueId = leagueId;
        if (this.leagueId == null) {
            throw new ServiceException("League id is null");
        }
        this.startDate = startDate;
        if (this.startDate == null) {
            throw new ServiceException("StartDate id is null");
        }
        this.endDate = endDate;
        if (this.endDate == null) {
            throw new ServiceException("EndDate id is null");
        }
        
    }
    @Override
    public List<Game> execute() {
        List<Game> res = getBrokerFactory().getLeagueBroker().getGamesWithinDateInterVal((long) leagueId,(int) startDate,(int) endDate);
        return res;
    }
    
}
