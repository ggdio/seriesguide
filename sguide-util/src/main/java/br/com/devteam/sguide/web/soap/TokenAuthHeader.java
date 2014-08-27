package br.com.devteam.sguide.web.soap;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * Token authentication header
 * @author Guilherme Dio
 *
 */
@XmlRootElement(name=TokenAuthHeader.TAG_HEADER,namespace="http://api.unicorp.com.br/security")
@XmlAccessorType(XmlAccessType.FIELD)
public class TokenAuthHeader {
	
	@XmlTransient
	public static final String TAG_HEADER = "TokenAuth";
	@XmlTransient
	public static final String TAG_TOKEN = "token";

	@XmlElement(name=TokenAuthHeader.TAG_TOKEN,required=true,type=String.class)
	private String token;

	public TokenAuthHeader() {
		
	}

	public TokenAuthHeader(String token) {
		super();
		this.token = token;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
