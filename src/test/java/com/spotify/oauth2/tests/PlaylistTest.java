package com.spotify.oauth2.tests;

import org.testng.annotations.Test;

import com.spotify.oauth2.api.StatusCode;
import com.spotify.oauth2.api.applicationApi.PlaylistApi;
import com.spotify.oauth2.pojo.PlayList;
import com.spotify.oauth2.utils.DataLoader;
import com.spotify.oauth2.utils.FakerUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Link;
import io.qameta.allure.TmsLink;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;
import static io.restassured.RestAssured.*;
public class PlaylistTest extends BaseTest {
	RequestSpecification requestSpecification;
	ResponseSpecification responseSpecification;

	@Link("https://example.org")
    //@Link(name = "allure", type = "mylink")
    @TmsLink("12345")
    @Issue("1234567")
    @Description("this is the description")
	@Test(description = "should be able to create a playlist")
	public void testShouldBeAbleToCreateAPIPlayList() {
		PlayList requestPlaylist=new PlayList()
				//.setName("New Playlist For RestAssured")
				.setName(FakerUtils.generateName())
				//.setDescription("New playlist description for RestAssured")
				.setDescription(FakerUtils.generateDescription())
				.setPublic(false);
		Response response=PlaylistApi.post(requestPlaylist);
		//assertThat(response.statusCode(),equalTo(201));
		assertThat(response.statusCode(),equalTo(StatusCode.CODE_201.getCode()));
		PlayList responsePlayList=response.as(PlayList.class);
		
//		PlayList	responsePlayList=given(SpecBuilder.getReqeustSpec())
//				.body(requestPlaylist)
//				.when()
//				.post("/users/jebpmtc7essyoq2mi21mai4yj/playlists")
//				.then().spec(SpecBuilder.getResponseSpec())
//				.assertThat()
//				.statusCode(201)
//				.extract()
//				.response()
//				.as(PlayList.class);
		
		
		assertThat(responsePlayList.getName(),equalTo(requestPlaylist.getName()));
		assertThat(responsePlayList.getDescription(),equalTo(requestPlaylist.getDescription()));
		assertThat(responsePlayList.getPublic(),equalTo(requestPlaylist.getPublic()));
		

	}

	@Test()
	public void shouldbeAbleToGetCreatePlaylist() {
		PlayList requestPlayList=new PlayList()
				.setName("Updated Playlist Name")
				.setDescription("Updated playlist description")
				.setPublic(false);
	//Response response=PlaylistApi.get("1yqQkilG1C37BbwhkNb5wk");
		Response response=PlaylistApi.get(DataLoader.getInstance().getPlaylistId());
	//assertThat(response.statusCode(),equalTo(200));
		assertThat(response.statusCode(),equalTo(StatusCode.CODE_200.getCode()));
	PlayList responsePlayList=response.as(PlayList.class);
	
//	PlayList responsePlayList=	given(SpecBuilder.getReqeustSpec())
//	
//			
//		.when().get("/playlists/1yqQkilG1C37BbwhkNb5wk")
//		.then()
//		.spec(SpecBuilder.getResponseSpec())
//		.assertThat()
//		.statusCode(200)
//		.extract()
//		.response()
//		.as(PlayList.class);
//	   assertThat(responsePlayList.getName(),equalTo(requestPlayList.getName()));
//	   assertThat(responsePlayList.getDescription(),equalTo(requestPlayList.getDescription()));
//	   assertThat(responsePlayList.getPublic(),equalTo(requestPlayList.getPublic()));   
	
	}

	@Test()
	public void shouldAbleToUpdateApiPlayList() {
		PlayList requestPlayList=new PlayList()
//				.setName("Updated Playlist Name")
//				.setDescription("Updated playlist description")
				.setName(FakerUtils.generateName())
				.setDescription(FakerUtils.generateDescription())
				.setPublic(true);
		//Response response=PlaylistApi.update("1yqQkilG1C37BbwhkNb5wk", requestPlayList);
		Response response=PlaylistApi.update(DataLoader.getInstance().getUpdatePlaylistId(), requestPlayList);
		//assertThat(response.statusCode(),equalTo(200));
		assertThat(response.statusCode(),equalTo(StatusCode.CODE_200.getCode()));
		
//		given(SpecBuilder.getReqeustSpec())
//		.body(requestPlayList)
//		.when()
//		.put("/playlists/1yqQkilG1C37BbwhkNb5wk")
//		.then().spec(SpecBuilder.getResponseSpec())
//		.assertThat()
//		.statusCode(200);	
		
	}

	@Test()
	public void shouldNotbeAbletoCreateAPIPlaylistWithOutName() {
		
		PlayList requestPlayList=new PlayList()
				.setName("")
				//.setDescription("New playlist description for RestAssured")
				.setDescription(FakerUtils.generateDescription())
				.setPublic(true);
		Response response=PlaylistApi.post(requestPlayList);
		//assertThat(response.statusCode(),equalTo(400));
		assertThat(response.statusCode(),equalTo(StatusCode.CODE_400.getCode()));
  //com.spotify.oauth2.pojo.Error error=response.as(com.spotify.oauth2.pojo.Error.class);
				
//	Error error	=given(SpecBuilder.getReqeustSpec())
//		.body(requestPlayList)
//		.when()
//		.post("/users/jebpmtc7essyoq2mi21mai4yj/playlists")
//		.then().spec(SpecBuilder.getResponseSpec())
//		.assertThat()
//		.statusCode(400)
//		.extract()
//		.as(Error.class);
	//assertThat(error.getError().getStatus(),equalTo(400));
 // assertThat(response.statusCode(),equalTo(StatusCode.CODE_400.getCode()));
	//assertThat(error.getError().getMessage(),equalTo("Missing required field: name"));
  //assertThat(response.statusCode(),equalTo(StatusCode.CODE_400.getMsg()));
	
	}

	@Test()
	public void shouldNotbeAbleCreatePlayListWithExpiredToken() {
		String invalid_token="12345";
		PlayList requestPlayList=new PlayList()
				.setName(FakerUtils.generateName())
				//.setDescription("New playlist description for RestAssured")
				.setDescription(FakerUtils.generateDescription())
				.setPublic(false);
	Response response=PlaylistApi.post(invalid_token,requestPlayList);
	//assertThat(response.statusCode(),equalTo(401));
	assertThat(response.statusCode(),equalTo(StatusCode.CODE_401.getCode()));
	//com.spotify.oauth2.pojo.Error error=response.as(com.spotify.oauth2.pojo.Error.class);
	
	
		
//	Error error	=given()
//		.baseUri("https://api.spotify.com")
//		.basePath("/v1")
//		.header("Authorization","Bearer " + "12345")
//		.contentType(ContentType.JSON)
//		.log().all()
//		.body(requestPlayList)
//
//		.when()
//		.post("/users/jebpmtc7essyoq2mi21mai4yj/playlists")
//		.then().spec(SpecBuilder.getResponseSpec())
//		.assertThat()
//		.statusCode(401)
//		.extract()
//		.as(Error.class);
	
	//these validation is not working check with different concept
	//assertThat(error.getError().getStatus(),equalTo(401));
	//assertThat(response.statusCode(),equalTo(StatusCode.CODE_401.getCode()));
	//assertThat(error.getError().getMessage(),equalTo("Invalid access token"));
	//assertThat(response.statusCode(),equalTo(StatusCode.CODE_401.getMsg()));

	}


}
