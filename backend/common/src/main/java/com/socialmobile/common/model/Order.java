package com.socialmobile.common.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class Order {
    @JsonProperty("orderId")
    private int mOrderId = -1;

    @JsonProperty("orderNumber")
    private String mOrderNumber;

    @JsonProperty("orderStatus")
    private String mOrderStatus;

    @JsonProperty("orderPlacer")
    private String mOrderPlacer;

    @JsonProperty("billingAddress")
    private Address mBillingAddress;

    @JsonProperty("shippingAddress")
    private Address mShippingAddress;

    @JsonProperty("products")
    private List<ProductOrder> mListedProducts;

    public int getOrderId() {
        return mOrderId;
    }

    public String getOrderNumber() {
        return mOrderNumber;
    }

    public String getOrderStatus() {
        return mOrderStatus;
    }

    public void setOrderStatus(final String pOrderStatus) {
        mOrderStatus = pOrderStatus;
    }

    public String getOrderPlacer() {
        return mOrderPlacer;
    }

    public void setOrderPlacer(final String pOrderPlacer) {
        mOrderPlacer = pOrderPlacer;
    }

    public Address getBillingAddress() {
        return mBillingAddress;
    }

    public void setBillingAddress(final Address pBillingAddress) {
        mBillingAddress = pBillingAddress;
    }

    public Address getShippingAddress() {
        return mShippingAddress;
    }

    public void setShippingAddress(final Address pShippingAddress) {
        mShippingAddress = pShippingAddress;
    }

    public List<ProductOrder> getListedProducts() {
        return mListedProducts;
    }

    public void setListedProducts(final List<ProductOrder> pListedProducts) {
        mListedProducts = pListedProducts;
    }
}
