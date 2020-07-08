package ru.mobydrake.service;

import ru.mobydrake.dto.ProductPojo;
import ru.mobydrake.entities.Category;
import ru.mobydrake.entities.Product;
import ru.mobydrake.repository.CategoryRepository;
import ru.mobydrake.repository.ProductRepository;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Named
@ApplicationScoped
@WebService(endpointInterface = "ru.mobydrake.service.ProductServiceWs", serviceName = "ProductService")
public class ProductService implements ProductServiceWs{

    @EJB
    private ProductRepository productRepository;

    @EJB
    private CategoryRepository categoryRepository;

    @Override
    @Transactional
    public void insertProduct(ProductPojo productPojo){
        Category category = categoryRepository.findCategoryById(productPojo.getCategoryId());
        Product product = new Product();

        product.setName(productPojo.getName());
        product.setDescription(productPojo.getDescription());
        product.setPrice(productPojo.getPrice());
        product.setCategory(category);

        productRepository.save(product);
    }

    @Override
    @Transactional
    public void update(ProductPojo productPojo){
        Category category = categoryRepository.findCategoryById(productPojo.getCategoryId());
        Product product = productRepository.findById(productPojo.getId());

        product.setName(productPojo.getName());
        product.setPrice(productPojo.getPrice());
        product.setDescription(productPojo.getDescription());
        product.setCategory(category);

        productRepository.update(product);
    }

    @Override
    @Transactional
    public ProductPojo findById(Long id){
        return new ProductPojo(productRepository.findById(id));
    }

    @Override
    @Transactional
    public List<ProductPojo> findAll(){
        return productRepository.findAll().stream()
                .map(ProductPojo::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductPojo> findAllByCategoryId(Long id) {
        return productRepository.findAllByCategoryId(id)
                .stream()
                .map(ProductPojo::new)
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        productRepository.delete(id);
    }

    @Override
    public ProductPojo findProductByName(String name) {
        return new ProductPojo(productRepository.findByName(name));
    }
}
