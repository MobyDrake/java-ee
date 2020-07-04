package ru.mobydrake.dto;

import ru.mobydrake.entities.Category;

public class CategoryPojo {
    private Long id;
    private String name;

    public CategoryPojo() {
    }

    public CategoryPojo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryPojo(Category category) {
        this(category.getId(), category.getName());
    }

    public Category createCategory(){
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        return category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

}
