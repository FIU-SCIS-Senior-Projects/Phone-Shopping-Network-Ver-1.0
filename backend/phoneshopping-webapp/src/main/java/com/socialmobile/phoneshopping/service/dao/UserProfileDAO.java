package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.domain.Roles;
import com.socialmobile.phoneshopping.service.domain.User;
import com.socialmobile.phoneshopping.service.domain.UserRoles;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Service
public abstract class UserProfileDAO extends GenericDAO<User, String> {

    @Override
    protected Class<User> getEntity() {
        return User.class;
    }

    abstract public List<Roles> getUserRoleByName(final String pName);
}
