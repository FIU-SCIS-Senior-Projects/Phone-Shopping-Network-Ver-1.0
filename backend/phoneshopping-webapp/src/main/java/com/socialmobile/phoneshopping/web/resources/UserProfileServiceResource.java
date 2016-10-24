package com.socialmobile.phoneshopping.web.resources;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.web.service.UserProfileService;

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

    private UserProfileService mUserProfileService;

    public UserProfileService getUserProfileService() {
        return mUserProfileService;
    }

    public void setUserProfileService(final UserProfileService pUserProfileService) {
        mUserProfileService = pUserProfileService;
    }

    @HEAD
    @Path("/{name}")
    public Response existsUser(final @PathParam("name") String pUsername) {
        boolean exists = mUserProfileService.exists(pUsername);
        Response.Status status = exists ? Response.Status.OK : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response getUser(final @PathParam("name") String pUsername) {
        UserProfile userProfile = mUserProfileService.get(pUsername);
        return Response.status(Response.Status.OK)
                .entity(userProfile)
                .build();
    }

    @DELETE
    @Path("/{name}")
    public Response deleteUser(final @PathParam("name") String pUsername) {
        boolean deleted = mUserProfileService.delete(pUsername);
        Response.Status status = deleted ? Response.Status.OK : Response.Status.NOT_FOUND;
        return Response.status(status).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createUser(final UserProfile pUserProfile) {
        Optional<UserProfile> profile = Optional.of(pUserProfile);
        UserProfile userProfile = mUserProfileService.create(profile);
        return Response.status(Response.Status.CREATED)
                .build();

    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{name}")
    public Response updateUser(final @PathParam("name") String pUsername, final UserProfile pUserProfile) {
        Optional<UserProfile> profile = Optional.of(pUserProfile);
        UserProfile userProfile = mUserProfileService.update(pUsername, profile);
        return Response.status(Response.Status.OK)
                .entity(userProfile)
                .build();

    }

}
