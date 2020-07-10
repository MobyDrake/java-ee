package ru.mobydrake.repository;

import ru.mobydrake.entities.Product;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Stateless
public class ProductRepositoryImp implements ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Override
    @TransactionAttribute
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    @TransactionAttribute
    public void delete(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Override
    @TransactionAttribute
    public void update(Product product) {
        entityManager.merge(product);
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public Product findByName(String name) {
        return entityManager.createNamedQuery("ProductByName", Product.class).setParameter("name", name).getSingleResult();
    }

    @Override
    public List<Product> findAllByCategoryId(Long id) {
        return entityManager.createQuery("from Product where category.id = :id").setParameter("id", id).getResultList();
    }
}
