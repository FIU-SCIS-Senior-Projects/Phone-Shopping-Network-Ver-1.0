package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.UserProfile;
import com.socialmobile.phoneshopping.service.domain.User;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class UserConverter implements Converter<UserProfile, User> {

    @Override
    public UserProfile fromEntity(final User pEntity) {
        UserProfile userProfile =  new UserProfile();
        userProfile.setUsername(pEntity.getUsername());
        userProfile.setFirstName(pEntity.getFirstName());
        userProfile.setLastName(pEntity.getLastName());
        userProfile.setEmail(pEntity.getEmail());
        userProfile.setPhone(pEntity.getPhone());

        return userProfile;
    }

    @Override
    public User toEntity(final UserProfile pUserProfile) {
        User user =  new User();
        user.setUsername(pUserProfile.getUsername());
        user.setFirstName(pUserProfile.getFirstName());
        user.setLastName(pUserProfile.getLastName());
        user.setEmail(pUserProfile.getEmail());
        user.setPhone(pUserProfile.getPhone());

        return user;
    }
}
