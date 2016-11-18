package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.domain.AddressEntity;
import com.socialmobile.phoneshopping.service.domain.Roles;
import com.socialmobile.phoneshopping.service.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

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

    abstract public List<Roles> getUserRoleByName(final String pName);

    abstract public void updateRoles(final List<Roles> pUpdatedRoles);
    abstract public void addRoles(final List<Roles> pNewRoles);

    abstract public void setHomeAddress(final AddressEntity pHomeAddress);
    abstract public void setWorkAddress(final AddressEntity pWorkAddress);
    abstract public void updateHomeAddress(final AddressEntity pHomeAddress);
    abstract public void updateWorkAddress(final AddressEntity pWorkAddress);
}
