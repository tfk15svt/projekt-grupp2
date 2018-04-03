/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import sportstats.domain.Table;

/**
 *
 * @author Simon
 */
public class TableBroker {
    
    public Table create(){
        return new Table();
    }
}
