package com.spotify.oauth2.api;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecBuilder {
	//static String access_token="BQC7xG7uEPB4O7YjLnbPtlr_KFUEYCgVI3SL46yTtYJwQzjCY_mZObbhtinXxwsKOqs3dTbeXoUOyEWKhD489LSiB7590G9aA-CBRX2hJJiXGrK30M4URF_4CFhSx_948RPZGpRVHAEVuUqcPQ12xGdNToQuWWj9mLmC3wz7EjhydiPdjoZDc1JEaU7NZJ-HpRE1CraH8H7oMwT5cTy7YOH9IqQMfPA-5EDsCtSlh5IAtsaSN2VwumPWrqPTvZRBLyLJe4Q2vjA9Y1PBUbL0RRb9vOTQZG-H86xHo5Tpl_s9bOtV_z-jksMbWuwu7pNwpSMGnkXzWAHKoxnGF2w9fpRdQrwVP3aiNKQZc4dwXg";

	
	public static RequestSpecification getReqeustSpec() {
		return new RequestSpecBuilder()
				//.setBaseUri(System.getProperty("BASE_URI"))
				.setBaseUri("https://api.spotify.com")
				.setBasePath(Route.BASE_PATH)
				//.addHeader("Authorization","Bearer " + access_token)
				//.setContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				.build();
		
	}
	
	public static RequestSpecification getAccountRequestSpec() {
		return new RequestSpecBuilder()
				//.setBaseUri(System.getProperty("ACCOUNT_BASE_URI"))
				.setBaseUri("https://accounts.spotify.com")
				.setContentType(ContentType.URLENC)
				.log(LogDetail.ALL)
				.build();
		
	}
	
	
	
	public static ResponseSpecification getResponseSpec() {
	return new ResponseSpecBuilder()
				//.expectContentType(ContentType.JSON)
				.log(LogDetail.ALL)
				 .build();     
	}

}
