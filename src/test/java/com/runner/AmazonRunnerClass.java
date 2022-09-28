package com.runner;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.project.baseclass.amazon.BaseClass;
import com.sdp.config.amazon.AmazonConfigHelper;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src\\test\\java\\com\\feature\\Amazon.feature",
glue = "com.stepdefinition"

)


public class AmazonRunnerClass {
	public static WebDriver driver;
	
	@BeforeClass
	public static void setUp() throws IOException {
		String browser = AmazonConfigHelper.getInstance().getBrowser();
		driver = BaseClass.browserLaunch(browser);
		
	}
	@AfterClass
	public static void tearDown() {

		BaseClass.browserClose();
		
		
	}

}
//dryRun = true, tags = "@smoke", plugin = {"pretty",
//		"html:Report/HtmlReport1.html"
//		
//}, monochrome = true
