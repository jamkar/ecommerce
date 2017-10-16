package dao.impl;

import dao.BaseDao;
import dao.CategoryDao;
import model.Category;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("categoryDao")
public class CategoryDaoImpl extends BaseDao implements CategoryDao {

    @Override
    public List<Category> getAll() {
        return null;
    }

    @Override
    public Category getByName(String name) {
        return null;
    }
}
