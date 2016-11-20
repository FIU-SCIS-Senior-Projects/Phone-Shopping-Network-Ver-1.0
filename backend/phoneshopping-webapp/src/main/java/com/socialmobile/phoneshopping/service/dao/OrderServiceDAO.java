package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.domain.OrderEntity;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public abstract class OrderServiceDAO extends BaseDAO<OrderEntity, Integer> {

    @Override
    protected Class<OrderEntity> getEntity() {
        return OrderEntity.class;
    }
}
