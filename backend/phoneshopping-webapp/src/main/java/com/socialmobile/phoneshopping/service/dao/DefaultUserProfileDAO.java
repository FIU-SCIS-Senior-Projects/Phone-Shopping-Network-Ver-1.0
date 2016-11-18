package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.common.constants.RoleNames;
import com.socialmobile.phoneshopping.service.domain.AddressEntity;
import com.socialmobile.phoneshopping.service.domain.Roles;
import com.socialmobile.phoneshopping.service.domain.User;
import org.hibernate.query.NativeQuery;
import org.hibernate.type.StringType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Service
@Transactional
public class DefaultUserProfileDAO extends UserProfileDAO {

    @Override
    public User create(final User pObjectToCreate) {
        List<Roles> roles = pObjectToCreate.getRolesList();
        if (roles == null || roles.isEmpty()) {
            roles = getUserRoleByName(RoleNames.USER.getName());
            pObjectToCreate.setRolesList(roles);
        }
        return super.create(pObjectToCreate);
    }

    @Override
    public List<Roles> getUserRoleByName(final String pName) {
        NativeQuery<Roles> userRolesQuery = getSessionFactory().getCurrentSession().getNamedNativeQuery("findRolesByName");
        userRolesQuery.setParameter("rolename", pName, StringType.INSTANCE);
        userRolesQuery.setReadOnly(true);
        List<Roles> list = userRolesQuery.list();
        return list;
    }

    @Override
    public void updateRoles(final List<Roles> pUpdatedRoles) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    @Override
    public void addRoles(final List<Roles> pNewRoles) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    @Override
    public void setHomeAddress(final AddressEntity pHomeAddress) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    @Override
    public void setWorkAddress(final AddressEntity pWorkAddress) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    @Override
    public void updateHomeAddress(final AddressEntity pHomeAddress) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }

    @Override
    public void updateWorkAddress(final AddressEntity pWorkAddress) {
//        TODO: to be implemented
        throw new UnsupportedOperationException("This feature is not supported yet");
    }
}
