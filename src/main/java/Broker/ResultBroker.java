/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Broker;

import DAO.ResultDao;
import Domain.Result;

/**
 *
 * @author Simon
 */
public class ResultBroker {
    
    public void saveResult(Result result){
        ResultDao resultDao = result.getDao();
        resultDao.save();
    }
    /**
     *
     * @return
     */
    public Result create(){
        return new Result();
    }
}
