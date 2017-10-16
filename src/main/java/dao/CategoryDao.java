package dao;

import model.Category;

import java.util.List;

public interface CategoryDao {

    List<Category> getAll();

    Category getByName(String name);

}
