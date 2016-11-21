package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.ProductOrder;
import com.socialmobile.phoneshopping.service.domain.ProductOrderEntity;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class ProductOrderConverter implements Converter<ProductOrder, ProductOrderEntity> {
    @Override
    public ProductOrder fromEntity(final ProductOrderEntity pEntity) {
        ProductOrder productOrder = new ProductOrder();
        productOrder.setOrderId(pEntity.getOrderId());
        productOrder.setProductId(pEntity.getProductId());
        productOrder.setCount(pEntity.getCount());
        productOrder.setUnitPrice(pEntity.getUnitPrice());

        return productOrder;
    }

    @Override
    public ProductOrderEntity toEntity(final ProductOrder pModel) {
        ProductOrderEntity entity = new ProductOrderEntity();
        entity.setOrderId(pModel.getOrderId());
        entity.setProductId(pModel.getProductId());
        entity.setCount(pModel.getCount());
        entity.setUnitPrice(pModel.getUnitPrice());

        return entity;
    }
}
