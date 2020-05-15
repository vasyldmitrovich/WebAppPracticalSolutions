package org.practicalsolutions.dao.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.practicalsolutions.dao.DBCPDataSource;
import org.practicalsolutions.dao.DBConnection;
import org.practicalsolutions.dao.ProductDao;
import org.practicalsolutions.dao.entity.Phone;
import org.practicalsolutions.dao.entity.Product;
import org.practicalsolutions.dao.entity.Television;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoImp implements ProductDao {

    public static final Logger log = LogManager.getLogger(ProductDaoImp.class);

    @Override
    public void addProduct(Product product) {
        if (product != null) {
            DBCPDataSource dbcpDataSource = new DBCPDataSource();

            String firstSql = "INSERT INTO solutions.products (name, price, manufacturer, " +
                    "year_of_manufacturer, category) VALUE ('"+product.getName()+"',"+product.getPrice()+
                    ",'"+product.getManufacturer()+"',"+product.getYearOfManufacturer()+
                    ",'"+product.getCategory()+"');";

            try (Connection connection = dbcpDataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(firstSql);

                if (product instanceof Phone) {
                    String phoneSql = "INSERT INTO solutions.phones (screen_diagonal, ram, internal_memory,"+
                            "id_category) VALUE ("+((Phone) product).getScreenDiagonal()+","+((Phone) product).getRam()+
                            ","+((Phone) product).getInternalMemory()+",LAST_INSERT_ID());";
                    statement.executeUpdate(phoneSql);
                    log.info("Add product -Phone- to DB");

                } else if (product instanceof Television) {
                    String televisionSql = "INSERT INTO solutions.televisions (screen_diagonal,id_category) " +
                            "VALUE ("+((Television) product).getScreenDiagonal()+",LAST_INSERT_ID());";
                    statement.executeUpdate(televisionSql);
                    log.info("Add product -Television- to DB");
                } else {
                    log.info("Add product -Product- to DB");
                }

            } catch (SQLException e) {
                log.error("Can not add data to DB: "+e);
            }
        }
        else {
            log.error("Give empty product, can not get data from empty object and add to DB");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        DBCPDataSource dbcpDataSource = new DBCPDataSource();
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try (Connection connection = dbcpDataSource.getConnection()){

            /*Get Phone from DB*/
            String sqlPhone = "SELECT * FROM solutions.products INNER JOIN solutions.phones ON products.id = phones.id_category;";
            preparedStatement = connection.prepareStatement(sqlPhone);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Phone phone = new Phone();
                phone.setId(resultSet.getLong("id"));
                phone.setName(resultSet.getString("name"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setYearOfManufacturer(resultSet.getInt("year_of_manufacturer"));
                phone.setCategory(resultSet.getString("category"));
                phone.setScreenDiagonal(resultSet.getDouble("screen_diagonal"));
                phone.setScreenDiagonal(resultSet.getDouble("ram"));
                phone.setInternalMemory(resultSet.getDouble("internal_memory"));
                phone.setIdCategory(resultSet.getLong("id_category"));
                productList.add(phone);
            }

            /*Get Television from DB*/
            String sqlTelevision = "SELECT * FROM solutions.products INNER JOIN solutions.televisions ON products.id = televisions.id_category;";
            preparedStatement = connection.prepareStatement(sqlTelevision);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Television television = new Television();
                television.setId(resultSet.getLong("id"));
                television.setName(resultSet.getString("name"));
                television.setPrice(resultSet.getDouble("price"));
                television.setManufacturer(resultSet.getString("manufacturer"));
                television.setYearOfManufacturer(resultSet.getInt("year_of_manufacturer"));
                television.setCategory(resultSet.getString("category"));
                television.setScreenDiagonal(resultSet.getDouble("screen_diagonal"));
                television.setId_category(resultSet.getLong("id_category"));
                productList.add(television);
            }

            /*Add another products
            what need get from DB*/

        } catch (SQLException e) {
            log.error("Can not get data from DB: "+e);
        }
        return productList;
    }





    /*Only for testing
    *This is simple connection to DB*/
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
                phone.setYearOfManufacturer(resultSet.getInt("year_of_manufacture"));
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
                phone.setYearOfManufacturer(resultSet.getInt("year_of_manufacture"));
                phone.setScreenDiagonal(resultSet.getDouble("screen_diagonal"));
                phone.setScreenDiagonal(resultSet.getDouble("ram"));
                phone.setInternalMemory(resultSet.getDouble("internal_memory"));
            }
        } catch (SQLException e) {
            log.error("SQLException do not get data from DB: "+e);
            e.printStackTrace();
        }
        return phone;
    }

}
