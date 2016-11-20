package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;

/**
 * Created by dalam004 on 11/18/2016.
 */
@Entity
@Table(name = "ProductOrder")
public class ProductOrderEntity {
    @Id
    @Column(name = "orderId")
    private int mOrderId; //orderId INT NOT NULL,

    @Column(name = "productId")
    private int mProductId; //productId INT NOT NULL,

    @Column(name = "unitPrice")
    private float mUnitPrice; //unitPrice FLOAT NULL,

    @Column(name = "count")
    private int mCount; //count INT NULL

    @Transient
    private OrderEntity mOrder;

    @ManyToOne
    @JoinColumn(name = "orderId")
    @LazyToOne(value = LazyToOneOption.PROXY)
    public OrderEntity getOrder() {
        return mOrder;
    }

    public void setOrder(final OrderEntity pOrder) {
        mOrder = pOrder;
    }

    @Transient
    private ProductEntity mProduct;

    @OneToOne
    @JoinColumn(name = "productId")
    @LazyToOne(value = LazyToOneOption.PROXY)
    public ProductEntity getProduct() {
        return mProduct;
    }

    public void setProduct(final ProductEntity pProduct) {
        mProduct = pProduct;
        mProductId = pProduct.getProductId();
    }

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
