package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.Order;
import com.socialmobile.phoneshopping.service.api.OrderService;
import com.socialmobile.phoneshopping.service.dao.GenericDAO;
import com.socialmobile.phoneshopping.service.dao.OrderServiceDAO;
import com.socialmobile.phoneshopping.service.domain.OrderEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Field;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Service
@Transactional
public class OrderServiceManager implements OrderService {

    @Autowired
    private GenericDAO mGenericDAO;

    @Autowired
    private OrderServiceDAO mOrderServiceDAO;

    public GenericDAO getGenericDAO() {
        return mGenericDAO;
    }

    public void setGenericDAO(final GenericDAO pGenericDAO) {
        mGenericDAO = pGenericDAO;
    }

    public OrderServiceDAO getOrderServiceDAO() {
        return mOrderServiceDAO;
    }

    public void setOrderServiceDAO(final OrderServiceDAO pOrderServiceDAO) {
        mOrderServiceDAO = pOrderServiceDAO;
    }

    @Override
    public boolean exists(final Integer pIdToCheck) {
        return mOrderServiceDAO.exists(pIdToCheck);
    }

    @Override
    public Order get(final Integer pIdToGet) {
        OrderEntity orderEntity = mOrderServiceDAO.get(pIdToGet);
        Order order = modelFromEntity(orderEntity);
    }

    @Override
    public Order create(final Order pObjectToCreate) {
        return null;
    }

    @Override
    public Order update(final Integer pTargetObjectId, final Order pUpdateWith) {
        return null;
    }

    @Override
    public boolean delete(final Integer pIdToDelete) {
        return false;
    }
}
