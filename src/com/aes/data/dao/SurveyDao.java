package com.aes.data.dao;
// Generated Apr 15, 2016 4:28:38 PM by Hibernate Tools 3.5.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;

import com.aes.data.domain.Survey;

import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class Survey.
 * @see com.aes.data.dao.Survey
 * @author Hibernate Tools
 */
public class SurveyDao {

	private static final Log log = LogFactory.getLog(SurveyDao.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(Survey transientInstance) {
		log.debug("persisting Survey instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(Survey instance) {
		log.debug("attaching dirty Survey instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Survey instance) {
		log.debug("attaching clean Survey instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(Survey persistentInstance) {
		log.debug("deleting Survey instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Survey merge(Survey detachedInstance) {
		log.debug("merging Survey instance");
		try {
			Survey result = (Survey) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public Survey findById(int id) {
		log.debug("getting Survey instance with id: " + id);
		try {
			Survey instance = (Survey) sessionFactory.getCurrentSession().get("com.aes.data.dao.Survey", id);
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

	public List<Survey> findByExample(Survey instance) {
		log.debug("finding Survey instance by example");
		try {
			List<Survey> results = (List<Survey>) sessionFactory.getCurrentSession()
					.createCriteria("com.aes.data.dao.Survey").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
