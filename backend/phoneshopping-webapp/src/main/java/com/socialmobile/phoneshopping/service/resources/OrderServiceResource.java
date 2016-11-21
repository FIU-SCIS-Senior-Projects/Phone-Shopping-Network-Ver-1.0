package com.socialmobile.phoneshopping.service.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.Order;
import com.socialmobile.phoneshopping.service.api.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.HashMap;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Path("orders")
public class OrderServiceResource {

    @Autowired
    private OrderService mOrderService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{orderId}")
    public Response getUser(final @PathParam("orderId") int pOrderId) throws JsonProcessingException {
        Order order = mOrderService.get(pOrderId);
        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(order))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response placeOrder(final Order pOrder) throws JsonProcessingException {
        Order order = mOrderService.create(pOrder);

        return Response.status(Response.Status.CREATED)
                .entity(buildMessage(order))
                .build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{orderId}")
    public Response updateOrder(final @PathParam("orderId") int pOrderId, final Order pOrder) throws JsonProcessingException {
        Order order = mOrderService.update(pOrderId, pOrder);
        if (order == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(order))
                .build();

    }

    private String buildMessage(final Order pOrder) throws JsonProcessingException {
        HashMap map = new HashMap();
        map.put("order", pOrder);
        map.put("message", "Your recent order has been placed successfully. " +
                "Soon you will get an SMS on your registered phone about how the proceed with the payment. " +
                "Thank you very much for being loyal to Social Mobile USA.");
        return JSONObjectFactory.getsInstance().objectToString(map);
    }
}
