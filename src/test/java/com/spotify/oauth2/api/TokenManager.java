package com.spotify.oauth2.api;

import java.time.Instant;
import java.util.HashMap;

import com.spotify.oauth2.utils.ConfigLoader;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class TokenManager {
	private static String access_token;
	private static Instant expiry_time;
	
	public synchronized static String getToken() {
		try {
			//The token hasn’t been initialized yet (null) or 
			//The current time is after the expiry time → means the token is expired
			if(access_token==null || Instant.now().isAfter(expiry_time)) {
				System.out.println("Renewing the token.....");
				Response response=renewToken();
				access_token=response.path("access_token");
				int expiryDurationInSeconds=response.path("expires_in");
				expiry_time=Instant.now().plusSeconds(expiryDurationInSeconds - 300);
			}
			else {
				System.out.println("Token is good to use");
			}
		}
	    catch(Exception e) {
	    	throw new RuntimeException("ABORT!!! Failed to get Token");
	    }
		return access_token;
	}
	
	private static Response renewToken() {
		
		HashMap<String,String> formParams=new HashMap<String, String>();
//		formParams.put("client_id","9ce469e4ba5948348ad239c2dad1a996");
//		formParams.put("client_secret","0060c6db182d496399a5bd87d3627f73");
//		formParams.put("refresh_token","AQAmqekN-czcqCdnd-Ug8n0b0vNF23dxNAPhT6_PEvR-SSO9sJv6Ql019yelkpEY4X2zy6FI0966BPKKbBrcReJW9BvhNom5QzA6h_4rEiKoy607l8BIF7y04oSFN1wntVI");
//		formParams.put("grant_type","refresh_token");
//		
		formParams.put("client_id",ConfigLoader.getInstance().getClientId());
		
		formParams.put("client_secret",ConfigLoader.getInstance().getClientSecret());
		formParams.put("refresh_token",ConfigLoader.getInstance().getRefreshToken());
		formParams.put("grant_type",ConfigLoader.getInstance().getGrantType());
		
		
	
		Response response =RestResource.postAccount(formParams);
//	Response response	=given()
//			.baseUri("https://accounts.spotify.com")
//			.contentType(ContentType.URLENC)
//			.formParams(formParams)
//			.log().all()
//			.when().post("/api/token")
//			.then().spec(SpecBuilder.getResponseSpec())
//			.extract()
//			.response();
	
	if(response.statusCode()!=200) {
		throw new RuntimeException("ABORT!!! Renew Token Failed");
	}
	
	return response;
		
		
	}

}
