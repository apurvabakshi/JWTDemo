package authenticate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class SuccessResponse {
	private String jwt_token;
	private String refresh_token;
	private String expires_in;
	
	@XmlElement
	public String getExpires_in() {
		return expires_in;
	}
	@XmlElement
	public String getJwt_token() {
		return jwt_token;
	}
	public void setJwt_token(String jwt_token) {
		this.jwt_token = jwt_token;
	}
	@XmlElement
	public String getRefresh_token() {
		return refresh_token;
	}
	public void setRefresh_token(String refresh_token) {
		this.refresh_token = refresh_token;
	}
	public void setExpires_in(String expires_in) {
		this.expires_in = expires_in;
	}


}
