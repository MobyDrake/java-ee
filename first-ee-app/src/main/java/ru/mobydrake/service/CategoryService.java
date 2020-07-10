package ru.mobydrake.service;

import ru.mobydrake.dto.CategoryPojo;
import ru.mobydrake.entities.Category;
import ru.mobydrake.repository.CategoryRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class CategoryService {

    @EJB
    CategoryRepository categoryRepository;

    @Transactional
    public List<CategoryPojo> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryPojo::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public void insert(CategoryPojo categoryPojo){
        categoryRepository.insert(categoryPojo.createCategory());
    }

    @Transactional
    public void update(CategoryPojo categoryPojo){
        Category category = categoryRepository.findCategoryById(categoryPojo.getId());
        category.setName(categoryPojo.getName());
        categoryRepository.update(category);
    }

    @Transactional
    public CategoryPojo findCategoryById(Long id){
        return new CategoryPojo(categoryRepository.findCategoryById(id));
    }

    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
