/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotelmanagementsystem.model;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Ridwan
 */
public class Model {
    
    public static Connection getConnection() throws Exception {
        try{
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/hms_db";
            String username = "root";
            String password = "";
            Class.forName(driver);

            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("Connected");
            return conn;
        }catch(Exception e){
            System.out.println(e);
        }
        return null;
    }
    
}
