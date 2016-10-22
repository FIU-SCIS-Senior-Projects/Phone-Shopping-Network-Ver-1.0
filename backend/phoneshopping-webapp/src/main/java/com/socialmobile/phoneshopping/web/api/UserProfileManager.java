package com.socialmobile.phoneshopping.web.api;

import com.socialmobile.phoneshopping.web.service.UserProfileService;
import sun.plugin.util.UserProfile;

import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class UserProfileManager implements UserProfileService {
    @Override
    public boolean exists(final String pIdToCheck) {
        return false;
    }

    @Override
    public UserProfile get(final String pIdToGet) {
        return null;
    }

    @Override
    public UserProfile create(final Optional<UserProfile> pObjectToCreate) {
        return null;
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final Optional<UserProfile> pUpdateWith) {
        return null;
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        return false;
    }
}
