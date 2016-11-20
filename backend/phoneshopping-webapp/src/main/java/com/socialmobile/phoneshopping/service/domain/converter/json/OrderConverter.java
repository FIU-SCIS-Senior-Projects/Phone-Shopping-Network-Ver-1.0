package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.Order;
import com.socialmobile.phoneshopping.service.domain.OrderEntity;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;
import com.socialmobile.phoneshopping.service.domain.converter.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class OrderConverter implements Converter<Order, OrderEntity> {
    @Autowired
    private JSONConverter jsonConverter;

    @Override
    public Order fromEntity(final OrderEntity pEntity) {
        Order order = new Order();
        order.setOrderId(pEntity.getOrderId());
        order.setOrderNumber(pEntity.getOrderNumber());
        order.setOrderStatus(pEntity.getOrderStatus());
        order.setUserName(pEntity.getOrderPlacer().getUsername());
        order.setBillingAddress(jsonConverter.fromEntity(pEntity.getBillingAddress()));
        order.setShippingAddress(jsonConverter.fromEntity(pEntity.getShippingAddress()));

        return order;
    }

    @Override
    public OrderEntity toEntity(final Order pModel) {
        return null;
    }
}
