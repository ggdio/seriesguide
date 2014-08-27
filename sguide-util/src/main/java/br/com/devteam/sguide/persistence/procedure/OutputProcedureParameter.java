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

import javax.persistence.ParameterMode;

/**
 * Parameter for outputing values on stored procedure
 * @author Guilherme Dio
 *
 */
public final class OutputProcedureParameter extends ProcedureParameter {

	public OutputProcedureParameter(Class<?> type) {
		super.type = type;
		super.mode = ParameterMode.OUT;
		super.value = "";
	}

}