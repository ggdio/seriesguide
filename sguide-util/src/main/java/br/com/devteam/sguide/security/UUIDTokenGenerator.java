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

import java.util.UUID;

/**
 * A token generator based on UUID pattern
 * The regex for this token is: [0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}
 * @author Guilherme Dio
 *
 */
public class UUIDTokenGenerator implements TokenGenerator {
	
	@Override
	public Token generate() {
		return new Token(UUID.randomUUID().toString(),getPattern());
	}
	
	@Override
	public Token generate(String value){
		Token newToken = new Token(value, getPattern());
		if(newToken.isValid())
			return newToken;
		return null;
	}
	
	@Override
	public String getPattern() {
		return "[0-9a-f]{8}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{4}-[0-9a-f]{12}";
	}
}
