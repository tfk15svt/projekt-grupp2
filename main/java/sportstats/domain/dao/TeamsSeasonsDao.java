/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.dao;

import org.javalite.activejdbc.Model;
import org.javalite.activejdbc.annotations.Table;
import sportstats.domain.Season;
import sportstats.domain.Team;

/**
 *
 * @author Simon
 */
@Table("seasons_teams")
public class TeamsSeasonsDao extends Model{
    
    public void setSeason(Season season){
        this.setParent(season.getDao());
    }
    
    public void setTeam(Team team){
        this.setParent(team.getDao());
    }
}
