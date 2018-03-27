/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.ArenaDao;
import com.mycompany.sportstatsveiret.Arena;

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
