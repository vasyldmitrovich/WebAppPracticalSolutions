package org.practicalsolutions.dao.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.DBCPDataSource;
import org.practicalsolutions.dao.DBConnection;
import org.practicalsolutions.dao.ProductDao;
import org.practicalsolutions.dao.entity.Phone;

import java.sql.*;

public class ProductDaoImp implements ProductDao {

    public static final Logger log = LogManager.getLogger(ProductDaoImp.class);

    /*This is simple connection to DB*/
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

    /*This is testing pool connection to DB*/
    public Phone getDBConnectionPoolTEMP() {
        String sql ="select id,price,manufacturer,year_of_manufacture,screen_diagonal,ram,internal_memory \n" +
                "from solutions.phone where id=1;";
        Phone phone = new Phone();

        DBCPDataSource dbcpDataSource = new DBCPDataSource();
        try (Connection connection = dbcpDataSource.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery()){

            while (resultSet.next()) {
                phone.setId(resultSet.getLong("id"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setYear(resultSet.getInt("year_of_manufacture"));
                phone.setScreenDiagonal(resultSet.getDouble("screen_diagonal"));
                phone.setScreenDiagonal(resultSet.getDouble("ram"));
                phone.setInternalMemory(resultSet.getDouble("internal_memory"));
            }
        } catch (SQLException e) {
            log.error("SQLException from pull"+e);
            e.printStackTrace();
        }
        return phone;
    }

}
