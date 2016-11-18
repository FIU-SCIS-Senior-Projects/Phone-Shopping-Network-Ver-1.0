package com.socialmobile.phoneshopping.service.domain;

import javax.persistence.*;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Entity
@Table(name = "Address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "addressId")
    private int mAddressId; //INT NOT NULL AUTO_INCREMENT,

    @Column(name = "addressLineOne")
    private String mAddressLineOne; //VARCHAR(45) NOT NULL,

    @Column(name = "addressLineTwo")
    private String mAddressLineTwo; //VARCHAR(30) NULL,

    @Column(name = "city")
    private String mCity; //VARCHAR(15) NULL,

    @Column(name = "state")
    private String mState; //VARCHAR(15) NULL,

    @Column(name = "zipCode")
    private String mZipCode; // VARCHAR(5)

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
