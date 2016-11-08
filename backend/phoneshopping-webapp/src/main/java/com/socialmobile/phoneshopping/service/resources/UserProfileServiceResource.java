package com.socialmobile.phoneshopping.service.resources;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;
import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Path("user")
public class UserProfileServiceResource {

    @Autowired
    private UserProfileService userProfileService;

    public UserProfileService getUserProfileService() {
        return userProfileService;
    }

    public void setUserProfileService(final UserProfileService pUserProfileService) {
        userProfileService = pUserProfileService;
    }

    public UserProfileServiceResource() {
        System.out.println("userProfileServiceResource is being initialized ");
    }

    @HEAD
    @Path("/{name}")
    public Response existsUser(final @PathParam("name") String pUsername) {
        boolean exists = userProfileService.exists(pUsername);
        Response.Status status = exists ? Response.Status.OK : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getUser(final @PathParam("name") String pUsername) throws JsonProcessingException {
        UserProfile userProfile = userProfileService.get(pUsername);
        if (userProfile == null) {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(userProfile))
                .build();
    }

    @DELETE
    @Path("/{name}")
    public Response deleteUser(final @PathParam("name") String pUsername) {
        boolean deleted = userProfileService.delete(pUsername);
        Response.Status status = deleted ? Response.Status.OK : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final UserProfile pUserProfile) {
        UserProfile userProfile = userProfileService.create(pUserProfile);
        return Response.status(Response.Status.CREATED)
                .entity(userProfile.getUsername())
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response updateUser(final @PathParam("name") String pUsername, final UserProfile pUserProfile) throws JsonProcessingException {
        UserProfile userProfile = userProfileService.update(pUsername, pUserProfile);
        if (userProfile == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .build();
        }
        return Response.status(Response.Status.OK)
                .entity(JSONObjectFactory.getsInstance().objectToString(userProfile))
                .build();

    }

}
