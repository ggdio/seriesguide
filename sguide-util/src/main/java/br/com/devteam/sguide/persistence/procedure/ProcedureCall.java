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

package br.com.devteam.sguide.persistence.procedure;

import javax.persistence.StoredProcedureQuery;

/**
 * A stored procudure caller
 * @author Guilherme Dio
 *
 */
public class ProcedureCall {
	
	private StoredProcedureQuery query;
	private Integer outIndex;

	/**
	 * Prepares the call
	 * @param query - The query for the procedure
	 * @param outIndex - The position of the output parameter
	 */
	public ProcedureCall(StoredProcedureQuery query,Integer outIndex) {
		this.query = query;
		this.outIndex = outIndex;
	}
	
	/**
	 * Execute the procedure call
	 * @return An object containing the result
	 */
	public Object call(){
		query.execute();
		return query.getOutputParameterValue(outIndex);
	}
	
}
