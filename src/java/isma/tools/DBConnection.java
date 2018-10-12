/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose DBConnection | Templates
 * and open the template in the editor.
 */
package isma.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 *
 * @author Isma
 */
public class DBConnection {

    private  String ipAddress;
    private  String dbName;
    private  String user;
    private  String password;
    private  String service;
    private  ResourceBundle properties;
    private  Connection conn;

    public void Conexion() throws SQLException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Error en Class DBConnection ");
        }
        if (properties == null) {
            properties = ResourceBundle.getBundle("properties");
            ipAddress = properties.getString("ipAddress");
            dbName = properties.getString("dbName");
            user = properties.getString("user");
            password = properties.getString("password");
            service = properties.getString("service");
        }
        String url = "jdbc:sqlserver://" + ipAddress + ":" + service + ";databaseName=" + dbName;
        conn = DriverManager.getConnection(url, user, password);
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection aConn) {
        conn = aConn;
    }

    public void closeConnections() throws SQLException {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
        }
    }

    public static void main(String[] args) throws SQLException, InterruptedException {
        DBConnection conn = new DBConnection();
        conn.Conexion();
        
        if (conn != null) {
            System.out.println("Conexión Exitosa");
           
        } else {
            System.out.println("Error de Conexión");
        }
        conn.closeConnections();
    }

}
