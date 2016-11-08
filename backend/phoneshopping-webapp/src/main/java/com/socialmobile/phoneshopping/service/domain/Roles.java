package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Entity
@Table(name = "Roles")
public class Roles implements Serializable {

    @Id
    @Basic
    @Column(name = "roleId")
    private int mRoleId;

    @Basic
    @Column(name = "roleName")
    private String mRoleName;

    @Basic
    @Column(name = "description")
    private String mDescription;


    public int getRoleId() {
        return mRoleId;
    }

    public String getRoleName() {
        return mRoleName;
    }

    public String getDescription() {
        return mDescription;
    }
}
