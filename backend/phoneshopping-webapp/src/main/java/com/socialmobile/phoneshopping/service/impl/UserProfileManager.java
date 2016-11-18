package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.UserProfileService;
import com.socialmobile.phoneshopping.service.dao.UserProfileDAO;
import com.socialmobile.phoneshopping.service.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Transactional
public class UserProfileManager implements UserProfileService {

    @Autowired
    private UserProfileDAO userProfileDAO;

    public UserProfileDAO getUserProfileDAO() {
        return userProfileDAO;
    }

    public void setUserProfileDAO(final UserProfileDAO pUserProfileDAO) {
        userProfileDAO = pUserProfileDAO;
    }

    @Override
    public boolean exists(final String pIdToCheck) {
        return userProfileDAO.exists(pIdToCheck);
    }

    @Override
    public UserProfile get(final String pIdToGet) {
        User user = userProfileDAO.get(pIdToGet);
        if (user != null) {
            return userProfileFromUser(user);
        }

        return null;
    }

    @Override
    public UserProfile create(final UserProfile pObjectToCreate) {
        User user = userFromUserProfile(pObjectToCreate);
        user = userProfileDAO.create(user);
        return userProfileFromUser(user);
    }

    @Override
    public UserProfile update(final String pTargetObjectId, final UserProfile pUpdateWith) {
        User user = userProfileDAO.get(pTargetObjectId);
        user.setFirstName(pUpdateWith.getFirstName());
        user.setLastName(pUpdateWith.getLastName());
        user.setEmail(pUpdateWith.getEmail());
        user.setPhone(pUpdateWith.getPhone());
        User updatedUser = userProfileDAO.update(pTargetObjectId, user);
        if (updatedUser != null) {
            return userProfileFromUser(updatedUser);
        }

        return null;
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        return userProfileDAO.delete(pIdToDelete);
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
