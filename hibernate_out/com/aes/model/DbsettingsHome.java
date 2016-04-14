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
 * Home object for domain model class Dbsettings.
 * @see com.aes.model.Dbsettings
 * @author Hibernate Tools
 */
public class DbsettingsHome {

    private static final Log log = LogFactory.getLog(DbsettingsHome.class);

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
    
    public void persist(Dbsettings transientInstance) {
        log.debug("persisting Dbsettings instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(Dbsettings instance) {
        log.debug("attaching dirty Dbsettings instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(Dbsettings instance) {
        log.debug("attaching clean Dbsettings instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(Dbsettings persistentInstance) {
        log.debug("deleting Dbsettings instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public Dbsettings merge(Dbsettings detachedInstance) {
        log.debug("merging Dbsettings instance");
        try {
            Dbsettings result = (Dbsettings) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public Dbsettings findById( int id) {
        log.debug("getting Dbsettings instance with id: " + id);
        try {
            Dbsettings instance = (Dbsettings) sessionFactory.getCurrentSession()
                    .get("com.aes.model.Dbsettings", id);
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
    
    public List<Dbsettings> findByExample(Dbsettings instance) {
        log.debug("finding Dbsettings instance by example");
        try {
            List<Dbsettings> results = (List<Dbsettings>) sessionFactory.getCurrentSession()
                    .createCriteria("com.aes.model.Dbsettings")
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
