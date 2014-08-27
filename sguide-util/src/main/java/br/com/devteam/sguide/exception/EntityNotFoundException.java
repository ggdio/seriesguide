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

package br.com.devteam.sguide.exception;

/**
 * Exception responsible for indicating that
 * no results were found by the query
 * @author Guilherme Dio
 *
 */
public class EntityNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException() {
		this(null);
	}
	
	public EntityNotFoundException(String msg) {
		this(msg,null);
	}
	
	public EntityNotFoundException(String msg, Throwable cause) {
		super(msg,cause);
	}
	
}
