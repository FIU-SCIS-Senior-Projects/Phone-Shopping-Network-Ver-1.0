package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Table;
import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Entity
@Table(name = "Orders")
public class OrderEntity {

    @Id
    @Column(name = "orderId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mOrderId;

    @Column(name = "orderNumber")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String mOrderNumber; //orderNumber VARCHAR(50) NOT NULL,

    @Column(name = "orderStatus")
    private String mOrderStatus;

    private User mOrderPlacer;
    private AddressEntity mBillingAddress;
    private AddressEntity mShippingAddress;
    private List<ProductOrderEntity> mListedProducts;

    @OneToOne
    @JoinTable(
        name = "OrderPlacement",
        foreignKey = @ForeignKey(name = "fk_placed_order"),
        inverseForeignKey = @ForeignKey(name = "fk_user_placed_order")
    )
    @LazyToOne(LazyToOneOption.PROXY)
    public User getOrderPlacer() {
        return mOrderPlacer;
    }
    public void setOrderPlacer(final User pOrderPlacer) {
        mOrderPlacer = pOrderPlacer;
    }

    @OneToOne
    @JoinTable(
        name = "OrderAddress",
        joinColumns = @JoinColumn(name = "orderId", updatable = false),
        inverseJoinColumns = @JoinColumn(name = "addressId", updatable = false)
    )
    @Where(clause = "typeName = 'billing'")
    @LazyToOne(value = LazyToOneOption.PROXY)
    public AddressEntity getBillingAddress() {
        return mBillingAddress;
    }

    public void setBillingAddress(final AddressEntity pBillingAddress) {
        mBillingAddress = pBillingAddress;
    }

    @JoinTable(
        name = "OrderAddress",
        joinColumns = @JoinColumn(name = "orderId", updatable = false),
        inverseJoinColumns = @JoinColumn(name = "addressId", updatable = false)
    )
    @Where(clause = "typeName = 'shipping'")
    @OneToOne(fetch = FetchType.LAZY)
    public AddressEntity getShippingAddress() {
        return mShippingAddress;
    }

    public void setShippingAddress(final AddressEntity pShippingAddress) {
        mShippingAddress = pShippingAddress;
    }

    @OneToMany
    @JoinColumn(name = "orderId")
    public List<ProductOrderEntity> getListedProducts() {
        return mListedProducts;
    }

    public void setListedProducts(final List<ProductOrderEntity> pListedProducts) {
        mListedProducts = pListedProducts;
    }

    public int getOrderId() {
        return mOrderId;
    }

    public void setOrderId(final int pOrderId) {
        mOrderId = pOrderId;
    }

    public String getOrderNumber() {
        return mOrderNumber;
    }

    public void setOrderNumber(final String pOrderNumber) {
        mOrderNumber = pOrderNumber;
    }

    public String getOrderStatus() {
        return mOrderStatus;
    }


    public void setOrderStatus(final String pOrderStatus) {
        mOrderStatus = pOrderStatus;
    }
}
