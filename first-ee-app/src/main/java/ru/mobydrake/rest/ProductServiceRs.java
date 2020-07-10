package ru.mobydrake.rest;

import ru.mobydrake.dto.ProductPojo;

import javax.ejb.Local;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Local
@Path("/product")
public interface ProductServiceRs {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    void insertProduct(ProductPojo productPojo);

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    void update(ProductPojo productPojo);

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    ProductPojo findById(@PathParam("id") Long id);

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductPojo> findAll();

    @GET
    @Path("/byCategoryId/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    List<ProductPojo> findAllByCategoryId(@PathParam("id") Long id);

    @POST
    @Path("/{id}")
    void delete(@PathParam("id") Long id);

    ProductPojo findProductByName(String name);
}