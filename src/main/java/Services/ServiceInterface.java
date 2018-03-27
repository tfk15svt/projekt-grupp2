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
public interface ServiceInterface <T>{
    void init(BrokerFactory brokerfactory);
    T execute();
}
