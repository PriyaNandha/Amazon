package com.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.pom.amazon.AmazonPom;
import com.project.baseclass.amazon.BaseClass;
import com.project.datadriven.amazon.XLSXReader;
import com.runner.AmazonRunnerClass;
import com.sdp.config.amazon.AmazonConfigHelper;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends BaseClass {
	
	public static WebDriver driver = AmazonRunnerClass.driver;
	public static String value;
	public static String searchValue;
	AmazonPom ampom = new AmazonPom(driver);
	
	@Given("user Lauch The Application Url")
	public void user_lauch_the_application_url() throws IOException {
		String url = AmazonConfigHelper.getInstance().getUrl();
		System.out.println(url);
		launchUrl(url);
	}
	
	@When("user Click The Dropdown And Select The category")
	public void user_click_the_dropdown_and_select_the_category() throws InvalidFormatException, IOException {


		actions(ampom.getDropdown(), "move to element");

		value= XLSXReader.particularData("Project", 0, 1);
		
		selectListDropDownOption(ampom.getDropdown(), value);

	}
	
	@When("enter The Product In SearchBox And  Click The SearchIcon")
	public void enter_the_product_in_search_box_and_click_the_search_icon() throws InterruptedException, InvalidFormatException, IOException {
		
		searchValue = XLSXReader.particularData("Project", 0, 2);
		
		userInput(ampom.getText(), searchValue);
		

		sleep();
		for (WebElement searchToy : ampom.toyList()) {
			if (searchToy.getText().equalsIgnoreCase(searchValue)) {
				searchToy.click();
				break;
			}else {
				continue;
			}
		}
	}
	@When("user Count The Number Of Product Under Results")
	public void user_count_the_number_of_product_under_results() {
		System.out.println("Number of products under results: " + ampom.getResults().size());
	}
	@When("user Count The Number of Products Under More_Results")
	public void user_count_the_number_of_products_under_more_results() {
		System.out.println("number Of Products under More Results: " + ampom.getMoreResults().size());

	
	}
	@Then("close The Application Url")
	public void close_the_application_url() {
		
		BaseClass.browserClose();
	
	}









}
