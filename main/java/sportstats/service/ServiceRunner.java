/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import sportstats.db.DBConn;
import sportstats.domain.broker.BrokerFactory;
import sportstats.rest.JsonOutputFormatter;

/**
 *
 * @author Simon
 */
public class ServiceRunner<T> {
    
    private final SportstatsService<T> service;
    
    public ServiceRunner(SportstatsService<T> service){
        this.service = service;
    }
    
    public String execute() {
        DBConn conn = new DBConn();
        service.init(new BrokerFactory());
        String jsonResult;
        T result = null;
        try{
            conn.instanceOpen();
            result = service.execute();
            jsonResult = new JsonOutputFormatter().createOutput(result);
        }catch(JsonProcessingException e){
            e.printStackTrace(System.out);
            throw new RuntimeException();
        } finally{
            conn.instanceClose();
        }
        return jsonResult;
    }
    
    public static void main(String[] args) {
        System.out.println(new ServiceRunner<>(new GetAllSportsService()).execute());
    }
    
}
