/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iteminventory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Neeraj
 */
public class DBConnect {
    
    public static Connection getConnection()
    {
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/item_inventory_database", "root", "");
            //JOptionPane.showMessageDialog(null,"Database Connect !..");
        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Database Not Connect !.. \n"+ex );
        }
        return con;
    }
    
    public static void main(String[] args) {
        DBConnect.getConnection();
    }
}
