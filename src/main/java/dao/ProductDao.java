package dao;

import model.Product;

import java.util.List;

public interface ProductDao {

    void add(Product product);

    void update(Product product);

    void delete(long id);

    Product getById(long id);

    Product getByName(String name);

    List<Product> getByCategoryName(String name);

    List<Product> getAll();

}
