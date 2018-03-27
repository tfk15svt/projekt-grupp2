/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import org.javalite.activejdbc.Base;

/**
 *
 * @author Veiret
 */
public class DbConn {
    public static void staticOpen() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/mydb", "veiret_sql", "paronplommon378");
    }
    public static void staticClose() {
        Base.close();
    }
    public void open() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://localhost/mydb", "veiret_sql", "paronplommon378");
    }
    public void close() {
        Base.close();
    }
}
