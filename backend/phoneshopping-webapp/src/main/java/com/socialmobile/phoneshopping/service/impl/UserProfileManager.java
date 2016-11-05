package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.UserProfileService;
import com.socialmobile.phoneshopping.service.dao.UserProfileDAO;
import com.socialmobile.phoneshopping.service.domain.User;

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
        User user = mUserProfileDAO.get(pIdToGet);
        if (user != null) {
            return userProfileFromUser(user);
        }

        return null;
    }

    @Override
    public UserProfile create(final UserProfile pObjectToCreate) {
        User user = userFromUserProfile(pObjectToCreate);
        user = mUserProfileDAO.create(user);
        return userProfileFromUser(user);
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final UserProfile pUpdateWith) {
        User user = userFromUserProfile(pUpdateWith);
        User updatedUser = mUserProfileDAO.update(pTargetObjectId, user);
        if (updatedUser != null) {
            return userProfileFromUser(updatedUser);
        }

        return null;
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        return mUserProfileDAO.delete(pIdToDelete);
    }

    private UserProfile userProfileFromUser(final User pFrom) {
        UserProfile userProfile =  new UserProfile();
        userProfile.setUsername(pFrom.getUsername());
        userProfile.setFirstName(pFrom.getFirstName());
        userProfile.setLastName(pFrom.getLastName());
        userProfile.setEmail(pFrom.getEmail());
        userProfile.setPhone(pFrom.getPhone());

        return userProfile;
    }

    private User userFromUserProfile(final UserProfile pUser) {
        User user =  new User();
        user.setUsername(pUser.getUsername());
        user.setFirstName(pUser.getFirstName());
        user.setLastName(pUser.getLastName());
        user.setEmail(pUser.getEmail());
        user.setPhone(pUser.getPhone());

        return user;
    }


}
