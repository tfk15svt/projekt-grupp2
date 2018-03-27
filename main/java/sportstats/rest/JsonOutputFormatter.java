/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 *
 * @author Simon
 */
public class JsonOutputFormatter {
    
    public String createOutput(Object resultData) throws JsonProcessingException{
        ObjectMapper mapper = new ObjectMapper();
        try{
        String json = mapper.writeValueAsString(resultData);
        return json;
        }catch(JsonProcessingException e){
            throw new RuntimeException();
        }
    }
}
