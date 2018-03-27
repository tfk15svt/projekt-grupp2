/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

/**
 *
 * @author Simon
 */
public class SportstatsServiceException extends RuntimeException {

    public SportstatsServiceException(String message) {
        super(message);
    }

    public SportstatsServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public SportstatsServiceException(Throwable cause) {
        super(cause);
    }
    
    
}
