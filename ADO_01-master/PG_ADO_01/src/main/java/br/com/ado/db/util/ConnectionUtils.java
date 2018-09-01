/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ado.db.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author victo
 */
public class ConnectionUtils {
    
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        String dbURL = "jdbc:mysql://localhost:3306/PRODUTOBD";
        Properties properties = new Properties();
        properties.put("user", "root");
        properties.put("password", "");
        properties.put("serverTimezone", "UTC");
        connection = DriverManager.getConnection(dbURL, properties);

        return connection;
    }
}
