package ru.mobydrake.repository;

import ru.mobydrake.entities.Product;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.*;
import java.util.List;

@Named
@ApplicationScoped
public class ProductRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @Inject
    private UserTransaction ut;

    @PostConstruct
    public void init() {
        if (this.findAll().isEmpty()) {
            try {
                ut.begin();
                save(new Product("pen", "something helpful", 10.2));
                save(new Product("bread", "something helpful", 3.2));
                save(new Product("egg", "something helpful", 7.9));
                ut.commit();
            } catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException e) {
                e.printStackTrace();
            }
        }
    }

    public List<Product> findAll() {
        return entityManager.createQuery("from Product", Product.class).getResultList();
    }

    @Transactional
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Transactional
    public void delete(Long id) {
        Product product = entityManager.find(Product.class, id);
        if (product != null) {
            entityManager.remove(product);
        }
    }

    @Transactional
    public void update(Product product) {
        entityManager.merge(product);
    }

    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }
}
