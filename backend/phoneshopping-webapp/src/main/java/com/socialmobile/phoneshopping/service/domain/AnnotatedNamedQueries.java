package com.socialmobile.phoneshopping.service.domain;

import org.hibernate.annotations.NamedNativeQueries;
import org.hibernate.annotations.NamedNativeQuery;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Entity
@NamedNativeQueries({
    @NamedNativeQuery(
        name = "findRolesByName",
        query = "select * from Roles r where r.roleName = :rolename",
        resultClass = Roles.class
    ),
    @NamedNativeQuery(
        name = "findAddressByUniqueKey",
        query = "select * from Address a where a.addressLineOne = :address and a.zipCode = :zipcode",
        resultClass = AddressEntity.class
    ),
    @NamedNativeQuery(
        name = "orderedProductsListByIds",
        query = "select * from ProductOrder po where po.productId in (:productIds) and po.orderId = :orderId",
        resultClass = ProductOrderEntity.class
    )
})
public class AnnotatedNamedQueries implements Serializable {
    @Id
    private int mID;
}
