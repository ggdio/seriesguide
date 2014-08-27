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

import br.com.devteam.sguide.i18n.Messager;

/**
 * {@link RuntimeException} for handling initialization errors on {@link Messager}
 * @author Guilherme Dio
 *
 */
public class MessagerInitializationException extends InitializationException
{
	/**
	 * Generated SerialUID
	 */
	private static final long serialVersionUID = -6409668841542493587L;
	
	public MessagerInitializationException(String msg)
	{
		super(msg);
	}

	public MessagerInitializationException(Throwable cause)
	{
		super(cause);
	}
	
	public MessagerInitializationException(String msg,Throwable cause)
	{
		super(msg, cause);
	}
}