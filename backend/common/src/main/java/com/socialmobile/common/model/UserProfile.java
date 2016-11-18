package com.socialmobile.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class UserProfile {
    @JsonProperty("username")
    private String mUsername;

    @JsonProperty("firstname")
    private String mFirstName;

    @JsonProperty("lastname")
    private String mLastName;

    @JsonProperty("email")
    private String mEmail;

    @JsonProperty("phone")
    private String mPhone;

    @JsonProperty("homeAddress")
    private Address mHomeAddress;

    @JsonProperty("workAddress")
    private Address mWorkAddress;

    public String getUsername() {
        return mUsername;
    }

    public void setUsername(final String pUsername) {
        mUsername = pUsername;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(final String pFirstName) {
        mFirstName = pFirstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(final String pLastName) {
        mLastName = pLastName;
    }

    public String getEmail() {
        return mEmail;
    }

    public void setEmail(final String pEmail) {
        mEmail = pEmail;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(final String pPhone) {
        mPhone = pPhone;
    }

    public Address getHomeAddress() {
        return mHomeAddress;
    }

    public void setHomeAddress(final Address pHomeAddress) {
        mHomeAddress = pHomeAddress;
    }

    public Address getWorkAddress() {
        return mWorkAddress;
    }

    public void setWorkAddress(final Address pWorkAddress) {
        mWorkAddress = pWorkAddress;
    }
}
