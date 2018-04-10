/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Domain.Result;
import Domain.Team;

/**
 *
 * @author Simon
 */
public class GetBiggestWinLoseForTwoTeamsService extends Service{
    private Team team1;
    private Team team2;

    public GetBiggestWinLoseForTwoTeamsService(Team team1, Team team2) {
        this.team1 = team1;
        this.team2 = team2;
        
        if(team1 == null){
            throw new ServiceException("team can not be null");
        }
        if(team2 == null){
            throw new ServiceException("team can not be null");
        }
    }

    @Override
    public Result execute() {
        
        //return result;
        return null;
    }
    
    
    
}
