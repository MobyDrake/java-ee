package ru.mobydrake.service;

import ru.mobydrake.dto.CategoryPojo;
import ru.mobydrake.entities.Category;
import ru.mobydrake.repository.CategoryRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
@WebService(endpointInterface = "ru.mobydrake.service.CategoryServiceWs", serviceName = "CategoryService")
public class CategoryService implements CategoryServiceWs {

    @EJB
    CategoryRepository categoryRepository;

    @Override
    @Transactional
    public List<CategoryPojo> findAll() {
        return categoryRepository.findAll().stream()
                .map(CategoryPojo::new)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void insertCategory(CategoryPojo categoryPojo){
        categoryRepository.insert(categoryPojo.createCategory());
    }

    @Override
    @Transactional
    public void update(CategoryPojo categoryPojo){
        Category category = categoryRepository.findCategoryById(categoryPojo.getId());
        category.setName(categoryPojo.getName());
        categoryRepository.update(category);
    }

    @Override
    @Transactional
    public CategoryPojo findCategoryById(Long id){
        return new CategoryPojo(categoryRepository.findCategoryById(id));
    }

    @Override
    @Transactional
    public void delete(Long id) {
        categoryRepository.delete(id);
    }
}
