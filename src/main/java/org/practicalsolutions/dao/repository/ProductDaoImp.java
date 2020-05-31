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

    //TODO Rewrite logic in addProduct method and add AutoCloseable
    @Override
    public void addProduct(Product product) {
        if (product != null) {
            String firstSql = "INSERT INTO solutions.products (name, price, manufacturer, " +
                    "year_of_manufacturer, category) VALUE ('" + product.getName() + "'," + product.getPrice() +
                    ",'" + product.getManufacturer() + "'," + product.getYearOfManufacturer() +
                    ",'" + product.getCategory() + "');";

            DBCPDataSource dbcpDataSource = new DBCPDataSource();

            try (Connection connection = dbcpDataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(firstSql);

                /*Add
                 * condition
                 * another
                 * product
                 * here*/

                if (product instanceof Phone) {
                    String phoneSql = "INSERT INTO solutions.phones (screen_diagonal, ram, internal_memory," +
                            "id_category) VALUE (" + ((Phone) product).getScreenDiagonal() + "," +
                            ((Phone) product).getRam() + "," + ((Phone) product).getInternalMemory() +
                            ",LAST_INSERT_ID());";
                    statement.executeUpdate(phoneSql);
                    log.info("Added product with category -Phone- to DB");

                } else if (product instanceof Television) {
                    String televisionSql = "INSERT INTO solutions.televisions (screen_diagonal,id_category) " +
                            "VALUE (" + ((Television) product).getScreenDiagonal() + ",LAST_INSERT_ID());";
                    statement.executeUpdate(televisionSql);
                    log.info("Added product with category -Television- to DB");
                } else {
                    log.info("Added product with category -Product- to DB");
                }
            } catch (SQLException e) {
                log.error("Could not add data to DB: " + e);
            }
        } else {
            log.error("Empty product");
        }
    }

    //TODO Rewrite logic in getAllProduct method and add AutoCloseable
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = new ArrayList<>();

        DBCPDataSource dbcpDataSource = new DBCPDataSource();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try (Connection connection = dbcpDataSource.getConnection()) {

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
            log.error("Could not get data from DB: " + e);
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                log.info("Do not close ResultSet: "+e);
            }
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
            } catch (SQLException e) {
                log.info("Do not close PreparedStatement: "+e);
            }
        }
        return productList;
    }

    @Override
    public void removeProduct(long id) {
        DBCPDataSource dbcpDataSource = new DBCPDataSource();

        String sqlDelete = "DELETE FROM solutions.products WHERE id='" + id + "';";

        try (Connection connection = dbcpDataSource.getConnection();
             Statement statement = connection.createStatement()) {
            int rows = statement.executeUpdate(sqlDelete);
        } catch (SQLException e) {
            log.error("Could not delete data from DB: " + e);
        }
    }

    @Override
    public void updateProduct(Product product) {
        if (product != null) {
            String sqlUpdate = "UPDATE solutions.products SET products.name='" + product.getName() + "',\n" +
                    "                              products.price=" + product.getPrice() + ",\n" +
                    "                              products.manufacturer='" + product.getManufacturer() + "',\n" +
                    "                              products.year_of_manufacturer=" + product.getYearOfManufacturer() +
                    "\n" +
                    "WHERE products.id=" + product.getId() + ";";

            /*Add
             * condition
             * another
             * product
             * here*/

            if (product instanceof Phone) {
                sqlUpdate = "UPDATE solutions.products INNER JOIN solutions.phones ON products.id=phones.id_category\n" +
                        "SET products.name='" + product.getName() + "',\n" +
                        "    products.price=" + product.getPrice() + ",\n" +
                        "    products.manufacturer='" + product.getManufacturer() + "',\n" +
                        "    products.year_of_manufacturer=" + product.getYearOfManufacturer() + ",\n" +
                        "    phones.screen_diagonal=" + ((Phone) product).getScreenDiagonal() + ",\n" +
                        "    phones.ram=" + ((Phone) product).getRam() + ",\n" +
                        "    phones.internal_memory=" + ((Phone) product).getInternalMemory() + "\n" +
                        "WHERE solutions.products.id=" + product.getId() + ";";
            }
            if (product instanceof Television) {
                sqlUpdate = "UPDATE solutions.products INNER JOIN solutions.televisions ON " +
                        "products.id=televisions.id_category\n" +
                        "SET products.name='" + product.getName() + "',\n" +
                        "    products.price=" + product.getPrice() + ",\n" +
                        "    products.manufacturer='" + product.getManufacturer() + "',\n" +
                        "    products.year_of_manufacturer=" + product.getYearOfManufacturer() + ",\n" +
                        "    televisions.screen_diagonal=" + ((Television) product).getScreenDiagonal() + "\n" +
                        "WHERE solutions.products.id=" + product.getId() + ";";
            }

            DBCPDataSource dbcpDataSource = new DBCPDataSource();

            try (Connection connection = dbcpDataSource.getConnection();
                 Statement statement = connection.createStatement()) {
                statement.executeUpdate(sqlUpdate);
            } catch (SQLException e) {
                log.error("Could not update data in DB: " + e);
            }
        } else {
            log.error("Empty product");
        }
    }


    /*Only for testing*/
    public Phone getProductById(long id) {
        DBConnection dbConnection = new DBConnection();
        String sql = "select * from solutions.phones where id=" + id + ";";
        Phone phone = new Phone();
        try (Connection connection = dbConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            if (resultSet.next()) {
                phone.setId(resultSet.getLong("id"));
                phone.setPrice(resultSet.getDouble("price"));
                phone.setManufacturer(resultSet.getString("manufacturer"));
                phone.setYearOfManufacturer(resultSet.getInt("year_of_manufacture"));
                phone.setScreenDiagonal(resultSet.getDouble("ram"));
                phone.setInternalMemory(resultSet.getDouble("internal_memory"));
            }
        } catch (SQLException s) {
            log.error("Can not get Product from DB" + s);
        }
        return phone;
    }//Simple connection to DB

}
