package authenticate;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import jwttokenhandler.JWTTokenGenerate;
import jwttokenhandler.RefreshTokenGenerator;

@Path("/authenticate")

public class LoginService {
	//API for my SP
	@POST
	@Path("/user/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public SuccessResponse login(String data) throws JSONException {
		JSONObject creds = new JSONObject(data);
		SuccessResponse response = new SuccessResponse();
	
		if (creds.getString("uname").equalsIgnoreCase("admin")
				&& creds.getString("pass").equalsIgnoreCase("password")) {
			String JWT=JWTTokenGenerate.GenerateToken("123", "demoapp", "admin",  1200000);
			response.setJwt_token(JWT);
			response.setRefresh_token(RefreshTokenGenerator.GenerateRefreshToken());
			response.setExpires_in("1200");
			return response;
		} else {
			response.setJwt_token("null");
			return response;
		}
	}

	//API for zendesk
	@POST
	@Path("/authzen/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response loginZendesk(String data) throws JSONException, URISyntaxException, UnsupportedEncodingException {
		JSONObject creds = new JSONObject(data);
		//SuccessResponse response = new SuccessResponse();
	
		if (creds.getString("uname").equalsIgnoreCase("apurva")
				&& creds.getString("pass").equalsIgnoreCase("password")) {
			//generate jwt token for zendesk
			String JWT=JWTTokenGenerate.GenerateTokenZen();
			  java.net.URI location = new java.net.URI("https://gslab11.zendesk.com/access/jwt?jwt="+JWT+"&return_to=https://gslab11.zendesk.com");
			  return Response.seeOther(location).header("Access-Control-Allow-Origin", "*").build();
		} else {
			return null;
		}
	}

}
