package org.practicalsolutions.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*This is simple connection to DB
that class was only for testing*/
public class DBConnection implements AutoCloseable {

    public static final Logger log = LogManager.getLogger(DBConnection.class);

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL="jdbc:mysql://localhost:3306/";
    /*Change strings user and password for your DB.*/
    static final String nameDB = "solutions?serverTimezone=UTC";//
    static final String user = "vasyl";
    static final String password = "rootStrong";

    private Connection connection = null;

    public DBConnection(){
        try {
            Class.forName(JDBC_DRIVER).newInstance();
        } catch (IllegalAccessException | InstantiationException | ClassNotFoundException e){
            log.info("Connection to DB do not successfully"+e);
        }
    }

    public Connection getConnection(){
        try {
            if (connection == null){
                /*connection = DriverManager.getConnection(DB_URL+nameDB+"?user="+user+
                        "&password="+password+"?serverTimezone=UTC");*/
                connection = DriverManager.getConnection(
                        DB_URL+nameDB, user, password);
            }
        } catch (SQLException e){
            log.info("Could not get connection to DB "+e);
        }
        return connection;
    }

    @Override
    public void close() throws Exception {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.info("Do not close connection: "+e);
        }
    }
}
