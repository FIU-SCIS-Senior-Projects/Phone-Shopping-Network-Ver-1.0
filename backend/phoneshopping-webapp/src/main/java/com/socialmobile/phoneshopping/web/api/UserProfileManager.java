package com.socialmobile.phoneshopping.web.api;

import com.socialmobile.phoneshopping.web.dao.UserProfileDAO;
import com.socialmobile.phoneshopping.web.service.UserProfileService;
import sun.plugin.util.UserProfile;

import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class UserProfileManager implements UserProfileService {
    private UserProfileDAO mUserProfileDAO;

    public UserProfileDAO getUserProfileDAO() {
        return mUserProfileDAO;
    }

    public void setUserProfileDAO(final UserProfileDAO pUserProfileDAO) {
        mUserProfileDAO = pUserProfileDAO;
    }

    @Override
    public boolean exists(final String pIdToCheck) {
        return mUserProfileDAO.exists(pIdToCheck);
    }

    @Override
    public UserProfile get(final String pIdToGet) {
        return mUserProfileDAO.get(pIdToGet);
    }

    @Override
    public UserProfile create(final Optional<UserProfile> pObjectToCreate) {
        return mUserProfileDAO.create(pObjectToCreate);
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final Optional<UserProfile> pUpdateWith) {
        return mUserProfileDAO.update(pTargetObjectId, pUpdateWith);
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        return mUserProfileDAO.delete(pIdToDelete);
    }
}
