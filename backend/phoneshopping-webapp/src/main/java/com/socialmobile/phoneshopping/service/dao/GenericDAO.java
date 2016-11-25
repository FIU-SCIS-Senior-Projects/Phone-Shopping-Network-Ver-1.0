package com.socialmobile.phoneshopping.service.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:dalam004@fiu.edu">Dewan Moksedul Alam</a>
 * @author last modified by $Author: $
 * @version $Revision: $ $Date: $
 */
@Service
public class GenericDAO {
    @Autowired
    LocalSessionFactoryBean sessionFactoryBean;

    private SessionFactory getSessionFactory() {
        return sessionFactoryBean.getObject();
    }

    public <T, I extends Serializable> T findById(final I pId, final Class<T> pEntity) {
        return getSessionFactory().getCurrentSession().get(pEntity, pId);
    }

    public <T> Serializable save(final T pObjectToCreate) {
        return getSessionFactory().getCurrentSession().save(pObjectToCreate);
    }

    public <T> void update(final T pUpdateWith) {
        getSessionFactory().getCurrentSession().update(pUpdateWith);
    }

    public <T> void delete(final T pObjectDelete) {
        getSessionFactory().getCurrentSession().delete(pObjectDelete);
    }

    public <T> List<T> listByNamedQuery(final String pQuery, final Map<String, ? extends Object> pValuesMap) {
        Query<T> query = getSessionFactory().getCurrentSession().getNamedQuery(pQuery);
        return listByNamedQuery(query, pValuesMap);
    }

    public <T> List<T> listByNamedNativeQuery(final String pNamedQuery, final Map<String, ? extends Object> pValuesMap) {
        NativeQuery<T> query = getSessionFactory().getCurrentSession().getNamedNativeQuery(pNamedQuery);
        return listByNamedQuery(query, pValuesMap);
    }

    private <T> List<T> listByNamedQuery(final Query<T> pQuery, final Map<String, ? extends Object> pValuesMap) {
        for (Map.Entry<String, ? extends Object> entry : pValuesMap.entrySet()) {
            pQuery.setParameter(entry.getKey(), entry.getValue());
        }
        return pQuery.list();
    }

    public <T> List<T> listAll(final Class<T> pEntityClass, final int pStart, final int pCount) {
        String queryString = String.format("select o from %s o", pEntityClass.getSimpleName());
        Query<T> query = getSessionFactory().getCurrentSession().createQuery(queryString);
        query.setMaxResults(pCount);
        query.setFirstResult(pStart);
        return query.list();
    }
}
