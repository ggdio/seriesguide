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

import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * Enum responsible for providing the strategies 
 * for multitenancy database connection
 * @author Guilherme Dio
 *
 */
public enum MultitenancyStrategy {
	/**
	 * Filter results with tenant_id
	 */
	FILTER(new MultiTenancyStrategy() {

		@Override
		public Session getSession(SessionFactory factory, String tenantId) {
			Session session = factory.openSession();
			session.enableFilter("tenantFilter").setParameter("tenantId", tenantId);
			return session;
		}
	}),
	/**
	 * Discriminator on each table
	 */
	DISCRIMINATOR(new MultiTenancyStrategy() {

		@Override
		public Session getSession(SessionFactory factory, String tenantId) {
			return factory.withOptions().tenantIdentifier(tenantId).openSession();
		}
	});

	private MultiTenancyStrategy strategy;
	
	public MultiTenancyStrategy getStrategy() {
		return strategy;
	}

	private MultitenancyStrategy(MultiTenancyStrategy mtStrategy) {
		this.strategy = mtStrategy;
	}
	
	public interface MultiTenancyStrategy {
		Session getSession(SessionFactory factory, String tenantId);
	}
}
