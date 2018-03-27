/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.TeamsSeasonsDao;

/**
 *
 * @author Veiret
 */
public class TeamSeasonBroker {
    public TeamsSeasonsDao create(){
        return new TeamsSeasonsDao();
    }
}
