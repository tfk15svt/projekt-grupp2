/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporary;

/**
 *
 * @author Simon
 */
public class Calculator {
    
    private final Arguments a;
    
    public Calculator() {
        this(new Arguments());
    }
    
    public Calculator(Arguments a) {
        this.a = a;
    }
    
    public Integer run() {
        return new Operation().operate(a.getThem());
    }
    
}
