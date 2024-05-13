package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class searchResultPage {
	WebDriver driver;

	By homePageUserName = By.xpath("//table//tr[@class='heading3']");

	public searchResultPage(WebDriver driver) {

		this.driver = driver;

	}

	// Get the title of page

	public String getSearchResultTiltle() {

		return driver.getTitle();

	}

}
