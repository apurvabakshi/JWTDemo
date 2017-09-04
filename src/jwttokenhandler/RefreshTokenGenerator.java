package jwttokenhandler;

import java.util.UUID;

public class RefreshTokenGenerator {

	public static String GenerateRefreshToken(){
		 String uuid = UUID.randomUUID().toString();
		 return "00000";
	}
	
	public boolean ValidateRefreshToken(String token){
		if(token.equalsIgnoreCase("00000")){
			return true;
		}
		return false;
	}
}
