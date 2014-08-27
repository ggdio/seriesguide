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
 * {@link RuntimeException} for handling errors while initializating classes, or objects
 * @author Guilherme Dio
 *
 */
public class InitializationException extends RuntimeException
{

	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = 4180247098051967002L;
	
	public InitializationException(String msg)
	{
		super(msg);
	}

	public InitializationException(Throwable cause)
	{
		super(cause);
	}
	
	public InitializationException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
	
}