package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.domain.ProductEntity;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

public abstract class ProductDAO extends BaseDAO<ProductEntity, Integer> {
    @Override
    protected Class<ProductEntity> getEntity() {
        return ProductEntity.class;
    }
}
