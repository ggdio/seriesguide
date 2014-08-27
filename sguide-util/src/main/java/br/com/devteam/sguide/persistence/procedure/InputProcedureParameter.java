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
 * Parameter for inputing value on stored procedure
 * @author Guilherme Dio
 *
 */
public final class InputProcedureParameter extends ProcedureParameter {

	public InputProcedureParameter(Class<?> type, Object value) {
		super.type = type;
		super.mode = ParameterMode.IN;
		super.value = value;
	}
}
