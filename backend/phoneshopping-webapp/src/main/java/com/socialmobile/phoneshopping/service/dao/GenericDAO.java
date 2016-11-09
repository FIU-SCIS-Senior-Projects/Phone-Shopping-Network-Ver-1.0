package com.socialmobile.phoneshopping.service.dao;

import com.socialmobile.phoneshopping.service.api.ServiceBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.io.Serializable;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
public abstract class GenericDAO<T, I extends Serializable> implements ServiceBase<T,I> {
    @Autowired
    private LocalSessionFactoryBean sessionFactoryBean;

    protected SessionFactory getSessionFactory() {
        return sessionFactoryBean.getObject();
    }

    @Override
    public boolean exists(final I pIdToCheck) {
        try {
            T object = getSessionFactory().getCurrentSession().get(getEntity(), pIdToCheck);
            return object != null;
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }

        return false;
    }

    @Override
    public T get(final I pIdToGet) {
        return getSessionFactory().getCurrentSession().get(getEntity(), pIdToGet);
    }

    @Override
    public T create(final T pObjectToCreate) {
        Serializable id = getSessionFactory().getCurrentSession().save(pObjectToCreate);
        return get((I) id);
    }

    @Override
    public T update(final I pTargetObjectId, final T pUpdateWith) {
        Session currentSession = getSessionFactory().getCurrentSession();
        T oldObject = get(pTargetObjectId);
        currentSession.update(pUpdateWith);
        return pUpdateWith;
    }

    @Override
    public boolean delete(final I pIdToDelete) {
        T object = getSessionFactory().getCurrentSession().get(getEntity(), pIdToDelete);
        getSessionFactory().getCurrentSession().delete(object);
        return true;
    }

    protected abstract Class<T> getEntity();
}
