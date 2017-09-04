package resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import jwttokenhandler.JWTTokenGenerate;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;

@Path("/UserService")

public class UserServices {

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "Hello";
	}

	@GET
	@Path("/users")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getUsers(@Context HttpHeaders headers) {
		String Auth = headers.getRequestHeader("Authorization").get(0);
		String token[]=Auth.split(" ");
		if (JWTTokenGenerate.VerifyToken(token[1])) {
			List<User> ulist = new ArrayList<>();
			ulist.add(new User(201, "Aniket", "Developer", "9098786789"));
			ulist.add(new User(202, "Madan", "Manager", "7898054378"));
			ulist.add(new User(203, "Anuja", "Documenter", "8976567033"));
			ulist.add(new User(204, "Sahil", "QA", "9987889067"));
			return ulist;
		}
		return null;
	}

	@GET
	@Path("/contactdetails")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> getContactDetails(@Context HttpHeaders headers) {
		String Auth = headers.getRequestHeader("Authorization").get(0);
		String token[]=Auth.split(" ");
		if (JWTTokenGenerate.VerifyToken(token[1])) {
			List<User> ulist = new ArrayList<>();
			ulist.add(new User(201, "Aniket", "Developer", "9098786789"));
			ulist.add(new User(202, "Madan", "Manager", "7898054378"));
			ulist.add(new User(203, "Anuja", "Documenter", "8976567033"));
			ulist.add(new User(204, "Sahil", "QA", "9987889067"));
			return ulist;
		}
		return null;
	}
}
