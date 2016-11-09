package com.socialmobile.phoneshopping.service.impl;

import com.socialmobile.common.model.Product;
import com.socialmobile.phoneshopping.service.api.ProductService;
import com.socialmobile.phoneshopping.service.api.ServiceBase;
import com.socialmobile.phoneshopping.service.dao.ProductDAO;
import com.socialmobile.phoneshopping.service.domain.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */

@Service
@Transactional
public class ProductManager implements ProductService {
    @Autowired
    private ProductDAO mProductDAO;

    @Override
    public boolean exists(Integer pIdToCheck) {
        return mProductDAO.exists(pIdToCheck);
    }

    @Override
    public Product get(Integer pIdToGet) {
        ProductEntity productEntity = mProductDAO.get(pIdToGet);
        return fromEntity(productEntity);
    }

    private Product fromEntity(final ProductEntity pProductEntity) {
        Product product = new Product();
        product.setProductId(pProductEntity.getProductId());
        product.setTitle(pProductEntity.getTitle());
        product.setDescription(pProductEntity.getDescription());
        product.setAdditionalInfo(pProductEntity.getAdditionalInfoAsMap());
        return product;
    }

    private ProductEntity toEntity(final Product pProduct) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setProductId(pProduct.getProductId());
        productEntity.setTitle(pProduct.getTitle());
        productEntity.setDescription(pProduct.getDescription());
        productEntity.setAdditionalInfo(pProduct.getAdditionalInfo());
        return productEntity;
    }

    @Override
    public Product create(Product pObjectToCreate) {
        ProductEntity productEntity = toEntity(pObjectToCreate);
        ProductEntity created = mProductDAO.create(productEntity);
        return fromEntity(created);
    }

    @Override
    public Product update(Integer pTargetObjectId, Product pUpdateWith) {
        ProductEntity productEntity = mProductDAO.get(pTargetObjectId);
        if (productEntity != null) {
            updateEntity(productEntity, pUpdateWith);
            mProductDAO.update(pTargetObjectId, productEntity);
        }

        return fromEntity(productEntity);
    }

    private void updateEntity(ProductEntity pProductEntity, final Product pUpdateWith) {
        pProductEntity.setTitle(pUpdateWith.getTitle());
        pProductEntity.setDescription(pUpdateWith.getDescription());
        pProductEntity.setAdditionalInfo(pUpdateWith.getAdditionalInfo());
    }

    @Override
    public boolean delete(Integer pIdToDelete) {
        return mProductDAO.delete(pIdToDelete);
    }
}
