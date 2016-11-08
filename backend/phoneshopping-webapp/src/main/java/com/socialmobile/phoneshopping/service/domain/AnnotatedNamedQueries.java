package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Entity
@NamedNativeQueries({
    @NamedNativeQuery(name = "findRolesByName", query = "select * from Roles r where r.roleName = :rolename", resultClass = Roles.class)
})
public class AnnotatedNamedQueries implements Serializable {
    @Id
    private int mID;
}
