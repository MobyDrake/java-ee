package ru.mobydrake.controller;

import ru.mobydrake.dto.ProductPojo;
import ru.mobydrake.entities.Product;
import ru.mobydrake.service.CategoryService;
import ru.mobydrake.service.ProductService;

import javax.enterprise.context.SessionScoped;
import javax.faces.event.ComponentSystemEvent;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class ProductController implements Serializable {

    @Inject
    private ProductService productService;

    @Inject
    private CategoryService categoryService;

    private ProductPojo productPojo;
    private Long categoryId;


    private List<ProductPojo> products;

    public void preLoadProduct(ComponentSystemEvent componentSystemEvent) {
        products = productService.findAll();
    }

    public ProductPojo getProductPojo() {
        return productPojo;
    }

    public void setProductPojo(ProductPojo productPojo) {
        this.productPojo = productPojo;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<ProductPojo> findAllProduct() {
        return products;
    }

    public String createProduct() {
        this.productPojo = new ProductPojo();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(ProductPojo productPojo) {
        this.productPojo = productPojo;
        if (categoryId != null) {
            productPojo.setCategoryPojo(categoryService.findCategoryById(categoryId));
        }
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(ProductPojo productPojo) {
        productService.delete(productPojo.getId());
    }

    public String saveProduct() {
        if (productPojo.getId() == null) {
            productService.insert(productPojo);
        } else {
            productService.update(productPojo);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}
