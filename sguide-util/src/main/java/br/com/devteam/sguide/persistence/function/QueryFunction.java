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

package br.com.devteam.sguide.persistence.function;

/**
 * Available query functions
 * @author Guilherme Dio
 *
 */
public enum QueryFunction {

	/**
	 * Encrypts the value on query
	 * <p><b>WARNING:</b></p> 
	 * <p><i>If it fail, the query will be replaced by an invalid one for system safety</i></p>
	 */
	ENCRYPT("#encrypt",new EncryptFunctionStrategy());
	
	private String functionIdentifier;
	private FunctionStrategy strategy;

	private QueryFunction(String functionIdentifier,FunctionStrategy strategy){
		this.functionIdentifier = functionIdentifier;
		this.strategy = strategy;
	}

	public String getFunctionIdentifier() {
		return functionIdentifier;
	}

	public FunctionStrategy getStrategy() {
		return strategy;
	}
	
	public int getIdentifierLenght(){
		return this.getFunctionIdentifier().length();
	}	
}