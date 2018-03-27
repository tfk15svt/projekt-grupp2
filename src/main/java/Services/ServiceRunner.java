/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Broker.BrokerFactory;
import DB.DbConn;

/**
 *
 * @author Veiret
 */
public class ServiceRunner<T> {
    private final Service<T> service;
    private DbConn dbConn= new DbConn();
    public ServiceRunner(Service service){
        this.service = service;
    }
    public T execute(){
        service.init(new BrokerFactory());
        dbConn.open();
        try {
            return service.execute();
        } catch (Exception e) {
            throw e;
        } finally {
            dbConn.close();
        }
    }
}
