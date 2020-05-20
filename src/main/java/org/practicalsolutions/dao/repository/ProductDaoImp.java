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
                log.error("Could not add data to DB: "+e);
            }
        }
        else {
            log.error("Get empty product, could not get data from empty object and add to DB");
        }
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        DBCPDataSource dbcpDataSource = new DBCPDataSource();
        PreparedStatement preparedStatement;
        ResultSet resultSet;

        try (Connection connection = dbcpDataSource.getConnection()){

            /*Get Products from DB*/
            String sqlProduct = "SELECT * FROM solutions.products WHERE category='Product';";
            preparedStatement = connection.prepareStatement(sqlProduct);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product product = new Product.Builder()
                        .setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setPrice(resultSet.getDouble("price"))
                        .setManufacturer(resultSet.getString("manufacturer"))
                        .setYearOfManufacturer(resultSet.getInt("year_of_manufacturer"))
                        .setCategory(resultSet.getString("category"))
                        .build();
                productList.add(product);
            }

            /*Get Phones from DB*/
            String sqlPhone = "SELECT * FROM solutions.products INNER JOIN solutions.phones ON products.id = phones.id_category;";
            preparedStatement = connection.prepareStatement(sqlPhone);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product phone = new Phone.Builder()
                        .setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setPrice(resultSet.getDouble("price"))
                        .setManufacturer(resultSet.getString("manufacturer"))
                        .setYearOfManufacturer(resultSet.getInt("year_of_manufacturer"))
                        .setCategory(resultSet.getString("category"))
                        .setScreenDiagonal(resultSet.getDouble("screen_diagonal"))
                        .setRam(resultSet.getDouble("ram"))
                        .setInternalMemory(resultSet.getDouble("internal_memory"))
                        .setIdCategory(resultSet.getLong("id_category"))
                        .build();
                productList.add(phone);
            }

            /*Get Televisions from DB*/
            String sqlTelevision = "SELECT * FROM solutions.products INNER JOIN solutions.televisions ON products.id = televisions.id_category;";
            preparedStatement = connection.prepareStatement(sqlTelevision);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Product television = new Television.Builder()
                        .setId(resultSet.getLong("id"))
                        .setName(resultSet.getString("name"))
                        .setPrice(resultSet.getDouble("price"))
                        .setManufacturer(resultSet.getString("manufacturer"))
                        .setYearOfManufacturer(resultSet.getInt("year_of_manufacturer"))
                        .setCategory(resultSet.getString("category"))
                        .setScreenDiagonal(resultSet.getDouble("screen_diagonal"))
                        .setIdCategory(resultSet.getLong("id_category"))
                        .build();
                productList.add(television);
            }


            /*Add another products here*/


        } catch (SQLException e) {
            log.error("Could not get data from DB: "+e);
        }
        return productList;
    }

    @Override
    public void removeProduct(long id) {
        DBCPDataSource dbcpDataSource = new DBCPDataSource();

        String sqlDelete = "DELETE FROM solutions.products WHERE id='"+id+"';";

        try (Connection connection = dbcpDataSource.getConnection();
             Statement statement = connection.createStatement()){
            int rows = statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            log.error("Could not delete data from DB: "+e);
        }
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
