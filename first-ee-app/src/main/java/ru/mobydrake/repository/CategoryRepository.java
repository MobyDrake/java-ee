package ru.mobydrake.repository;

import ru.mobydrake.entities.Category;

import javax.ejb.Local;
import java.util.List;

@Local
public interface CategoryRepository {

    List<Category> findAll();

    void insert(Category category);

    void update(Category category);

    void delete(Long id);

    Category findCategoryById(long id);
}
