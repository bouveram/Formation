package com.m2i.formation.repositories;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.*;

import com.m2i.formation.media.entities.IEntity;

public abstract class AbstractRepository<T extends IEntity>
				implements IRepository<T>, IUoW{
	
	private EntityManager entityManager;
	private EntityTransaction transaction;
	private Class<T> entityClass;
	
	@SuppressWarnings("unchecked")
	public AbstractRepository () {
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.entityClass = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}
	
	@Override
	public EntityManager getEntityManager() {
		return entityManager;
	}

	@Override
	public EntityTransaction getTransaction() {
		if(transaction == null) {
			transaction = entityManager.getTransaction();
		}
		if(!transaction.isActive()) {
			transaction.begin();
		}
		return transaction;
	}

	@Override
	public void setTransaction(EntityTransaction transaction) {
		this.transaction = transaction;
		
	}

	@Override
	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
		
	}

	@Override
	public T save(T entity) {
		entityManager.persist(entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		entityManager.merge(entity);
		return entity;
	}

	@Override
	public void remove(T entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	@Override
	public T getById(int id) {
		return entityManager.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		return entityManager.createQuery("select e from " + entityClass.getSimpleName() + " e").getResultList();
	}

	@SuppressWarnings("unchecked")
	protected List<T> getByWhere(String where) {
		return entityManager.createQuery("select e from " + entityClass.getSimpleName() + " e where " + where).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	protected List<T> getByJPQL(String jpql) {
		return entityManager.createQuery(jpql).getResultList();
	}

	@Override
	public void commit() {
		getTransaction().commit();
	}
	
}
