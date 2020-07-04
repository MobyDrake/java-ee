package ru.mobydrake.dto;


import ru.mobydrake.entities.Product;

import java.math.BigDecimal;

public class ProductPojo {

    private Long id;
    private String name;
    private String description;
    private Double price;
    private CategoryPojo categoryPojo;

    public ProductPojo() {
    }

    public ProductPojo(Product product) {
        this.id = product.getId();
        this.name = product.getName();
        this.description = product.getDescription();
        this.price = product.getPrice();
        if (product.getCategory() != null) {
            this.categoryPojo = new CategoryPojo(product.getCategory());
        }
    }

    public Product createProduct() {
        Product product = new Product();
        product.setName(name);
        if (categoryPojo != null) {
            product.setCategory(categoryPojo.createCategory());
        }
        product.setDescription(description);
        product.setPrice(price);
        return product;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public CategoryPojo getCategoryPojo() {
        return categoryPojo;
    }

    public void setCategoryPojo(CategoryPojo categoryPojo) {
        this.categoryPojo = categoryPojo;
    }
}
