package jwttokenhandler;

import java.io.UnsupportedEncodingException;
import java.security.Key;
import java.util.Date;
import java.util.Random;
import java.util.TreeMap;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JWTTokenGenerate {

	public static void main(String args[]) {
		// String token=GenerateToken("123","https://demo.in","Apurva",5000);
		// System.out.println("Token is:"+token);
		// VerifyToken(token);
		// zen - sCvyCFjwMXj7DGygOz7nKqSoP0VFfNJsVZKBXRHJPjx03gcK
	}

	// Generates token for my SP
	public static String GenerateToken(String id, String issuer, String subject, long ttlMillis) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);

		byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary("secret");
		Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

		JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).setIssuer(issuer)
				.signWith(signatureAlgorithm, signingKey);

		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	// generates JWT for zendesk
	public static String GenerateTokenZen() throws UnsupportedEncodingException {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		Date now = new Date();
		Long longTime = new Long(now.getTime() / 1000);

		String SECRET = "sCvyCFjwMXj7DGygOz7nKqSoP0VFfNJsVZKBXRHJPjx03gcK";
		Random rand = new Random();
		int jti = rand.nextInt(14000) + 1;

		TreeMap<String, Object> myclaims = new TreeMap<String, Object>();
		myclaims.put("jti", jti);
		myclaims.put("name", "Apurva Bakshi");
		myclaims.put("email", "apurva.bakshi@gslab.com");
		myclaims.put("iat", longTime.intValue());
		JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT").setClaims(myclaims)
				.signWith(signatureAlgorithm, SECRET.getBytes("UTF-8"));
		System.out.println(builder.compact());
		return builder.compact();
	}

	// Verify is used only in the case of my SP
	public static boolean VerifyToken(String jwt) {

		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary("secret")).parseClaimsJws(jwt)
				.getBody();
		System.out.println("ID: " + claims.getId());
		System.out.println("Subject: " + claims.getSubject());
		System.out.println("Issuer: " + claims.getIssuer());
		System.out.println("Expiration: " + claims.getExpiration());
		if (claims.getSubject().equalsIgnoreCase("admin")) {
			return true;
		} else
			return false;

	}
}
