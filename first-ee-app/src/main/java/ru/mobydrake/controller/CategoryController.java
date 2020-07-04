package ru.mobydrake.controller;

import ru.mobydrake.dto.CategoryPojo;
import ru.mobydrake.entities.Category;
import ru.mobydrake.service.CategoryService;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @Inject
    private CategoryService categoryService;
    private Category category;
    private CategoryPojo categoryPojo;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public CategoryPojo getCategoryPojo() {
        return categoryPojo;
    }

    public void setCategoryPojo(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
    }

    public List<CategoryPojo> getAllCategory() {
        return categoryService.findAll();
    }

    public String create() {
        this.categoryPojo = new CategoryPojo();
        return "/category_edit.xhtml?faces-redirect=true";
    }

    public String edit(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
        return "/category_edit.xhtml?faces-redirect=true";
    }

    public String save() {
        if (categoryPojo.getId() == null) {
            categoryService.insert(categoryPojo);
        } else {
            categoryService.update(categoryPojo);
        }
        return "/category_all.xhtml?faces-redirect=true";
    }

    public void delete(CategoryPojo categoryPojo) {
        categoryService.delete(categoryPojo.getId());
    }
}
