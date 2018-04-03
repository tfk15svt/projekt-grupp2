/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import sportstats.domain.Result;

/**
 *
 * @author Simon
 */
public class ResultBroker {
    
    public Result create(){
        return new Result();
    }
}
