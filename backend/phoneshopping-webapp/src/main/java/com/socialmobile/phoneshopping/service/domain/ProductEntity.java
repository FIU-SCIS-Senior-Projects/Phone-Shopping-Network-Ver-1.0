package com.socialmobile.phoneshopping.service.domain;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.socialmobile.common.json.JSONObjectFactory;

import javax.persistence.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Entity
@Table(name = "Product")
public class ProductEntity {

    @Id
    @Column(name = "productId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mProductId;

    @Column(name = "title")
    private String mTitle;

    @Column(name = "description")
    private String mDescription;

    @Transient
    private Map<String, String> mAdditionalInfo;

    @Column(name = "info")
    @Access(AccessType.PROPERTY)
    public String getAdditionalInfo() {
        String info = "";
        try {
            info = JSONObjectFactory.getsInstance().objectToString(mAdditionalInfo);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return info;
    }

    public void setAdditionalInfo(final String pInfoFromJSON) {
        try {
            mAdditionalInfo = JSONObjectFactory.getsInstance().stringToObject(pInfoFromJSON, new HashMap<String, String>().getClass());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setAdditionalInfo(final Map<String, String> pInfo) {
        mAdditionalInfo = pInfo;
    }

    public Map<String, String> getAdditionalInfoAsMap() {
        return mAdditionalInfo;
    }

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(int pProductId) {
        mProductId = pProductId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String pTitle) {
        mTitle = pTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String pDescription) {
        mDescription = pDescription;
    }
}
