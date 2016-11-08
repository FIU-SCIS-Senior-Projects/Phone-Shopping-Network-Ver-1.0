package com.socialmobile.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Product {
    @JsonProperty("productId")
    private int mProductId;

    @JsonProperty("title")
    private String mTitle;

    @JsonProperty("description")
    private String mDescription;

    @JsonProperty("info")
    private Map<String, String> mAdditionalInfo;

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(final int pProductId) {
        mProductId = pProductId;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(final String pTitle) {
        mTitle = pTitle;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(final String pDescription) {
        mDescription = pDescription;
    }

    public Map<String, String> getAdditionalInfo() {
        return mAdditionalInfo;
    }

    public void setAdditionalInfo(final Map<String, String> pAdditionalInfo) {
        mAdditionalInfo = pAdditionalInfo;
    }
}
