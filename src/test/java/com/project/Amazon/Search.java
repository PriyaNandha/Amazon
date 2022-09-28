package com.project.Amazon;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.project.datadriven.amazon.XLSXReader;


public class Search {

	public static WebDriver driver;
	public static JavascriptExecutor js;

	public static void sub_Method() throws InterruptedException, InvalidFormatException, IOException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\GOD\\eclipse-workspace\\MiniProject2\\Browser\\chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		WebElement dropdown = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

		Actions a = new Actions(driver);
		a.moveToElement(dropdown).perform();
		a.click().perform();

		Select opt1 = new Select(dropdown);
		List<WebElement> options = opt1.getOptions();
		
		String value= XLSXReader.particularData("Project", 0, 1);
		String searchValue = XLSXReader.particularData("Project", 0, 2);

		for (int i = 0; i < options.size(); i++) {

			String acutalValue = options.get(i).getText();

			if (value.equalsIgnoreCase(acutalValue)) {

				opt1.selectByVisibleText(value);
			}

		}

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(searchValue);

		Thread.sleep(5000);

		List<WebElement> toylist = driver.findElements(By.xpath("//div[@role='button']"));

		System.out.println(toylist.size());

		for (int i = 1; i <= toylist.size(); i++) {

			WebElement select = driver
					.findElement(By.xpath("//div[@class='autocomplete-results-container']/child::div[" + i + "]"));

//			String searchText = "soft toys";
			Thread.sleep(5000);
			if (select.getText().equalsIgnoreCase(searchValue)) {

				select.click();
				break;
				
			} else {
				continue;
			}
		}

		List<WebElement> results = driver.findElements(By.xpath(
				"//span[contains(text(),'MORE RESULTS')]/ancestor::div[4]/preceding-sibling::div[@data-component-type='s-search-result']"));
		System.out.println("Number of products under results: " + results.size());

		List<WebElement> moreResults = driver.findElements(By.xpath(
				"//span[contains(text(),'MORE RESULTS')]/ancestor::div[4]/following-sibling::div[@data-component-type='s-search-result']"));
		System.out.println("number Of Products under More Results: " + moreResults.size());


	}

	public static void main(String[] args) throws InterruptedException, InvalidFormatException, IOException {

		sub_Method();
	}

}
