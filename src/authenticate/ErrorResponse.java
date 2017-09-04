package authenticate;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "response")
public class ErrorResponse {
	private String code;
	private String error;
	private String error_description;
	
	@XmlElement
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	@XmlElement
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	@XmlElement
	public String getError_description() {
		return error_description;
	}
	public void setError_description(String error_description) {
		this.error_description = error_description;
	}
}
