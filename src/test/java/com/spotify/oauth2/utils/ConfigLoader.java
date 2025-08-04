package com.spotify.oauth2.utils;

import java.util.Properties;

public class ConfigLoader {
	private  final Properties properties; 
	private static ConfigLoader configLoader;
	
	private  ConfigLoader() {
		properties=PropertyUtils.propertyLoader("D:\\TestNGPractice\\RestAssuredFramwork\\resources\\config.properties");
	}
	
	public static ConfigLoader getInstance() {
		if(configLoader==null) {
			configLoader=new ConfigLoader();
		}
		return configLoader;
	}
	
	public String getClientId() {
		String prop=properties.getProperty("client_id");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties client_id is not specified int the config.properites file");
	}
	
	public String getClientSecret() {
		String prop=properties.getProperty("client_secret");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties client_secret is not specified int the config.properites file");
	}
	
	public String getGrantType() {
		String prop=properties.getProperty("grant_type");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties grant_type is not specified int the config.properites file");
	}
	
	public String getRefreshToken() {
		String prop=properties.getProperty("refresh_token");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties refresh_token is not specified int the config.properites file");
	}
	
	public String getUser() {
		String prop=properties.getProperty("user_id");
		if(prop!=null) return prop;
		else throw new RuntimeException("properties user_id is not specified int the config.properites file");
	}
	
}
