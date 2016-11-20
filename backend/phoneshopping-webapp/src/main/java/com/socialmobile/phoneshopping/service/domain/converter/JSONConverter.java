package com.socialmobile.phoneshopping.service.domain.converter;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public class JSONConverter {
    private Map<String, Converter> mConverterMap = new HashMap<>();

    public Map<String, Converter> getConverterMap() {
        return mConverterMap;
    }

    public void setConverterMap(final Map<String, Converter> pConverterMap) {
        mConverterMap = pConverterMap;
    }

    public <M, E> Converter<M, E> getConverterFor(final Class<E> pEntity){
        return mConverterMap.get(pEntity.getName());
    }

    public <M, E> M fromEntity(final E pEntity) {
        Converter<M, E> converter = getConverterFor((Class<E>) pEntity.getClass());
        if (converter == null) {
            throw new IllegalStateException("No Converter found for "+pEntity.getClass().getName());
        }

        return converter.fromEntity(pEntity);
    }

    public <M, E> E toEntity(final M pModel, final Class<E> pEntity) {
        Converter<M, E> converter = getConverterFor((Class<E>) pEntity.getClass());
        if (converter == null) {
            throw new IllegalStateException("No Converter found for "+pEntity.getClass().getName());
        }

        return converter.toEntity(pModel);
    }
}
