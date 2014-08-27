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

package br.com.devteam.sguide.mail;

/**
 * Bean that stores a mail recipient(from/to)
 * @author Guilherme Dio
 *
 */
public class Recipient {

	private String name;
	private String email;

	public Recipient() {
		this("","");
	}
	
	public Recipient(String email) {
		this("",email);
	}

	public Recipient(String name, String email) {
		this.name = name;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}