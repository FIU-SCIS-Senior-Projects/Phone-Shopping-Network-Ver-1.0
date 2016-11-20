package com.socialmobile.phoneshopping.service.domain.converter;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface Converter<T, E> {
    T fromEntity(final E pEntity);
    E toEntity(final T pModel);
}
