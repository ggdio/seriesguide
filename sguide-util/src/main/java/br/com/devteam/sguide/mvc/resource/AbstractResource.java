package br.com.devteam.sguide.mvc.resource;

import java.io.Serializable;
import java.net.URI;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.Response.Status;

import br.com.devteam.sguide.bean.render.Schema;
import br.com.devteam.sguide.bean.render.SchemaGenerator;
import br.com.devteam.sguide.exception.EntityExistsException;
import br.com.devteam.sguide.exception.EntityNotFoundException;
import br.com.devteam.sguide.exception.ServiceException;
import br.com.devteam.sguide.mvc.service.Service;
import br.com.devteam.sguide.persistence.CustomQuery;
import br.com.devteam.sguide.util.GenericsUtil;
import br.com.devteam.sguide.web.response.HttpResponse;

/**
 * REST layer abstraction
 * @author Guilherme Dio
 *
 * @param <T>
 * 			  - The entity type
 */
public abstract class AbstractResource<T> implements Resource<T> {
	
	/**
	 * The service layer for business logic
	 */
	private Service<T> service;

	public AbstractResource(Service<T> service) {
		this.service = service;
	}

	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#create(javax.ws.rs.core.UriInfo, T)
	 */
	@Override
	public Response create(UriInfo uriInfo,T resource) {
		try {
			//Create resource then return its URL
			service.add(resource);
			return Response.created(buildResourceLocation(uriInfo, resource)).build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityExistsException e){
			return Response.status(Status.CONFLICT).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#update(java.io.Serializable, T)
	 */
	@Override
	public Response update(Serializable id,T resource) {
		try {
			T existent = service.get(id);
			mergeResource(resource, existent);
			service.alter(existent);
			return Response.noContent().build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.status(Status.NOT_FOUND).build();
		}
//		catch(EntityExistsException e){
//			return Response.status(Status.CONFLICT).entity(new HttpResponse(e.getMessage())).build();
//		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#delete(java.io.Serializable)
	 */
	@Override
	public Response delete(Serializable id) {
		try {
			T existent = service.get(id);
			service.delete(existent);
			return Response.noContent().build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.status(Status.NOT_FOUND).build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#get(java.io.Serializable)
	 */
	@Override
	public Response get(Serializable id) {
		try {
			return Response.ok().entity(service.get(id)).build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.status(Status.NOT_FOUND).build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#search()
	 */
	@Override
	public Response search(CustomQuery customQuery) {
		try {
			return Response.ok().entity(wrapCollection(service.customSearch(customQuery))).build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.ok().build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	@Override
	public Response listAll() {
		try {
			return Response.ok().entity(wrapCollection(service.listAll())).build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.ok().build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	@Override
	public Response listAll(Integer offset, Integer length) {
		try {
			return Response.ok().entity(wrapCollection(service.listAll(offset, length))).build();
		} 
		catch (ServiceException e) {
			return Response.status(Status.BAD_REQUEST).entity(new HttpResponse(e.getMessage())).build();
		}
		catch(EntityNotFoundException e){
			return Response.ok().build();
		}
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	/* (non-Javadoc)
	 * @see br.com.unicorp.unij.mvc.resource.Resource#getSchema(java.lang.String)
	 */
	@Override
	public Response getSchema() {
		try {
			Class<T> type = GenericsUtil.resolveGenericType(this.getClass());
			Schema schema = SchemaGenerator.getInstance().generate(type);
			return Response.ok(schema).build();
		} 
		catch(Exception e){
			return Response.serverError().entity(new HttpResponse(e.getMessage())).build();
		}
	}
	
	protected URI buildResourceLocation(UriInfo uriInfo, Serializable id){
		return uriInfo.getAbsolutePathBuilder().path(id.toString()).build();
	}
	
	protected URI buildResourceLocation(UriInfo uriInfo, T resource){
		return buildResourceLocation(uriInfo, getNewResourceIdentifier(resource));
	}

	/**
	 * Gets the service being used
	 * 
	 * @return The service used
	 */
	@SuppressWarnings("unchecked")
	protected <E extends Service<T>> E getService() {
		return (E) this.service;
	}
	
	/**
	 * Wraps a collection into a customized class
	 * @param collection
	 * @return Wrapped collection
	 */
	protected abstract Object wrapCollection(List<T> collection);
	
	/**
	 * Called after creating the new resource
	 * <p>The method must return the new resource ID
	 * @param resource
	 * @return
	 */
	protected abstract Serializable getNewResourceIdentifier(T resource);
	
	/**
	 * Asbtract method that merges resources
	 * <p>Must be implemented in order to update the entity
	 * @param resource
	 * @param existent
	 */
	protected abstract void mergeResource(T resource,T existent);
	
}
