package org.practicalsolutions.dao.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.DBConnection;
import org.practicalsolutions.dao.ProductDao;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ProductDaoImp implements ProductDao {

    public static final Logger log = LogManager.getLogger(ProductDaoImp.class);

    public Phone getProductById() {
        DBConnection dbConnection = new DBConnection();
        String sql ="select id,price,manufacturer,year_of_manufacture,screen_diagonal,ram,internal_memory \n" +
                "from solutions.phone where id=1;";
        Phone phone = new Phone();
        try (Connection connection = dbConnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql)){
            if (resultSet.next()) {
                phone.setId(resultSet.getLong("id"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setYear(resultSet.getInt("year_of_manufacture"));
                phone.setScreenDiagonal(resultSet.getDouble("ram"));
                phone.setInternalMemory(resultSet.getDouble("internal_memory"));
            }
        } catch (SQLException s) {
            log.error("SQLException can not get Product from DB"+s);
        }
        return phone;
    }

//
//    //this trying create
//    public void createPhone() throws NamingException, SQLException {
//        String sql = "create table if not exists solutions.phone1";
//        //Connection connectionPool = ConnectionPool.getInstance().getConnection();
//        InitialContext initContext= new InitialContext();
//        DataSource ds = (DataSource) initContext.lookup("java:comp/env/jdbc/DBConnectionPull");
//        Connection conn = ds.getConnection();
//        Statement statement = conn.createStatement();
//        statement.executeUpdate(sql);
//        try {
//            //PreparedStatement preparedStatement = connectionPool.prepareStatement(sql);
//
//            //statement.executeUpdate(sql);
//            //statement.executeUpdate(sql);
//
//            //preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sql exception"+ e);
//            try {
//                connectionPool.close();
//            }catch (SQLException e1) {
//                System.out.println("Sql exception"+ e1);
//            }
//        }
//        try {
//            connectionPool.close();
//        } catch (SQLException e) {
//            System.out.println("Sql exception"+ e);
//        }
//    }
//
//    public static void main(String[] args) {
//
//        String sql = "select * from solutions.phone where id=1";
//        Connection connectionPool = ConnectionPool.getInstance().getConnection();
//        try {
//            PreparedStatement preparedStatement = connectionPool.prepareStatement(sql);
//            preparedStatement.setDouble(2,3.3);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Sql exception"+ e);
//            try {
//                connectionPool.close();
//            }catch (SQLException e1) {
//                System.out.println("Sql exception"+ e1);
//            }
//        }
//        try {
//            connectionPool.close();
//        } catch (SQLException e) {
//            System.out.println("Sql exception"+ e);
//        }
//    }
//
//    private Connection getConnection() {
//        Connection connection = null;
//        try {
//            connection = DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/solutions?serverTimezone=UTC?autoReconnect=true");
//            log.info("Got connection");
//        } catch (SQLException e) {
//            log.error("SQLException can not give connection" + e);
//        }
//
//        return connection;
//    }//This is bac decision
}
