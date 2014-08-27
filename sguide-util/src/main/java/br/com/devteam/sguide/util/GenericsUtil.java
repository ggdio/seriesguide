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

package br.com.devteam.sguide.util;

import java.lang.reflect.ParameterizedType;

/**
 * Utility for java generics
 * @author Guilherme Dio
 *
 */
public class GenericsUtil {

	/**
	 * Resolve the parameterized type of the owner class
	 * @param owner - The class that owns the generic type
	 * @return A class type
	 */
	@SuppressWarnings("unchecked")
	public static <T> Class<T> resolveGenericType(Class<?> owner){
		return (Class<T>) ((ParameterizedType) owner.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
}
