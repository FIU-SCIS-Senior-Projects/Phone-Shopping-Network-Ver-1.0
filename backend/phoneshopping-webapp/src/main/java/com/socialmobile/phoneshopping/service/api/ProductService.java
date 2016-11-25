package com.socialmobile.phoneshopping.service.api;

import com.socialmobile.common.model.Product;

import java.util.List;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface ProductService extends ServiceBase<Product, Integer> {
    List<Product> getProducts(final int pStart, final int pCount);
}
