package com.socialmobile.phoneshopping.service.api;

import com.socialmobile.common.model.UserProfile;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface UserProfileService extends ServiceBase<UserProfile, String> {
    List<UserProfile> getUsers(final int pStart, final int pCount);
}
