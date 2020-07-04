package ru.mobydrake.repository;

import ru.mobydrake.entities.Category;
import ru.mobydrake.entities.Product;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;

@SessionScoped
@Named
public class CategoryRepository implements Serializable {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @Inject
    private UserTransaction ut;

    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Transactional
    public void insert(Category category) {
        entityManager.persist(category);
    }

    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Transactional
    public void delete(Long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    public Category findCategoryById(long id) {
        return entityManager.find(Category.class, id);
    }
}
