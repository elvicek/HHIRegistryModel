package com.aes.data.dao;
// Generated Apr 15, 2016 10:05:06 AM by Hibernate Tools 3.5.0.Final

import java.util.List;
import javax.naming.InitialContext;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import static org.hibernate.criterion.Example.create;

/**
 * Home object for domain model class PersonRole.
 * @see com.aes.data.dao.PersonRole
 * @author Hibernate Tools
 */
public class PersonRoleHome {

	private static final Log log = LogFactory.getLog(PersonRoleHome.class);

	private final SessionFactory sessionFactory = getSessionFactory();

	protected SessionFactory getSessionFactory() {
		try {
			return (SessionFactory) new InitialContext().lookup("SessionFactory");
		} catch (Exception e) {
			log.error("Could not locate SessionFactory in JNDI", e);
			throw new IllegalStateException("Could not locate SessionFactory in JNDI");
		}
	}

	public void persist(PersonRole transientInstance) {
		log.debug("persisting PersonRole instance");
		try {
			sessionFactory.getCurrentSession().persist(transientInstance);
			log.debug("persist successful");
		} catch (RuntimeException re) {
			log.error("persist failed", re);
			throw re;
		}
	}

	public void attachDirty(PersonRole instance) {
		log.debug("attaching dirty PersonRole instance");
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(PersonRole instance) {
		log.debug("attaching clean PersonRole instance");
		try {
			sessionFactory.getCurrentSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void delete(PersonRole persistentInstance) {
		log.debug("deleting PersonRole instance");
		try {
			sessionFactory.getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public PersonRole merge(PersonRole detachedInstance) {
		log.debug("merging PersonRole instance");
		try {
			PersonRole result = (PersonRole) sessionFactory.getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public PersonRole findById(com.aes.data.dao.PersonRoleId id) {
		log.debug("getting PersonRole instance with id: " + id);
		try {
			PersonRole instance = (PersonRole) sessionFactory.getCurrentSession().get("com.aes.data.dao.PersonRole",
					id);
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

	public List<PersonRole> findByExample(PersonRole instance) {
		log.debug("finding PersonRole instance by example");
		try {
			List<PersonRole> results = (List<PersonRole>) sessionFactory.getCurrentSession()
					.createCriteria("com.aes.data.dao.PersonRole").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
}
