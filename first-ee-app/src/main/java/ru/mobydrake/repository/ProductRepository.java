package ru.mobydrake.repository;

import ru.mobydrake.entities.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.servlet.ServletException;
import java.util.ArrayList;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {

    private List<Product> productList;

    @PostConstruct
    public void init() throws ServletException {
        productList = new ArrayList<>();

        productList.add(new Product(1L, "black pen", "something helpful", 10.2));
        productList.add(new Product(2L, "bread", "something helpful", 3.2));
        productList.add(new Product(3L, "egg", "something helpful", 7.9));
        productList.add(new Product(4L, "milk", "something helpful", 9.2));
        productList.add(new Product(5L, "note", "something helpful", 10.2));
        productList.add(new Product(6L, "razor", "something helpful", 3.5));
        productList.add(new Product(7L, "book", "something helpful", 15.5));
        productList.add(new Product(8L, "red pen", "something helpful", 10.2));
        productList.add(new Product(9L, "blue pen", "something helpful", 10.2));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void saveProduct(Product product) {
        product.setId((productList.size() + 1L));
        productList.add(product);
    }
}
