/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sportstats.db;

import org.javalite.activejdbc.Base;

/**
 *
 * @author Simon
 */
public class DBConn {
    
    
    public static void open() {
       //Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/Sportstats", "sportstats", "5p0rt5t4t5");
       Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/mydb", "simon_db", "simon_db");
    }
    
    public static void close() {
        Base.close();
    }
    
    public void instanceOpen(){
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/mydb", "simon_db", "simon_db");
    }
    
    public void instanceClose(){
        Base.close();
    }
}
