package com.socialmobile.phoneshopping.service.resources;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.Product;
import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Path("products")
public class ProductServiceResource {
    @Autowired
    private ProductService mProductService;

    public ProductService getProductService() {
        return mProductService;
    }

    public void setProductService(ProductService pProductService) {
        mProductService = pProductService;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getProducts(final @QueryParam("start") int pStart, final @QueryParam("count") int pCount)
            throws JsonProcessingException {
        List<Product> products = mProductService.getProducts(pStart, pCount);

        return Response.ok(JSONObjectFactory.getsInstance().objectToString(products)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{productId}")
    public Response getUser(final @PathParam("productId") int pProductId) throws JsonProcessingException {
        Product product = mProductService.get(pProductId);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(product))
                .build();
    }

    @DELETE
    @Path("/{productId}")
    public Response deleteUser(final @PathParam("productId") int pProductId) {
        boolean deleted = mProductService.delete(pProductId);
        Response.Status status = deleted ? Response.Status.OK : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final Product pProduct) {
        Product product = mProductService.create(pProduct);
        return Response.status(Response.Status.CREATED)
                .entity(product.getProductId())
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{productId}")
    public Response updateUser(final @PathParam("productId") int pProductId, final Product pProduct) throws JsonProcessingException {
        Product product = mProductService.update(pProductId, pProduct);
        if (product == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(product))
                .build();

    }
}
