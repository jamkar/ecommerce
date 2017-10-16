package dao.impl;

import dao.BaseDao;
import dao.DataProvider;
import dao.ProductDao;
import model.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("productDao")
public class ProductDaoImpl extends BaseDao implements ProductDao {

    @Override
    public void add(Product product) {
        getSession().persist(product);
    }

    @Override
    public void update(Product product) {

    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Product getById(long id) {
        return null;
    }

    @Override
    public Product getByName(String name) {
        return null;
    }

    @Override
    public List<Product> getByCategoryName(String name) {
        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
