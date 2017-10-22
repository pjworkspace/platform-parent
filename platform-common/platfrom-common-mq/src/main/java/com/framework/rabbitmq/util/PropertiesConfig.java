package com.framework.rabbitmq.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public enum PropertiesConfig {

    INSTANCE;

	  PropertiesConfig() {
		init();
	};

	private Properties pro = new Properties();

	private void init() {
		InputStream is = PropertiesConfig.class
				.getResourceAsStream("/rabbitmq.properties");
		if (is != null) {
			try {
				pro.load(is);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public String getProPerties(String key){
		return pro.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(PropertiesConfig.INSTANCE.pro);
	}
}
