/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import java.util.List;
import sportstats.domain.Sport;
/**
 *
 * @author Simon
 */
public class GetAllSportsService extends BaseService <List<Sport>> {
    
    /**
     *
     * @return
     */
    @Override
    public List<Sport> execute(){
        List<Sport> result = getBrokerFactory().getSportBroker().getAllSports();
        return result;
    }
}
