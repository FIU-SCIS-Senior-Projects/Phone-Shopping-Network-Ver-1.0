package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.common.model.UserProfile;

import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class DummyuserProfileDAO implements UserProfileDAO {
    private UserProfile user = new UserProfile() {{
       setFirstName("First");
        setLastName("Last");
        setEmail("first.last@example.com");
        setPhone("+18889990000");
        setUsername("first.last");
    }};

    @Override
    public boolean exists(final String pIdToCheck) {
        return user.getUsername().equals(pIdToCheck);
    }

    @Override
    public UserProfile get(final String pIdToGet) {
        if (user.getUsername().equals(pIdToGet)) {
            return user;
        }

        return null;
    }

    @Override
    public UserProfile create(final Optional<UserProfile> pObjectToCreate) {
        if (user.getUsername().length() == 0) {
            user = pObjectToCreate.get();
        }

        return user;
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final Optional<UserProfile> pUpdateWith) {
        if (user.getUsername().equals(pTargetObjectId)) {
            UserProfile with = pUpdateWith.get();
            user.setFirstName(with.getFirstName());
            user.setLastName(with.getLastName());
            user.setPhone(with.getPhone());
            user.setEmail(with.getEmail());

            return user;
        }

        return null;
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        if (user.getUsername().equals(pIdToDelete)) {
            user.setUsername("");
            return true;
        }

        return false;
    }
}
