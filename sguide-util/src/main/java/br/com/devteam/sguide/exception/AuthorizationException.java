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
 * Exception used to indicate problems on authorization
 * @author Guilherme Dio
 * 
 */
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 571746798149696954L;

	public AuthorizationException() {
		super();
	}

	public AuthorizationException(String msg) {
		super(msg);
	}

}
