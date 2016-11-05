package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.api.ServiceBase;
import com.socialmobile.phoneshopping.service.domain.User;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public abstract class UserProfileDAO extends GenericDAO<User, String> {

    @Override
    protected Class<User> getEntity() {
        return User.class;
    }
}
