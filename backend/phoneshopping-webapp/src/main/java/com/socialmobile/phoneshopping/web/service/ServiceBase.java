package com.socialmobile.phoneshopping.web.service;

import java.util.Optional;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public interface ServiceBase<T> {
    boolean exists(final String pIdToCheck);
    T get(final String pIdToGet);
    T create(final Optional<T> pObjectToCreate);
    T update(final String pTargetObjectId, final Optional<T> pUpdateWith);
    boolean delete(final String pIdToDelete);
}
