package ru.mobydrake.service;

import ru.mobydrake.dto.ProductPojo;
import ru.mobydrake.repository.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
public class ProductService {

    @EJB
    ProductRepository productRepository;

    @Transactional
    public void insert(ProductPojo productPojo){
        productRepository.save(productPojo.createProduct());
    }

    @Transactional
    public void update(ProductPojo productPojo){
        productRepository.update(productPojo.createProduct());
    }

    @Transactional
    public ProductPojo findById(Long id){
        return new ProductPojo(productRepository.findById(id));
    }

    @Transactional
    public List<ProductPojo> findAll(){
        return productRepository.findAll().stream()
                .map(ProductPojo::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }
}
