package com.sdp.config.amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AmazonConfigReader {
	
	private Properties p;
	
	public AmazonConfigReader () throws IOException {
		
		File f = new File("C:\\Users\\GOD\\eclipse-workspace\\Amazon\\src\\main\\java\\com\\sdp\\config\\amazon\\Amazon.properties");
		
		FileInputStream fi = new FileInputStream(f);
		
		p = new Properties();
		
		p.load(fi);
		
	}
	
	public String getBrowser() {
		String browser = p.getProperty("browser");
		return browser;
		
	}

	public String getUrl() {
		String url = p.getProperty("url");
		return url;
	}

	public String getMovetoElement() {
		String movetoelement = p.getProperty("targetelement");
		return movetoelement;
	}
	
	
	

}
