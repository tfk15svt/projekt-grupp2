/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spikes;

import DB.DbConn;

/**
 *
 * @author Veiret
 */
public class CloseDb {
    public static void main (String[] args){
        DbConn.staticClose();
    }
}
