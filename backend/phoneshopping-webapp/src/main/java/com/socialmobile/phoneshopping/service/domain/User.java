package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.annotations.Where;

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

    private AddressEntity mHomeAddress;
    private AddressEntity mWorkAddress;

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
        joinColumns = @JoinColumn(name = "userName", updatable = false),
        inverseJoinColumns = @JoinColumn(name = "roleId", updatable = false)
    )
    public List<Roles> getRolesList() {
        return mRolesList;
    }

    @OneToOne
    @JoinTable(
        name = "UserAddress",
        joinColumns = @JoinColumn(name = "userName", updatable = false),
        inverseJoinColumns = @JoinColumn(name = "addressId", updatable = false)
    )
    @Where(clause = "typeName = 'home'")
    @LazyToOne(value = LazyToOneOption.PROXY)
    public AddressEntity getHomeAddress() {
        return mHomeAddress;
    }

    @OneToOne
    @JoinTable(
        name = "UserAddress",
        joinColumns = @JoinColumn(name = "userName", updatable = false),
        inverseJoinColumns = @JoinColumn(name = "addressId", updatable = false)
    )
    @Where(clause = "typeName = 'work'")
    @LazyToOne(value = LazyToOneOption.PROXY)
    public AddressEntity getWorkAddress() {
        return mWorkAddress;
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

    public void setHomeAddress(final AddressEntity pHomeAddress) {
        mHomeAddress = pHomeAddress;
    }

    public void setWorkAddress(final AddressEntity pWorkAddress) {
        mWorkAddress = pWorkAddress;
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
