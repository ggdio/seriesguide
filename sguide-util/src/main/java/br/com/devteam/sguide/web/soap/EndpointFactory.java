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
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;
import javax.xml.ws.handler.MessageContext;

import br.com.devteam.sguide.web.common.Endpoint;

/**
 * Endpoint Factory Utility
 * @author Guilherme Dio
 *
 */
public class EndpointFactory extends Service{

	public EndpointFactory(String url,String namespace,String serviceName) throws MalformedURLException{
		super(new URL(url), new QName(namespace,serviceName));
	}
	
	/**
	 * Build a new endpoint connection
	 * @param clazz - Endpoint interface
	 * @param headerParams - Parameteres to be set on header
	 * @return
	 */
	public <T extends Endpoint> T createEndpoint(Class<T> clazz,Map<String, String> headerParams){
		T port = super.getPort(clazz);
		setHttpHeaders(port, headerParams);
		return port;
	}
	
	public static <T extends Endpoint> void setHttpHeaders(T port,Map<String, String> headerParams){
		if(headerParams != null){
			Map<String, List<String>> headers = new HashMap<String, List<String>>();
			for(String key : headerParams.keySet()){
				headers.put(key, Collections.singletonList(headerParams.get(key)));
			}
			((BindingProvider)port).getRequestContext().put(MessageContext.HTTP_REQUEST_HEADERS, headers);
		}
	}
	
	public static <T extends Endpoint> void setSoapHeaders(T port,Map<String, Map<String, String>> soapHeaders){
	}
	
}