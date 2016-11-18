package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.hibernate.sql.Select;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

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
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String mOrderId;

    @Column(name = "orderStatus")
    private String mOrderStatus;

    private User mUser;

    @OneToOne
    @JoinTable(
        name = "OrderPlacement",
        foreignKey = @ForeignKey(name = "fk_placed_order"),
        inverseForeignKey = @ForeignKey(name = "fk_user_placed_order")
    )
    @LazyToOne(LazyToOneOption.PROXY)
    public User getOwner() {
        return mUser;
    }

    public List<ProductEntity> getProducts()

    public String getOrderStatus() {
        return mOrderStatus;
    }


    public void setOrderStatus(final String pOrderStatus) {
        mOrderStatus = pOrderStatus;
    }
}
