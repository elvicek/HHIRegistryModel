package com.aes.data.dao;
// Generated Apr 14, 2016 4:54:20 PM by Hibernate Tools 3.5.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class SurveyClient.
 * @see com.aes.data.dao.SurveyClient
 * @author Hibernate Tools
 */
public class SurveyClientHome {

	private static final Log log = LogFactory.getLog(SurveyClientHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(SurveyClient transientInstance) {
		log.debug("persisting SurveyClient instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(SurveyClient instance) {
		log.debug("attaching dirty SurveyClient instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SurveyClient instance) {
		log.debug("attaching clean SurveyClient instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(SurveyClient persistentInstance) {
		log.debug("deleting SurveyClient instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SurveyClient merge(SurveyClient detachedInstance) {
		log.debug("merging SurveyClient instance");
		try {
			SurveyClient result = (SurveyClient) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public SurveyClient findById(com.aes.data.dao.SurveyClientId id) {
		log.debug("getting SurveyClient instance with id: " + id);
		try {
			SurveyClient instance = (SurveyClient) sessionFactory.getCurrentSession()
					.get("com.aes.data.dao.SurveyClient", id);
			if (instance == null) {
				log.debug("get successful, no instance found");
			} else {
				log.debug("get successful, instance found");
			}
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<SurveyClient> findByExample(SurveyClient instance) {
		log.debug("finding SurveyClient instance by example");
		try {
			List<SurveyClient> results = (List<SurveyClient>) sessionFactory.getCurrentSession()
					.createCriteria("com.aes.data.dao.SurveyClient").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
