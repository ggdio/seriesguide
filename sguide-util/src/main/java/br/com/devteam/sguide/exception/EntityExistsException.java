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
 * an entity already exists on the database
 * @author Guilherme Dio
 *
 */
public class EntityExistsException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public EntityExistsException() {
		this(null);
	}
	
	public EntityExistsException(String msg) {
		this(msg,null);
	}
	
	public EntityExistsException(String msg, Throwable cause) {
		super(msg,cause);
	}
	
}
