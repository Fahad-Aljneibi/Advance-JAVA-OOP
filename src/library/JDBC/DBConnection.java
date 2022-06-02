/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library.JDBC;

import java.sql.*;
import java.util.*;


/**
 *
 * @author fahad
 */
public class DBConnection {
    
private static DBConnection theInstance = null;

private DBConnection()
{

}

public static DBConnection getInstace()
{
        if( theInstance == null ) 
	     theInstance = new DBConnection();
        return theInstance;
}
    
        public Connection getConnection() throws SQLException {
        //Change the path the database (.db) file on your machine...
        //Just by changing the URL you point to another database
        String dbURL = "jdbc:sqlite:D:/HCT/202101/adv oop/Project/bookinfo.db";

        Connection conn = DriverManager.getConnection(dbURL);
        return conn;
    }

    
}
