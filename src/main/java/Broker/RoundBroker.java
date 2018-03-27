/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import com.mycompany.sportstatsveiret.Round;

/**
 *
 * @author Simon
 */
public class RoundBroker {
    
    /**
     *
     * @return
     */
    public Round create(){
        return new Round();
    }
}
