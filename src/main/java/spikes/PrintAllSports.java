/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import DAO.SportDao;
import DB.DbConn;
import Services.GetAllSportService;
import com.mycompany.sportstatsveiret.Sport;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.javalite.activejdbc.LazyList;

/**
 *
 * @author Veiret
 */
public class PrintAllSports {
    public static void main (String[] args){
        GetAllSportService a = new GetAllSportService();
        List<Sport> sportList = a.execute();
        for(Sport s:sportList){
           System.out.println(s.getName());
        }
        //System.out.println(sportList.get(0).getName());
        DbConn.staticOpen();
         List<Sport> result = SportDao.findAll().stream().map(dao->(new Sport((SportDao)dao))).collect(Collectors.toList());

         for(int i = 0; i<result.size();i++){
           System.out.println(result.get(i).getDao().getId());
        }
        
        System.out.println(SportDao.findAll().get(0).get("name"));
        DbConn.staticClose();
    }
}
