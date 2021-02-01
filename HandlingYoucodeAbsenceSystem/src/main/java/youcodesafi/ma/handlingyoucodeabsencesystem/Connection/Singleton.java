/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package youcodesafi.ma.handlingyoucodeabsencesystem.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Singleton {
    // Step 1  
    // create a SingeltonConnection class.  
    // static member holds only one instance of the SingeltonConnection class.  

    private static Singleton instance;

    // to get The DB Configuration Properties From The dbConfig File .Properties
    // private static ResourceBundle reader = null;
    // SingeltonConnection prevents the instantiation from any other class.
    private Singleton() {
    }

    // Now we are providing gloabal point of access.
    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    // to get the connection from methods like insert, view etc.  
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8000/handlingyasvbetav2?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "root");
            System.out.println("Connection Established Successfully :) ");
        } catch (ClassNotFoundException exception) {
            System.out.println("Connection to database has a problem :( " + exception.getMessage());
        }
        return connection;
    }
}
