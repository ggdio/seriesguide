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

package br.com.devteam.sguide.hibernate;

import org.hibernate.cfg.ImprovedNamingStrategy;

/**
 * Customized naming strategy
 * 
 * @author Guilherme Dio
 * 
 */
public class CustomNamingStrategy extends ImprovedNamingStrategy {

	/**
	 * UID
	 */
	private static final long serialVersionUID = 1L;

	private String currentTableName;

	@Override
	public String propertyToColumnName(String propertyName) {
		if (String.valueOf(propertyName).toLowerCase().equals("codigo"))
			return "id" + currentTableName.toLowerCase();
		if (String.valueOf(propertyName).toLowerCase().equals("tenantid"))
			return "idtenant";
		if (String.valueOf(propertyName).toLowerCase().equals("codigolegado"))
			return "codlegado" + currentTableName.toLowerCase();
		if (String.valueOf(propertyName).toLowerCase().equals("descricao"))
			return "desc" + currentTableName.toLowerCase();
		if(!String.valueOf(propertyName).toLowerCase().equals(currentTableName.toLowerCase()))
			return String.valueOf(propertyName).toLowerCase() + currentTableName.toLowerCase();
		return String.valueOf(propertyName).toLowerCase();
	}

	@Override
	public String classToTableName(String className) {
		this.currentTableName = className;
		return className.toLowerCase();
	}
	
	@Override
	public String joinKeyColumnName(String joinedColumn, String joinedTable) {
		return "id" + String.valueOf(joinedTable).toLowerCase();
	}
	
	@Override
	public String foreignKeyColumnName(String propertyName, String propertyEntityName, String propertyTableName, String referencedColumnName) {
		return "id" + String.valueOf(propertyTableName).toLowerCase();
	}
}
