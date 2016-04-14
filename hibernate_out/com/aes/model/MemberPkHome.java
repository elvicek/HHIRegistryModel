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
 * Home object for domain model class MemberPk.
 * @see com.aes.model.MemberPk
 * @author Hibernate Tools
 */
public class MemberPkHome {

    private static final Log log = LogFactory.getLog(MemberPkHome.class);

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
    
    public void persist(MemberPk transientInstance) {
        log.debug("persisting MemberPk instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(MemberPk instance) {
        log.debug("attaching dirty MemberPk instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(MemberPk instance) {
        log.debug("attaching clean MemberPk instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(MemberPk persistentInstance) {
        log.debug("deleting MemberPk instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public MemberPk merge(MemberPk detachedInstance) {
        log.debug("merging MemberPk instance");
        try {
            MemberPk result = (MemberPk) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public MemberPk findById( java.lang.Integer id) {
        log.debug("getting MemberPk instance with id: " + id);
        try {
            MemberPk instance = (MemberPk) sessionFactory.getCurrentSession()
                    .get("com.aes.model.MemberPk", id);
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
    
    public List<MemberPk> findByExample(MemberPk instance) {
        log.debug("finding MemberPk instance by example");
        try {
            List<MemberPk> results = (List<MemberPk>) sessionFactory.getCurrentSession()
                    .createCriteria("com.aes.model.MemberPk")
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

