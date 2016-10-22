package com.socialmobile.phoneshopping.web.resources;

import sun.plugin.util.UserProfile;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Path("user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserProfileServiceResource {

    @GET
    @Path("/{name}/exists")
    public Response existsUser(final @PathParam("name") String pUsername) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Path("/{name}/get")
    public UserProfile getUser(final @PathParam("name") String pUsername) {
        return new UserProfile();
    }
}
