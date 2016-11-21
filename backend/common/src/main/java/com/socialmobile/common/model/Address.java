package com.socialmobile.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Address {
    @JsonProperty("addressId")
    private int mAddressId = -1;

    @JsonProperty("addressLineOne")
    private String mAddressLineOne;

    @JsonProperty("addressLineTwo")
    private String mAddressLineTwo;

    @JsonProperty("city")
    private String mCity;

    @JsonProperty("state")
    private String mState;

    @JsonProperty("zipCode")
    private String mZipCode;

    public int getAddressId() {
        return mAddressId;
    }

    public void setAddressId(final int pAddressId) {
        mAddressId = pAddressId;
    }

    public String getAddressLineOne() {
        return mAddressLineOne;
    }

    public void setAddressLineOne(final String pAddressLineOne) {
        mAddressLineOne = pAddressLineOne;
    }

    public String getAddressLineTwo() {
        return mAddressLineTwo;
    }

    public void setAddressLineTwo(final String pAddressLineTwo) {
        mAddressLineTwo = pAddressLineTwo;
    }

    public String getCity() {
        return mCity;
    }

    public void setCity(final String pCity) {
        mCity = pCity;
    }

    public String getState() {
        return mState;
    }

    public void setState(final String pState) {
        mState = pState;
    }

    public String getZipCode() {
        return mZipCode;
    }

    public void setZipCode(final String pZipCode) {
        mZipCode = pZipCode;
    }
}
