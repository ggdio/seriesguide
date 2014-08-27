package br.com.devteam.sguide.web.common;


/**
 * Token secure interface
 * @author Guilherme Dio
 *
 */
public interface TokenSecureClient extends Client {

	/**
	 * Sets the auth token
	 * @param token
	 */
	public abstract void setAuthToken(String token);
	
}
