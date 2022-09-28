package com.pom.amazon;

import java.util.List;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class AmazonPom {
	
	public WebDriver driver = null;
	
	@FindBy(xpath = "//form[@id='nav-search-bar-form']//descendant::select[@id='searchDropdownBox']")
	private WebElement dropdown;

	public AmazonPom(WebDriver driver2) {
	this.driver= driver2;
	PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@type='text']")
	private WebElement text;
	
	@FindBy(xpath = "//div[@role='button']")
	private List<WebElement> toyList;
	
	@FindBy(xpath = "//span[contains(text(),'MORE RESULTS')]/ancestor::div[4]/preceding-sibling::div[@data-component-type='s-search-result']")
	private List<WebElement> results;
	
	@FindBy(xpath = "//span[contains(text(),'MORE RESULTS')]/ancestor::div[4]/following-sibling::div[@data-component-type='s-search-result']")
	private List<WebElement> moreResults;
	
	public List<WebElement> getMoreResults(){
		return moreResults;
	}
	
	public List<WebElement> getResults() {
		return results;
	}
	
	
	public WebElement getDropdown() {
		return dropdown;
	}
	public WebElement getText(){
		
		return text;
	}

	public List<WebElement> toyList() {
		
		return toyList;
	}
	

}
