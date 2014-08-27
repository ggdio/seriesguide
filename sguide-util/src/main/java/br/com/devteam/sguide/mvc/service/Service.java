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

import br.com.devteam.sguide.exception.EntityExistsException;
import br.com.devteam.sguide.exception.EntityNotFoundException;
import br.com.devteam.sguide.exception.ServiceException;
import br.com.devteam.sguide.persistence.CustomQuery;

/**
 * Service(Business Logic) specification
 * @author Guilherme Dio
 *
 * @param <T>
 *            - The entity type
 */
public interface Service<T> {

	/**
	 * Execute the add statement of the entity on the model
	 * @param entity - The entity to be added
	 * @throws ServiceException 
	 * @throws EntityExistsException - If the entity already exists
	 */
	public abstract void add(T entity) throws ServiceException, EntityExistsException;
	
	/**
	 * Execute the alter/update statement on the entity of the model
	 * @param entity - The entity to be modified
	 * @throws ServiceException 
	 */
	public abstract void alter(T entity) throws ServiceException;
	
	/**
	 * Execute the remove statement on the entity of the model
	 * @param entity - The entity to be removed
	 * @throws ServiceException 
	 */
	public abstract void delete(T entity) throws ServiceException;
	
	/**
	 * Execute the get statement using the identifier to find the entity on the model
	 * @param identifier
	 * @return The entity found
	 * @throws ServiceException 
	 */
	public abstract T get(Serializable identifier) throws ServiceException, EntityNotFoundException;
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model with a limited number of results and a first entity index to begin collecting
	 * @return List of entities starting by a pre-defined first result index and limited by a maximum number of results
	 * @throws ServiceException 
	 */
	public abstract List<T> listAll(Integer firstResult,Integer maxResults) throws ServiceException, EntityNotFoundException;
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model with a limited number of results
	 * @return List of entities limited by a maximum number of results
	 * @throws ServiceException 
	 */
	public abstract List<T> listAll(Integer maxResults) throws ServiceException, EntityNotFoundException;
	
	/**
	 * Execute the list statement returning a collection of the current entity of the model
	 * @return List of all existent entities
	 * @throws ServiceException 
	 */
	public abstract List<T> listAll() throws ServiceException, EntityNotFoundException;
	
	/**
	 * Execute the custom query returning a collection of the current entity of the model
	 * @return List of existent entities based on the custom query
	 * @throws ServiceException 
	 */
	public abstract List<T> customSearch(CustomQuery customQuery) throws ServiceException, EntityNotFoundException;
	
}
