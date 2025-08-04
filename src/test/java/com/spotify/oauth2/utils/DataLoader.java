package com.spotify.oauth2.utils;

import java.util.Properties;

public class DataLoader {
	private  final Properties properties; 
	private static DataLoader dataLoader;
	
	private  DataLoader() {
  properties=PropertyUtils.propertyLoader("D:\\TestNGPractice\\RestAssuredFramwork\\resources\\data.properties");
	}
	
	public static DataLoader getInstance() {
		if(dataLoader==null) {
			dataLoader=new DataLoader();
		}
		return dataLoader;
	}
	
	public String getPlaylistId() {
		String prop=properties.getProperty("get_playlist_id");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties get_playlist_id is not specified int the config.properites file");
	}
	
	public String getUpdatePlaylistId() {
		String prop=properties.getProperty("update_playlist_id");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties update_playlist_id is not specified int the config.properites file");
	}
	
}
