package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import javax.persistence.*;
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
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @GeneratedValue(generator = "system-uuid")
    private String mOrderNumber; //orderNumber VARCHAR(50) NOT NULL,

    @Column(name = "orderStatus")
    private String mOrderStatus;

    @Column(name = "billingAddress")
    private int mBillingAddressId = -1;

    @Column(name = "shippingAddress")
    private int mShippingAddressId = -1;

    @OneToOne
    @JoinTable(
        name = "OrderPlacement",
        joinColumns = @JoinColumn(name = "orderId"),
        inverseJoinColumns = @JoinColumn(name = "userName")
    )
    @LazyToOne(LazyToOneOption.PROXY)
    private User mOrderPlacer;

    @OneToOne
    @JoinColumn(name = "billingAddress", referencedColumnName = "addressId", updatable = false, insertable = false)
    @LazyToOne(value = LazyToOneOption.PROXY)
    private AddressEntity mBillingAddress;

    @OneToOne
    @JoinColumn(name = "shippingAddress", referencedColumnName = "addressId", updatable = false, insertable = false)
    @LazyToOne(value = LazyToOneOption.PROXY)
    private AddressEntity mShippingAddress;

    @OneToMany
    @JoinColumn(name = "orderId", insertable = false, updatable = false)
    private List<ProductOrderEntity> mListedProducts;

    public User getOrderPlacer() {
        return mOrderPlacer;
    }
    public void setOrderPlacer(final User pOrderPlacer) {
        mOrderPlacer = pOrderPlacer;
    }

    public AddressEntity getBillingAddress() {
        return mBillingAddress;
    }

    public AddressEntity getShippingAddress() {
        return mShippingAddress;
    }

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

    public void setBillingAddressId(final int pBillingAddressId) {
        mBillingAddressId = pBillingAddressId;
    }

    public void setShippingAddressId(final int pShippingAddressId) {
        mShippingAddressId = pShippingAddressId;
    }

    public void setBillingAddress(final AddressEntity pBillingAddress) {
        mBillingAddress = pBillingAddress;
        mBillingAddressId = pBillingAddress.getAddressId();
    }

    public void setShippingAddress(final AddressEntity pShippingAddress) {
        mShippingAddress = pShippingAddress;
        mShippingAddressId = pShippingAddress.getAddressId();
    }

    public int getBillingAddressId() {
        return mBillingAddressId;
    }

    public int getShippingAddressId() {
        return mShippingAddressId;
    }
}
