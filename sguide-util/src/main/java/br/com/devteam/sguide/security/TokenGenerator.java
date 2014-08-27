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

package br.com.devteam.sguide.security;


/**
 * Interface that defines a token generator
 * @author Guilherme Dio
 *
 */
public interface TokenGenerator {

	/**
	 * Generates a randomic token based on pattern
	 * @return A token
	 */
	public Token generate();
	
	/**
	 * Generates a token by a pre-defined value
	 * @param value
	 * @return
	 */
	public Token generate(String value);
	
	/**
	 * Get the token generation pattern
	 * @return
	 */
	public String getPattern();

}
