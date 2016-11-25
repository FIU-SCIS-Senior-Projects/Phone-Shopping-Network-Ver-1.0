package com.socialmobile.phoneshopping.service.api;

import com.socialmobile.common.model.Order;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface OrderService extends ServiceBase<Order, Integer> {
    List<Order> getOrders(final int pIndex, final int pCount);
}
