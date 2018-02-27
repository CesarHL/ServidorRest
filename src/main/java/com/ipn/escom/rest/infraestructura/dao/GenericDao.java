package com.ipn.escom.rest.infraestructura.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ipn.escom.rest.infraestructura.mapeo.Modelo;

@Repository("genericDao")
public class GenericDao {

	@PersistenceContext
	protected EntityManager entityManager;

	/**
	 */
	public <C extends Modelo> C findById(Class<C> clazz, Serializable id) {
		entityManager.clear();
		return entityManager.find(clazz, id);
	}

	/**
	 * 
	 */
	@SuppressWarnings({ "unchecked"})
	@Transactional(readOnly = true)
	public <C extends Modelo> List<C> findByExample(C example) {
		Session session = entityManager.unwrap(Session.class);
		return (List<C>) session.createCriteria(example.getClass()).add(Example.create(example)).list();

	}

	/**
	 * 
	 */
	public <C extends Modelo> List<C> findAll(Class<C> clazz) {
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
		CriteriaQuery<C> criteria = builder.createQuery(clazz);
		criteria.from(clazz);
		return entityManager.createQuery(criteria).getResultList();
	}

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C save(C entity) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(entity);
		session.flush();
		return entity;
	}

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void save(List<C> list) {
		Session session = entityManager.unwrap(Session.class);
		for (C entity : list) {
			session.saveOrUpdate(entity);
		}
	}

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> C update(C entity) {
		Session session = entityManager.unwrap(Session.class);
		entityManager.clear();
		session.update(entity);
		session.flush();
		return entity;
	}

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void update(List<C> list) {
		Session session = entityManager.unwrap(Session.class);
		for (C entity : list) {
			session.saveOrUpdate(entity);
		}
		session.flush();
		session.clear();
	}

	/**
	 * 
	 */
	@Transactional(propagation = Propagation.MANDATORY)
	public <C extends Modelo> void delete(C entity) {
		entityManager.remove(entityManager.contains(entity) ? entity : entityManager.merge(entity));
	}

	/**
	 * 
	 */
	public <C extends Modelo> C refreshEntity(C entity) {
		Session session = entityManager.unwrap(Session.class);
		session.refresh(entity);
		return entity;
	}

	/**
	 * 
	 */
	public void clear() {
		Session session = entityManager.unwrap(Session.class);
		session.clear();
	}

}
