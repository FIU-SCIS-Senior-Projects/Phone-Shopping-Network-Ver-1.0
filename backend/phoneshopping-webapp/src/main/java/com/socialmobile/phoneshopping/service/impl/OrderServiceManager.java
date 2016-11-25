package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.Order;
import com.socialmobile.phoneshopping.service.api.OrderService;
import com.socialmobile.phoneshopping.service.dao.GenericDAO;
import com.socialmobile.phoneshopping.service.dao.OrderServiceDAO;
import com.socialmobile.phoneshopping.service.domain.AddressEntity;
import com.socialmobile.phoneshopping.service.domain.OrderEntity;
import com.socialmobile.phoneshopping.service.domain.ProductOrderEntity;
import com.socialmobile.phoneshopping.service.domain.converter.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

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

    @Autowired
    private JSONConverter jsonConverter;

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

    public JSONConverter getJsonConverter() {
        return jsonConverter;
    }

    public void setJsonConverter(final JSONConverter pJsonConverter) {
        jsonConverter = pJsonConverter;
    }

    @Override
    public boolean exists(final Integer pIdToCheck) {
        return mOrderServiceDAO.exists(pIdToCheck);
    }

    @Override
    public Order get(final Integer pIdToGet) {
        OrderEntity orderEntity = mOrderServiceDAO.get(pIdToGet);
        Order order = jsonConverter.fromEntity(orderEntity);
        return order;
    }

    @Override
    public Order create(final Order pObjectToCreate) {
        OrderEntity orderEntity = jsonConverter.toEntity(pObjectToCreate, OrderEntity.class);
        orderEntity.setOrderStatus("placed");
        orderEntity.setOrderNumber(UUID.randomUUID().toString());

        int validBillingAddressId = validateAddress(orderEntity.getBillingAddress());
        int validShippingAddressId = validateAddress(orderEntity.getShippingAddress());
        orderEntity.setBillingAddressId(validBillingAddressId);
        orderEntity.setShippingAddressId(validShippingAddressId);

        OrderEntity newOrder = mOrderServiceDAO.create(orderEntity);
        saveOrderedProducts(newOrder);

        return jsonConverter.fromEntity(newOrder);
    }

    private void saveOrderedProducts(final OrderEntity pOrderEntity) {
        for (ProductOrderEntity productOrderEntity : pOrderEntity.getListedProducts()) {
            productOrderEntity.setOrderId(pOrderEntity.getOrderId());
            mGenericDAO.save(productOrderEntity);
        }
    }

    private int validateAddress(final AddressEntity pGivenAddress) {
        if (pGivenAddress.getAddressId() == -1) {
            return (int) mGenericDAO.save(pGivenAddress);
        }

        return pGivenAddress.getAddressId();
    }

    @Override
    public Order update(final Integer pTargetObjectId, final Order pUpdateWith) {
        OrderEntity oldOrder = mOrderServiceDAO.get(pTargetObjectId);
        if (oldOrder == null) {
            throw new IllegalArgumentException(String.format("Order with Id %d does not exist", pTargetObjectId));
        }

        updateOrder(oldOrder, pUpdateWith);
        mOrderServiceDAO.update(pTargetObjectId, oldOrder);
        return null;
    }

    private void updateOrder(final OrderEntity pOldOrder, final Order pUpdateWith) {
        pOldOrder.setOrderStatus(pUpdateWith.getOrderStatus());
    }

    @Override
    public boolean delete(final Integer pIdToDelete) {
//        TODO:: To be implemented
        return false;
    }

    @Override
    public List<Order> getOrders(final int pIndex, final int pCount) {
        List<OrderEntity> orderEntities = mGenericDAO.listAll(OrderEntity.class, pIndex, pCount);

        ArrayList<Order> list = new ArrayList<>(orderEntities.size());
        for (OrderEntity orderEntity : orderEntities) {
            list.add(jsonConverter.fromEntity(orderEntity));
        }

        return list;
    }
}
