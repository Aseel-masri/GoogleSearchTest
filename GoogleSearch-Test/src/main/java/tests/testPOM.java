package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.google;
import pages.searchResultPage;

public class testPOM {
	private WebDriver driver;
	private google objGoogle;
	private searchResultPage objSearchResult;

	// Preconditions:
	@BeforeTest
	public void setUp() {
		driver = new ChromeDriver(); // Open Chrome Browser
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	// Test
	@Test
	public void searchTest() {
		// TODO Auto-generated method stub

		driver.get("https://www.google.com/"); // Navigate to Google

		// Create Google Page object
		objGoogle = new google(driver);
		// Verify Google page title

		String googlePageTitle = objGoogle.getGoogleTitle();

		Assert.assertTrue(googlePageTitle.toLowerCase().contains("google"));

		objGoogle.searchOperation("Selenium Tutorials"); // Type the following word “Selenium Tutorials”

		// go the next page

		objSearchResult = new searchResultPage(driver);

		// Validate the title of the search results page.

		Assert.assertTrue(objSearchResult.getSearchResultTiltle().toLowerCase().contains("selenium tutorials"));

	}

	// Post Condition:
	@AfterTest
	public void close() {
		// Close the browser
		driver.quit();

	}

}
