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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String mOrderNumber; //orderNumber VARCHAR(50) NOT NULL,

    @Column(name = "orderStatus")
    private String mOrderStatus;

    @Column(name = "billingAddress")
    private int mBillingAddressId;

    @Column(name = "shippingAddress")
    private int mShippingAddressId;

    @Transient
    private User mOrderPlacer;

    @Transient
    private AddressEntity mBillingAddress;

    @Transient
    private AddressEntity mShippingAddress;

    @Transient
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
    @JoinTable(name = "Address", foreignKey = @ForeignKey(name = "fk_order_address_billing"))
    @LazyToOne(value = LazyToOneOption.PROXY)
    public AddressEntity getBillingAddress() {
        return mBillingAddress;
    }

    @OneToOne
    @JoinTable(name = "Address", foreignKey = @ForeignKey(name = "fk_order_address_shipping"))
    @LazyToOne(value = LazyToOneOption.PROXY)
    public AddressEntity getShippingAddress() {
        return mShippingAddress;
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
