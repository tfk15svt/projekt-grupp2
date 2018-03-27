/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import sportstats.domain.broker.BrokerFactory;

/**
 *
 * @author Simon
 * @param <T>
 */
public abstract class BaseService<T> implements SportstatsService<T> {
    
    private BrokerFactory brokerFactory;

    @Override
    public final void init(BrokerFactory brokerFactory) {
        this.brokerFactory = brokerFactory;
    }

    protected BrokerFactory getBrokerFactory() {
        return brokerFactory;
    }
    
    @Override
    public abstract T execute();
}
