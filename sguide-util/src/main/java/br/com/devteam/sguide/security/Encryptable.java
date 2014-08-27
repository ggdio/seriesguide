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
 * Interface made to be used by entities 
 * with encryptable fields
 * @author Guilherme Dio
 *
 */
public interface Encryptable {
	
	public void enableEncryption();
	
	public void disableEncryption();

	public boolean shouldEncrypt();
	
}
