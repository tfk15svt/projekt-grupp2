/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.domain.broker;

import sportstats.domain.Game;

/**
 *
 * @author Simon
 */
public class GameBroker {
    
    public Game create(){
        return new Game();
    }
}
