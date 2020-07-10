package ru.mobydrake.service;

import ru.mobydrake.dto.ProductPojo;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ProductServiceWs {
    @WebMethod
    void insertProduct(ProductPojo productPojo);

    @WebMethod
    void update(ProductPojo productPojo);

    @WebMethod
    ProductPojo findById(Long id);

    @WebMethod
    List<ProductPojo> findAll();

    @WebMethod
    List<ProductPojo> findAllByCategoryId(Long id);

    @WebMethod
    void delete(Long id);

    @WebMethod
    ProductPojo findProductByName(String name);
}
