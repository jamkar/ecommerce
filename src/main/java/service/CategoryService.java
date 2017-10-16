package service;

import model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();

    Category getByName(String name);

}
