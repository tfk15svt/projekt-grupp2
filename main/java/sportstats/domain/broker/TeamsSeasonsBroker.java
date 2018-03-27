/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import sportstats.domain.dao.TeamsSeasonsDao;

/**
 *
 * @author Simon
 */
public class TeamsSeasonsBroker {
 
    public TeamsSeasonsDao create(){
        return new TeamsSeasonsDao();
    }
}
