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

package br.com.devteam.sguide.converter;

/**
 * Interface for object conversion
 * @author Guilherme Dio
 * @param <F> From(Original type)
 * @param <T> To(New type)
 */
public interface Converter<F,T> {
	
	public T convertTo(F objeto);
    public F convertFrom(T objeto);
	
}
