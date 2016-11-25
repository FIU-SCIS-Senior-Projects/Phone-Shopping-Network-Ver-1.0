package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.api.UserProfileService;
import com.socialmobile.phoneshopping.service.dao.GenericDAO;
import com.socialmobile.phoneshopping.service.dao.UserProfileDAO;
import com.socialmobile.phoneshopping.service.domain.User;
import com.socialmobile.phoneshopping.service.domain.converter.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Transactional
public class UserProfileManager implements UserProfileService {

    @Autowired
    private GenericDAO mGenericDAO;

    @Autowired
    private UserProfileDAO userProfileDAO;

    @Autowired
    private JSONConverter jsonConverter;


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
            return jsonConverter.fromEntity(user);
        }

        return null;
    }

    @Override
    public UserProfile create(final UserProfile pObjectToCreate) {
        User user = jsonConverter.toEntity(pObjectToCreate, User.class);
        user = userProfileDAO.create(user);
        return jsonConverter.fromEntity(user);
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
            return jsonConverter.fromEntity(updatedUser);
        }

        return null;
    }

    @Override
    public boolean delete(final String pIdToDelete) {
        return userProfileDAO.delete(pIdToDelete);
    }

    @Override
    public List<UserProfile> getUsers(final int pStart, final int pCount) {
        List<User> userList = mGenericDAO.listAll(User.class, pStart, pCount);
        return userList.stream().map(user -> (UserProfile)jsonConverter.fromEntity(user)).collect(Collectors.toList());
    }
}
