package com.socialmobile.phoneshopping.service.domain.converter.json;

import com.socialmobile.common.model.Product;
import com.socialmobile.phoneshopping.service.domain.ProductEntity;
import com.socialmobile.phoneshopping.service.domain.converter.Converter;
import com.socialmobile.phoneshopping.service.domain.converter.JSONConverter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class ProductConverter implements Converter<Product, ProductEntity> {

    @Override
    public Product fromEntity(final ProductEntity pEntity) {
        Product product = new Product();
        product.setProductId(pEntity.getProductId());
        product.setTitle(pEntity.getTitle());
        product.setDescription(pEntity.getDescription());
        product.setAdditionalInfo(new HashMap<>(pEntity.getAdditionalInfoAsMap()));

        return product;
    }

    @Override
    public ProductEntity toEntity(final Product pModel) {
        ProductEntity entity = new ProductEntity();
        entity.setProductId(pModel.getProductId());
        entity.setTitle(pModel.getTitle());
        entity.setDescription(pModel.getDescription());
        entity.setAdditionalInfo(pModel.getAdditionalInfo());
        return entity;
    }

}
