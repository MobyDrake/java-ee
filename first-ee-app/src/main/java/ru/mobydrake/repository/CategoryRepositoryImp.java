package ru.mobydrake.repository;

import ru.mobydrake.entities.Category;

import javax.ejb.Stateless;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;
import java.io.Serializable;
import java.util.List;

@Stateless
public class CategoryRepositoryImp implements CategoryRepository {

    @PersistenceContext(unitName = "ds")
    private EntityManager entityManager;

    @Override
    public List<Category> findAll() {
        return entityManager.createQuery("from Category", Category.class).getResultList();
    }

    @Override
    @Transactional
    public void insert(Category category) {
        entityManager.persist(category);
    }

    @Override
    @Transactional
    public void update(Category category) {
        entityManager.merge(category);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        Category category = entityManager.find(Category.class, id);
        if (category != null) {
            entityManager.remove(category);
        }
    }

    @Override
    public Category findCategoryById(long id) {
        return entityManager.find(Category.class, id);
    }
}
