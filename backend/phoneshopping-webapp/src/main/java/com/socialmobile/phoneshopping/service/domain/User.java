package com.socialmobile.phoneshopping.service.domain;

import javax.persistence.Entity;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

public class User {
    private String mUsername;

    private String mFirstName;

    private String mLastName;

    private String mEmail;

    private String mPhone;

    public String getUsername() {
        return mUsername;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public String getPhone() {
        return mPhone;
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
}
