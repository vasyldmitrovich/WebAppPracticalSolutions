package org.practicalsolutions.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBCPDataSource implements AutoCloseable {

    public static final Logger log = LogManager.getLogger(DBCPDataSource.class);

    public Connection connection = null;

    public Connection getConnection() {
        try {
            InitialContext initContext= new InitialContext();
            DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/DBConnectionPull");
            connection = ds.getConnection();
        } catch (NamingException | SQLException e) {
            log.error("Could not get connection to DB: "+e);
        }
        return connection;
    }

    @Override
    public void close() {
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            log.info("Do not close connection: "+e);
        }
    }
}
