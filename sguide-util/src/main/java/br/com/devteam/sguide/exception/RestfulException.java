package br.com.devteam.sguide.exception;

/**
 * Exception made to indentify rest calls errors
 * @author Guilherme Dio
 *
 */
public class RestfulException extends Exception {

	private static final long serialVersionUID = 1L;
	
	private final Integer status;

	public RestfulException(Integer status,String msg) {
		super(msg);
		this.status = status;
	}
	
	public int getStatus() {
		return status;
	}
	
}
