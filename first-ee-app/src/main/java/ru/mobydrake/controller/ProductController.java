package ru.mobydrake.controller;

import ru.mobydrake.entities.Product;
import ru.mobydrake.repository.CategoryRepository;
import ru.mobydrake.repository.ProductRepository;

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
    private ProductRepository productRepository;

    @Inject
    private CategoryRepository categoryRepository;

    private Product product;
    private Long categoryId;


    private List<Product> products;

    public void preLoadProduct(ComponentSystemEvent componentSystemEvent) {
        products = productRepository.findAll();
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public List<Product> findAllProduct() {
        return products;
    }

    public String createProduct() {
        this.product = new Product();
        return "/product.xhtml?faces-redirect=true";
    }

    public String editProduct(Product product) {
        this.product = product;
        if (categoryId != null) {
            product.setCategory(categoryRepository.findCategoryById(categoryId));
        }
        return "/product.xhtml?faces-redirect=true";
    }

    public void deleteProduct(Product product) {
        productRepository.delete(product.getId());
    }

    public String saveProduct() {
        if (product.getId() == null) {
            productRepository.save(product);
        } else {
            productRepository.update(product);
        }
        return "/index.xhtml?faces-redirect=true";
    }
}