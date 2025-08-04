package com.spotify.oauth2.api.applicationApi;

import com.spotify.oauth2.api.RestResource;
import com.spotify.oauth2.api.Route;
import com.spotify.oauth2.api.TokenManager;
import com.spotify.oauth2.pojo.PlayList;
import com.spotify.oauth2.utils.ConfigLoader;

import io.restassured.response.Response;

public class PlaylistApi {
	//static String access_token="BQDMWXIwGTFv3krty0Z5q1zKrnKBrTSoLpSyGC6UdUOFfC_zrEzcXKRq1NC99YrJ0k1b-BbuPqXy4-VqgV0zJqUkN7NXH3ClOX_m1tuWN3FDaagGLc6BZ1YYx7uhi4ytjlveO_CERL_3E3j1oI6rkM-itIuYo-_AlNJDN57HOm79nG6UPbEY-Fn3ZEjGgvxW7JLf8XgvZt0hSb7-PlHH9elbSzjYvRkq2lLMgclmZXvRfu4kv7G9xQ8-esVACrL03pPLPpL24p4v0jtLjHgrnPIaMfHM2q93wrIyOU2XVINb35DVcTtb";


	public static Response post(PlayList requestPlaylist) {
		//return RestResource.post(Route.USERS+"/jebpmtc7essyoq2mi21mai4yj"+ Route.PLAYLISTS,TokenManager.getToken(), requestPlaylist);
		return RestResource.post(Route.USERS+"/"+ ConfigLoader.getInstance().getUser()+Route.PLAYLISTS,TokenManager.getToken(), requestPlaylist);

//		return given(SpecBuilder.getReqeustSpec())
//				.body(requestPlaylist)
//				.header("Authorization","Bearer " + access_token)
//				.when()
//				.post("/users/jebpmtc7essyoq2mi21mai4yj/playlists")
//				.then().spec(SpecBuilder.getResponseSpec())
//				.extract()
//				.response();
	}
	
	public static Response post(String token,PlayList requestPlaylist) {

		//return RestResource.post(Route.USERS+"/jebpmtc7essyoq2mi21mai4yj"+ Route.PLAYLISTS, token, requestPlaylist);
		return RestResource.post(Route.USERS+"/"+ ConfigLoader.getInstance().getUser()+Route.PLAYLISTS, token, requestPlaylist);
//		return given(SpecBuilder.getReqeustSpec())
//				.body(requestPlaylist)
//				.header("Authorization","Bearer " + token)
//				.when()
//				.post("/users/jebpmtc7essyoq2mi21mai4yj/playlists")
//				.then().spec(SpecBuilder.getResponseSpec())
//
//				.extract()
//				.response();

	}

	public static Response get(String playlistId) {
		return RestResource.get(Route.PLAYLISTS+"/" + playlistId,TokenManager.getToken());
//		return	given(SpecBuilder.getReqeustSpec())
//				.header("Authorization","Bearer " + access_token)
//				.when().get("/playlists/" + playlistId)
//				.then()
//				.spec(SpecBuilder.getResponseSpec())
//				.extract()
//				.response();
	}
	
	public static Response update(String playlistId,PlayList requestPlaylist) {
		return RestResource.update(Route.PLAYLISTS+"/" + playlistId,TokenManager.getToken(),requestPlaylist);
//		return given(SpecBuilder.getReqeustSpec())
//				.header("Authorization","Bearer " + access_token)
//		.body(requestPlaylist)
//		.when()
//		.put("/playlists/" + playlistId)
//		.then().spec(SpecBuilder.getResponseSpec())
//		.extract()
//		.response();
		
	}



}
