package com.socialmobile.phoneshopping.service.api;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface ServiceBase<T, I extends Serializable> {
    boolean exists(final I pIdToCheck);
    T get(final I pIdToGet);
    T create(final T pObjectToCreate);
    T update(final I pTargetObjectId, final T pUpdateWith);
    boolean delete(final I pIdToDelete);
}
