package com.project.baseclass.amazon;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {
	public static WebDriver driver;
	
	public static WebDriver browserLaunch(String browser) {

		if (browser.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");

			driver = new ChromeDriver();
			
		}else if (browser.equalsIgnoreCase("edge")) {

			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");

			driver = new EdgeDriver();
			
		}else {

			System.out.println("Invalid browser");
		}
		driver.manage().window().maximize();
		return driver;
	}

	public static void launchUrl(String element) {
		driver.get(element);
		
	}
	
	public static void implicitWait() {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
	}
	public static void userInput(WebElement element, String searchValue) {
		element.sendKeys(searchValue);
		
	}
	public static void actions(WebElement element, String options) {

		Actions a = new Actions(driver);
		if (options.equalsIgnoreCase("move to element")) {
			a.moveToElement(element).perform();
		} else if (options.equalsIgnoreCase("right click")) {
			a.contextClick(element).perform();
		} else if (options.equalsIgnoreCase("double click")) {
			a.doubleClick(element).perform();
		} else {
			System.out.println("invalid entry");
		}
	}
	
	public static void explicitWaitForElementVisibility(WebElement element) {

		WebDriverWait xwait = new WebDriverWait(driver, 50);
		xwait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void clickOnWebelement(WebElement element) {
		
		explicitWaitForElementVisibility(element);
//		if (elementIsEnabled(element) && elementIsDisplayed(element)) {
			
		element.click();
//		}
	}
	public static void selectDropDownOption(WebElement element, String option, String value) {

			explicitWaitForElementVisibility(element);
			Select s = new Select(element);
			if (option.equalsIgnoreCase("value")) {
				s.selectByValue(value);
			} else if (option.equalsIgnoreCase("visibletext")) {
				s.selectByVisibleText(value);
			} else if (option.equalsIgnoreCase("index")) {
				s.selectByIndex(Integer.parseInt(value));
			}
	}
	
	public static void selectListDropDownOption(WebElement element, String value) {

//		explicitWaitForElementVisibility(element);
		element.click();
		Select s = new Select(element);
		List<WebElement> options = s.getOptions();
		
		for (int i = 0; i < options.size(); i++) {

			String actualValue = options.get(i).getText();

			if (value.equalsIgnoreCase(actualValue)) {

				s.selectByVisibleText(value);
				
			}

		}
		
}
	
	public static void sleep() throws InterruptedException {
		Thread.sleep(5000);
	}
	
	public static void browserClose() {

		driver.quit();
	}
	
	public static void applicationClose() {
		driver.close();
		
	}
	

}
