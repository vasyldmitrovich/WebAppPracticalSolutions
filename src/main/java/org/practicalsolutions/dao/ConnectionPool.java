package org.practicalsolutions.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.controller.IndexServlet;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.naming.directory.InitialDirContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionPool {

    public static final Logger log = LogManager.getLogger(ConnectionPool.class);
    private static ConnectionPool instance = null;

    private ConnectionPool() {}

    public static ConnectionPool getInstance() {
        if (instance == null) instance = new ConnectionPool();
        return instance;
    }
    public Connection getConnection() {
        Context ctx;
        Connection c = null;
        try {
            ctx = new InitialDirContext();
            DataSource ds = (DataSource) ctx.lookup("ava:comp/env/jdbc/DBConnectionPull");
            c = ds.getConnection();
        } catch (NamingException e) {
            log.error("Naming Exception from connection pool "+e);
        } catch (SQLException e) {
            log.error("SQL Exception from connection pool"+e);
        }
        return c;
    }


}
