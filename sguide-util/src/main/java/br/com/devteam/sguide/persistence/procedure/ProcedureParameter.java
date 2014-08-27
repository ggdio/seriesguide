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
 * Parameter for inputing/outputing values on procedure call
 * @author Guilherme Dio
 *
 */
public class ProcedureParameter {

	protected Class<?> type;
	protected ParameterMode mode;
	protected Object value;
	
	public ProcedureParameter() {
		
	}

	public ProcedureParameter(Class<?> clazz, ParameterMode type, Object value) {
		this.type = clazz;
		this.mode = type;
		this.value = value;
	}

	public Class<?> getType() {
		return type;
	}

	public void setType(Class<?> clazz) {
		this.type = clazz;
	}

	public ParameterMode getMode() {
		return mode;
	}

	public void setMode(ParameterMode type) {
		this.mode = type;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

}
