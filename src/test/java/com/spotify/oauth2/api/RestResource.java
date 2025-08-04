package com.spotify.oauth2.api;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import com.spotify.oauth2.pojo.PlayList;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class RestResource {

	public static Response post(String path,String token,Object requestPlaylist) {
		return given(SpecBuilder.getReqeustSpec())
				.body(requestPlaylist)
				.auth().oauth2(token)
				//.header("Authorization","Bearer " + token)
				.when()
				.post(path)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	public static Response postAccount(HashMap<String, String> formParams) {
//		return given()
//				.baseUri("https://accounts.spotify.com")
//				.contentType(ContentType.URLENC)
//				.formParams(formParams)
//				.log().all()
//				.when().post("/api/token")
//				.then().spec(SpecBuilder.getResponseSpec())
//				.extract()
//				.response();
		return given(SpecBuilder.getAccountRequestSpec())
				.formParams(formParams)
				.when().post(Route.API+Route.TOKEN)
				.then().spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	


	public static Response get(String path,String token) {
		return	given(SpecBuilder.getReqeustSpec())
				.auth().oauth2(token)
				//.header("Authorization","Bearer " + token)
				.when().get(path)
				.then()
				.spec(SpecBuilder.getResponseSpec())
				.extract()
				.response();
	}
	
	public static Response update(String path,String token,Object requestPlaylist) {
		return given(SpecBuilder.getReqeustSpec())
				.auth().oauth2(token)
				//.header("Authorization","Bearer " + token)
		.body(requestPlaylist)
		.when()
		.put(path)
		.then().spec(SpecBuilder.getResponseSpec())
		.extract()
		.response();
		
	}


}
