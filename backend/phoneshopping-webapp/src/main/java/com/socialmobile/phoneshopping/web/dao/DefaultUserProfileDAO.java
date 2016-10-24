package com.socialmobile.phoneshopping.web.dao;

import sun.plugin.util.UserProfile;

import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class DefaultUserProfileDAO implements UserProfileDAO {
    @Override
    public boolean exists(String pIdToCheck) {
        return false;
    }

    @Override
    public UserProfile get(String pIdToGet) {
        return null;
    }

    @Override
    public UserProfile create(Optional<UserProfile> pObjectToCreate) {
        return null;
    }

    @Override
    public UserProfile update(String pTargetObjectId, Optional<UserProfile> pUpdateWith) {
        return null;
    }

    @Override
    public boolean delete(String pIdToDelete) {
        return false;
    }
}
