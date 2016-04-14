package com.aes.model;
// Generated Apr 14, 2016 4:36:50 PM by Hibernate Tools 3.5.0.Final


import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class AddressPk.
 * @see com.aes.model.AddressPk
 * @author Hibernate Tools
 */
public class AddressPkHome {

    private static final Log log = LogFactory.getLog(AddressPkHome.class);

    private final SessionFactory sessionFactory = getSessionFactory();
    
    protected SessionFactory getSessionFactory() {
        try {
            return (SessionFactory) new InitialContext().lookup("SessionFactory");
        }
        catch (Exception e) {
            log.error("Could not locate SessionFactory in JNDI", e);
            throw new IllegalStateException("Could not locate SessionFactory in JNDI");
        }
    }
    
    public void persist(AddressPk transientInstance) {
        log.debug("persisting AddressPk instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(AddressPk instance) {
        log.debug("attaching dirty AddressPk instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(AddressPk instance) {
        log.debug("attaching clean AddressPk instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(AddressPk persistentInstance) {
        log.debug("deleting AddressPk instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public AddressPk merge(AddressPk detachedInstance) {
        log.debug("merging AddressPk instance");
        try {
            AddressPk result = (AddressPk) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public AddressPk findById( java.lang.Integer id) {
        log.debug("getting AddressPk instance with id: " + id);
        try {
            AddressPk instance = (AddressPk) sessionFactory.getCurrentSession()
                    .get("com.aes.model.AddressPk", id);
            if (instance==null) {
                log.debug("get successful, no instance found");
            }
            else {
                log.debug("get successful, instance found");
            }
            return instance;
        }
        catch (RuntimeException re) {
            log.error("get failed", re);
            throw re;
        }
    }
    
    public List<AddressPk> findByExample(AddressPk instance) {
        log.debug("finding AddressPk instance by example");
        try {
            List<AddressPk> results = (List<AddressPk>) sessionFactory.getCurrentSession()
                    .createCriteria("com.aes.model.AddressPk")
                    .add( create(instance) )
            .list();
            log.debug("find by example successful, result size: " + results.size());
            return results;
        }
        catch (RuntimeException re) {
            log.error("find by example failed", re);
            throw re;
        }
    } 
}

