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
 * Home object for domain model class SurveyReadings.
 * @see com.aes.model.SurveyReadings
 * @author Hibernate Tools
 */
public class SurveyReadingsHome {

    private static final Log log = LogFactory.getLog(SurveyReadingsHome.class);

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
    
    public void persist(SurveyReadings transientInstance) {
        log.debug("persisting SurveyReadings instance");
        try {
            sessionFactory.getCurrentSession().persist(transientInstance);
            log.debug("persist successful");
        }
        catch (RuntimeException re) {
            log.error("persist failed", re);
            throw re;
        }
    }
    
    public void attachDirty(SurveyReadings instance) {
        log.debug("attaching dirty SurveyReadings instance");
        try {
            sessionFactory.getCurrentSession().saveOrUpdate(instance);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void attachClean(SurveyReadings instance) {
        log.debug("attaching clean SurveyReadings instance");
        try {
            sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
            log.debug("attach successful");
        }
        catch (RuntimeException re) {
            log.error("attach failed", re);
            throw re;
        }
    }
    
    public void delete(SurveyReadings persistentInstance) {
        log.debug("deleting SurveyReadings instance");
        try {
            sessionFactory.getCurrentSession().delete(persistentInstance);
            log.debug("delete successful");
        }
        catch (RuntimeException re) {
            log.error("delete failed", re);
            throw re;
        }
    }
    
    public SurveyReadings merge(SurveyReadings detachedInstance) {
        log.debug("merging SurveyReadings instance");
        try {
            SurveyReadings result = (SurveyReadings) sessionFactory.getCurrentSession()
                    .merge(detachedInstance);
            log.debug("merge successful");
            return result;
        }
        catch (RuntimeException re) {
            log.error("merge failed", re);
            throw re;
        }
    }
    
    public SurveyReadings findById( int id) {
        log.debug("getting SurveyReadings instance with id: " + id);
        try {
            SurveyReadings instance = (SurveyReadings) sessionFactory.getCurrentSession()
                    .get("com.aes.model.SurveyReadings", id);
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
    
    public List<SurveyReadings> findByExample(SurveyReadings instance) {
        log.debug("finding SurveyReadings instance by example");
        try {
            List<SurveyReadings> results = (List<SurveyReadings>) sessionFactory.getCurrentSession()
                    .createCriteria("com.aes.model.SurveyReadings")
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

