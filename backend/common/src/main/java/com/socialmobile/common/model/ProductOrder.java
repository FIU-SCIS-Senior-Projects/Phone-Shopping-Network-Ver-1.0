package com.socialmobile.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class ProductOrder {

    @JsonProperty("orderId")
    private int mOrderId = -1;

    @JsonProperty("productId")
    private int mProductId = -1;

    @JsonProperty("unitPrice")
    private float mUnitPrice;

    @JsonProperty("count")
    private int mCount;

    public int getOrderId() {
        return mOrderId;
    }

    public void setOrderId(final int pOrderId) {
        mOrderId = pOrderId;
    }

    public int getProductId() {
        return mProductId;
    }

    public void setProductId(final int pProductId) {
        mProductId = pProductId;
    }

    public float getUnitPrice() {
        return mUnitPrice;
    }

    public void setUnitPrice(final float pUnitPrice) {
        mUnitPrice = pUnitPrice;
    }

    public int getCount() {
        return mCount;
    }

    public void setCount(final int pCount) {
        mCount = pCount;
    }
}
