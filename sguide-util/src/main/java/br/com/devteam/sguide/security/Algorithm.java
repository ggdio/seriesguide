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

import java.security.NoSuchAlgorithmException;

/**
 * ENUM containing algorithms for encrypting information
 * WARNING: The algorithm you choose, must be installed on the machine so it can work.
 * @author Guilherme Dio
 *
 */
public enum Algorithm {	
	MD2("MD2"),
	MD5("MD5"),
	SHA1("SHA-1"),
	SHA256("SHA-256"),
	SHA384("SHA-384"),
	SHA512("SHA-512");
	
	private String algorithm;
	
	public String algorithm() {
		return this.algorithm;
	}
	
	public Encrypter encrypter() throws NoSuchAlgorithmException{
		return new Encrypter(this);
	}
	
	private Algorithm(String algorithm) {
		this.algorithm = algorithm;
	}
}