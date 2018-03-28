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
        Base.open("com.mysql.jdbc.Driver","jdbc:mysql://node71227-grupp2.jls-sto1.elastx.net:11068/mydb", "grupp2", "Nilgo4QTZeNT702L");
    }
    public static void staticClose() {
        Base.close();
    }
    public void open() {
        Base.open("com.mysql.jdbc.Driver", "jdbc:mysql://node71227-grupp2.jls-sto1.elastx.net:11068/mydb", "grupp2", "Nilgo4QTZeNT702L");
    }
    public void close() {
        Base.close();
    }
}
