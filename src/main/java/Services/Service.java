/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import AssistantClasses.JsonOutputformat;
import Broker.BrokerFactory;

/**
 *
 * @author Veiret
 */
public abstract class Service<T> implements ServiceInterface<T>{
    private BrokerFactory brokerFactory;
    
    @Override
    public final void init(BrokerFactory brokerFactory){
        
        this.brokerFactory = brokerFactory;
        if(brokerFactory == null){
            throw new ServiceException("BrokerFactory is null");
        }
    }
    protected BrokerFactory getBrokerFactory() {
        return brokerFactory;
    }

}
