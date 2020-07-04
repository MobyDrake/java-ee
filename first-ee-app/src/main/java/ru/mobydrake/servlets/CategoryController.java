package ru.mobydrake.servlets;

import ru.mobydrake.entities.Category;
import ru.mobydrake.repository.CategoryRepository;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

@SessionScoped
@Named
public class CategoryController implements Serializable {

    @Inject
    private CategoryRepository categoryRepository;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Category> getAllCategory() throws SQLException {
        return categoryRepository.findAll();
    }

    public String create(){
        this.category = new Category();
        return "/category_edit.xhtml?faces-redirect=true";
    }


    public String edit(Category category){
        this.category = category;
        return "/category_edit.xhtml?faces-redirect=true";
    }

    public String save() {
        if (category.getId() == null) {
            categoryRepository.insert(category);
        } else {
            categoryRepository.update(category);
        }
        return "/category_all.xhtml?faces-redirect=true";
    }

    public void delete(Category category) throws SQLException {
        categoryRepository.delete(category.getId());
    }
}
