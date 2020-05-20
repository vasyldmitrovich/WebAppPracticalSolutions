package org.practicalsolutions.dao;

import org.practicalsolutions.dao.entity.Product;

import java.util.List;

/*Will be all methods, which are needed to work with DB*/
public interface ProductDao {
    void addProduct(Product product);
    List<Product> getAllProducts();
    void removeProduct(long id);
}
