/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

/**
 *
 * @author ntn13aae
 */
public class GetMatchResultForTeamService {
    
    private final Long teamId;
    
    public GetMatchResultForTeamService(Long teamId) {
        
        this.teamId = teamId;
        
        if(teamId == null){
            throw new ServiceException("teamId cannot be null.");
        }
    }
    
}
