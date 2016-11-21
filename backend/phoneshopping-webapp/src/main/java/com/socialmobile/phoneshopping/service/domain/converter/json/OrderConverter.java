package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.Address;
import com.socialmobile.common.model.Order;
import com.socialmobile.common.model.ProductOrder;
import com.socialmobile.phoneshopping.service.dao.GenericDAO;
import com.socialmobile.phoneshopping.service.dao.UserProfileDAO;
import com.socialmobile.phoneshopping.service.domain.AddressEntity;
import com.socialmobile.phoneshopping.service.domain.OrderEntity;
import com.socialmobile.phoneshopping.service.domain.ProductOrderEntity;
import com.socialmobile.phoneshopping.service.domain.User;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;
import com.socialmobile.phoneshopping.service.domain.converter.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class OrderConverter implements Converter<Order, OrderEntity> {
    @Autowired
    private JSONConverter jsonConverter;

    @Autowired
    private UserProfileDAO mUserProfileDAO;

    @Autowired
    private GenericDAO mGenericDAO;

    public JSONConverter getJsonConverter() {
        return jsonConverter;
    }

    public void setJsonConverter(final JSONConverter pJsonConverter) {
        jsonConverter = pJsonConverter;
    }

    public UserProfileDAO getUserProfileDAO() {
        return mUserProfileDAO;
    }

    public void setUserProfileDAO(final UserProfileDAO pUserProfileDAO) {
        mUserProfileDAO = pUserProfileDAO;
    }

    public GenericDAO getGenericDAO() {
        return mGenericDAO;
    }

    public void setGenericDAO(final GenericDAO pGenericDAO) {
        mGenericDAO = pGenericDAO;
    }

    @Override
    public Order fromEntity(final OrderEntity pEntity) {
        Order order = new Order();
        order.setOrderId(pEntity.getOrderId());
        order.setOrderNumber(pEntity.getOrderNumber());
        order.setOrderStatus(pEntity.getOrderStatus());
        order.setUserName(pEntity.getOrderPlacer().getUsername());
        order.setBillingAddress(jsonConverter.fromEntity(pEntity.getBillingAddress()));
        order.setShippingAddress(jsonConverter.fromEntity(pEntity.getShippingAddress()));
        order.setListedProducts(createProductListingFromEntity(pEntity.getListedProducts()));
        return order;
    }

    private List<ProductOrder> createProductListingFromEntity(final List<ProductOrderEntity> pListedProducts) {
        if (pListedProducts == null || pListedProducts.isEmpty()) {
            return Collections.EMPTY_LIST;
        }

        List<ProductOrder> list = new ArrayList<>(pListedProducts.size());
        for (ProductOrderEntity productOrderEntity : pListedProducts) {
            list.add(jsonConverter.fromEntity(productOrderEntity));
        }
        return list;
    }

    @Override
    public OrderEntity toEntity(final Order pModel) {
        OrderEntity entity = new OrderEntity();
        entity.setOrderId(pModel.getOrderId());
        entity.setOrderNumber(pModel.getOrderNumber());
        entity.setOrderStatus(pModel.getOrderStatus());
        entity.setOrderPlacer(getUser(pModel.getUserName()));
        entity.setBillingAddress(getAddressEntity(pModel.getBillingAddress()));
        entity.setShippingAddress(getAddressEntity(pModel.getShippingAddress()));
        entity.setListedProducts(getListedProductEntities(pModel.getOrderId(), pModel.getListedProducts()));
        return entity;
    }

    private List<ProductOrderEntity> getListedProductEntities(final int pOrderId, final List<ProductOrder> pListedProducts) {
        List<Integer> productIds = pListedProducts.stream().map(po -> po.getProductId()).collect(Collectors.toList());
        HashMap valuesMap = new HashMap();
        valuesMap.put("productIds", productIds);
        valuesMap.put("orderId", pOrderId);
        List<ProductOrderEntity> productOrderList = mGenericDAO.listByNamedNativeQuery("orderedProductsListByIds", valuesMap);
        if (productOrderList == null || productOrderList.isEmpty() || productOrderList.size() != productIds.size()) {
            return createProductOrderEntities(pOrderId, pListedProducts);
        }

        return productOrderList;
    }

    private List<ProductOrderEntity> createProductOrderEntities(final int pOrderId, final List<ProductOrder> pListedProducts) {
        ArrayList<ProductOrderEntity> list = new ArrayList<>(pListedProducts.size());
        for (ProductOrder productOrder : pListedProducts) {
            list.add(jsonConverter.toEntity(productOrder, ProductOrderEntity.class));
        }

        return list;
    }

    private AddressEntity getAddressEntity(final Address pAddress) {
        HashMap<String, String> valuesMap = new HashMap<>();
        valuesMap.put("address", pAddress.getAddressLineOne());
        valuesMap.put("zipCode", pAddress.getZipCode());
        List<AddressEntity> addressEntityList = mGenericDAO.listByNamedNativeQuery("findAddressByUniqueKey", valuesMap);
        if (addressEntityList == null || addressEntityList.isEmpty()) {
            return jsonConverter.toEntity(pAddress, AddressEntity.class);
        }

        return addressEntityList.get(0);
    }

    private User getUser(final String pUserName) {
        return mUserProfileDAO.get(pUserName);
    }
}
