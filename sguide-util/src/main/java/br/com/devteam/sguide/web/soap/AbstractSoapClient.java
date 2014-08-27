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

package br.com.devteam.sguide.web.soap;

import java.net.MalformedURLException;
import java.util.Map;

import br.com.devteam.sguide.util.GenericsUtil;
import br.com.devteam.sguide.web.common.Endpoint;

/**
 * Abstract Webservice Client
 * @author Guilherme Dio
 *
 * @param <T> - The endpoint type
 */
public abstract class AbstractSoapClient<T extends Endpoint> {

	protected EndpointFactory factory;
	private Class<T> clazz;
	
	public AbstractSoapClient(String url,String namespace,String serviceName) throws MalformedURLException {
		this.factory = new EndpointFactory(url, namespace, serviceName);
		this.clazz = GenericsUtil.resolveGenericType(this.getClass());
	}
	
	/**
	 * Get endpoint for the service
	 * @return
	 */
	public T getEndpoint(){
		return factory.createEndpoint(clazz, null);
	}
	
	/**
	 * Get endpoint with headers
	 * @param headerParams
	 * @return
	 */
	public T getEndpoint(Map<String,String> headerParams){
		return factory.createEndpoint(clazz, headerParams);
	}
	
	/**
	 * Set header on the port
	 * @param endpoint
	 * @param headerParams
	 */
	public void setHeader(T endpoint, Map<String,String> headerParams){
		EndpointFactory.setHttpHeaders(endpoint, headerParams);
	}
	
}
