/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain;

import sportstats.domain.dao.TableDao;

/**
 *
 * @author Simon
 */
public class Table {
    
    private final TableDao dao;
    
    public Table(){
        this(new TableDao());
    }
    
    public Table(TableDao dao){
        this.dao = dao;
    }
    
    public TableDao getDao(){
        return dao;
    }
    
    public void save(){
        dao.save();
    }
    
}
