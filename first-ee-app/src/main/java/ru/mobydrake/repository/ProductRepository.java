package ru.mobydrake.repository;

import ru.mobydrake.entities.Product;

import javax.ejb.Local;
import java.util.List;

@Local
public interface ProductRepository {
    List<Product> findAll();

    void save(Product product);

    void delete(Long id);

    void update(Product product);

    Product findById(Long id);
}
