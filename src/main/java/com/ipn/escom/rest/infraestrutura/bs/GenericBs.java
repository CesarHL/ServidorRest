package com.ipn.escom.rest.infraestrutura.bs;

import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import com.ipn.escom.rest.infraestructura.dao.GenericDao;
import com.ipn.escom.rest.infraestructura.mapeo.Modelo;

@Service("genericBs")
@Scope(value = BeanDefinition.SCOPE_SINGLETON)
public class GenericBs implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	protected GenericDao genericDao;

	// @Autowired
	// protected GenericSearchBs genericSearchBs;

	protected <T extends Modelo> T save(T entity) {
		return genericDao.save(entity);
	}

	/**
	 * 
	 */
	protected <C extends Modelo> void save(List<C> list) {
		genericDao.update(list);
	}

	/**
	 * 
	 */
	protected <T extends Modelo> T update(T entity) {
		return genericDao.update(entity);
	}

	/**
	 * 
	 */
	protected <C extends Modelo> void update(List<C> list) {
		genericDao.update(list);
	}

	/**
	 * 
	 */
	protected <T extends Modelo> void delete(T entity) {
		genericDao.delete(entity);
	}

	/**
	 * 
	 */
	protected void clear() {
		genericDao.clear();
	}

}
