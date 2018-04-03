/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import sportstats.domain.Arena;
import sportstats.domain.dao.ArenaDao;

/**
 *
 * @author Simon
 */
public class ArenaBroker {
    
    public Arena findById(Long arenaId){
        return new Arena(ArenaDao.findById(arenaId));
    }
    
    public Arena create(){
        return new Arena();
    }
}
