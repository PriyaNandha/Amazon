package com.sdp.config.amazon;

import java.io.IOException;

public class AmazonConfigHelper {
	
	private AmazonConfigHelper() {
	
	}
	
	public static AmazonConfigReader getInstance() throws IOException {
		
		AmazonConfigReader amzreader = new AmazonConfigReader();
		
		return amzreader;
		
	}
	
	
}
