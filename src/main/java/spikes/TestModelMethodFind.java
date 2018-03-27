/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import DAO.SportDao;
import DB.DbConn;
import java.util.List;

/**
 *
 * @author Veiret
 */
public class TestModelMethodFind {
    public static void main(String[] args){
        DbConn.staticOpen();
        SportDao sportdao = new SportDao();
        List<SportDao> list = SportDao.find("name=?", new String("sport2"));
        
        System.out.print(list.size());
        DbConn.staticClose();
    }
    
}
