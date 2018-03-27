/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package temporary;
import java.util.stream.Stream;
/**
 *
 * @author Simon
 */
public class Operation {
    
    public Integer operate(Integer... arguments) {
        return Stream.of(arguments).reduce((a, b) -> a - b).get();
    }
    
}
