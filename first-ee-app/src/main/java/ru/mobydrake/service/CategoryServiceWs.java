package ru.mobydrake.service;

import ru.mobydrake.dto.CategoryPojo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface CategoryServiceWs {

    @WebMethod
    void insertCategory(CategoryPojo categoryPojo);

    @WebMethod
    CategoryPojo findCategoryById(Long id);

    @WebMethod
    void delete(Long id);

    @WebMethod
    void update(CategoryPojo categoryPojo);

    @WebMethod
    List<CategoryPojo> findAll();
}