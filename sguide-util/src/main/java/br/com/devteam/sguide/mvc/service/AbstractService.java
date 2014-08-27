/**
 * This document is a part of the source code and related artifacts
 * for Unilims, a restricted laboratorial system.
 *
 * http://www.unicorp.com.br
 *
 * Copyright © 2014 Unicorp Informática Industrial - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 */

package br.com.devteam.sguide.mvc.service;

import java.io.Serializable;
import java.util.List;

import org.apache.log4j.Logger;

import br.com.devteam.sguide.exception.EntityExistsException;
import br.com.devteam.sguide.exception.EntityNotFoundException;
import br.com.devteam.sguide.exception.ServiceException;
import br.com.devteam.sguide.mvc.repository.Repository;
import br.com.devteam.sguide.persistence.CustomQuery;

/**
 * Service layer abstraction
 * @author Guilherme Dio
 *
 * @param <T>
 * 			  - The entity type
 */
public abstract class AbstractService<T> implements Service<T> {

	/**
	 * Logger
	 */
	protected final Logger log = Logger.getLogger(AbstractService.class);

	/**
	 * The dao must be injected by the above level
	 */
	private final Repository<T> repository;

	/**
	 * Constructs the master service with a dao that must be injected
	 * 
	 * @param dao
	 *            - The dao to be used
	 */
	public AbstractService(Repository<T> repository) {
		this.repository = repository;
	}

	/**
	 * Execute the add statement of the entity on the model
	 * 
	 * @param entity
	 *            - The entity to be added
	 * @throws ServiceException
	 * @throws EntityExistsException 
	 */
	@Override
	public void add(T entity) throws ServiceException, EntityExistsException {
		try {
			repository.saveOrUpdate(entity);
		} 
		catch(EntityExistsException e){
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Execute the alter/update statement on the entity of the model
	 * 
	 * @param entity
	 *            - The entity to be modified
	 * @throws ServiceException
	 * @throws EntityExistsException 
	 */
	@Override
	public void alter(T entity) throws ServiceException {
		try {
			repository.saveOrUpdate(entity);
		} 
//		catch(EntityExistsException e){
//			throw e;
//		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Execute the remove statement on the entity of the model
	 * 
	 * @param entity
	 *            - The entity to be removed
	 * @throws ServiceException
	 */
	@Override
	public void delete(T entity) throws ServiceException {
		try {
			repository.delete(entity);
		} 
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Execute the get statement using the identifier to find the entity on the
	 * model
	 * 
	 * @param identifier
	 * @return The entity found
	 * @throws ServiceException
	 */
	@Override
	public T get(Serializable identifier) throws ServiceException, EntityNotFoundException {
		try {
			return repository.get(identifier);
		} 
		catch(EntityNotFoundException e){
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Execute the list statement returning a collection of the current entity
	 * of the model with a limited number of results and a first entity index to
	 * begin collecting
	 * 
	 * @return List of entities
	 * @throws ServiceException
	 */
	@Override
	public List<T> listAll(Integer firstResult, Integer maxResults) throws ServiceException, EntityNotFoundException {
		if(firstResult == null) firstResult = 0;
		if(maxResults == null) maxResults = 0;
		try {
			return repository.listAll(firstResult, maxResults);
		} 
		catch(EntityNotFoundException e){
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Execute the list statement returning a collection of the current entity
	 * of the model with a limited number of results
	 * 
	 * @return List of entities
	 * @throws ServiceException
	 */
	@Override
	public List<T> listAll(Integer maxResults) throws ServiceException, EntityNotFoundException {
		return listAll(0, maxResults);
	}

	/**
	 * Execute the list statement returning a collection of the current entity
	 * of the model
	 * 
	 * @return List of entities
	 * @throws ServiceException
	 */
	@Override
	public List<T> listAll() throws ServiceException, EntityNotFoundException {
		return listAll(0, 0);
	}
	
	/**
	 * Execute the custom query returning a collection of the current entity of the model
	 * @return List of existent entities based on the custom query
	 * @throws ServiceException 
	 */
	@Override
	public List<T> customSearch(CustomQuery customQuery) throws ServiceException, EntityNotFoundException {
		try {
			return repository.customQuery(customQuery);
		} 
		catch(EntityNotFoundException e){
			throw e;
		}
		catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	/**
	 * Gets the dao being used
	 * 
	 * @return The dao used
	 */
	@SuppressWarnings("unchecked")
	protected <E extends Repository<T>> E getRepository() {
		return (E) this.repository;
	}

}