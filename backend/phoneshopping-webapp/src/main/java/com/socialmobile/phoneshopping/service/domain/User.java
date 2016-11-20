package com.socialmobile.phoneshopping.service.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Entity
@Table(name = "User")
public class User implements Serializable {
    private String mUsername;

    private String mFirstName;

    private String mLastName;

    private String mEmail;

    private String mPhone;

    List<Roles> mRolesList;

    @Id
    @Basic
    @Column(name = "userName", updatable = false, nullable = false, length = 30)
    public String getUsername() {
        return mUsername;
    }

    @Basic
    @Column(name = "firstName", length = 45)
    public String getFirstName() {
        return mFirstName;
    }

    @Basic
    @Column(name = "lastName", length = 45)
    public String getLastName() {
        return mLastName;
    }

    @Basic
    @Column(name = "email", length = 45)
    public String getEmail() {
        return mEmail;
    }

    @Basic
    @Column(name = "phone", length = 15)
    public String getPhone() {
        return mPhone;
    }


    @OneToMany
    @JoinTable(
        name = "UserRoles",
        joinColumns = @JoinColumn(name = "userName"),
        inverseJoinColumns = @JoinColumn(name = "roleId")
    )
    public List<Roles> getRolesList() {
        return mRolesList;
    }

    public void setUsername(final String pUsername) {
        mUsername = pUsername;
    }

    public void setFirstName(final String pFirstName) {
        mFirstName = pFirstName;
    }

    public void setLastName(final String pLastName) {
        mLastName = pLastName;
    }

    public void setEmail(final String pEmail) {
        mEmail = pEmail;
    }

    public void setPhone(final String pPhone) {
        mPhone = pPhone;
    }

    @Override
    public int hashCode() {
        return mUsername.hashCode()*31 + 17;
    }

    @Override
    public boolean equals(final Object obj) {
        if (obj == null || !(obj instanceof User)) {
            return false;
        }

        User user = (User) obj;
        return mUsername != null && mUsername.equals(user.mUsername);
    }

    public void setRolesList(final List<Roles> pRoles) {
        mRolesList = pRoles;
    }
}
