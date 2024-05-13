import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class test {
	private WebDriver driver;

	// Preconditions:
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(); // Open Chrome Browser
	}

	// Test
	@Test
	public void searchTest() {
		// TODO Auto-generated method stub

		driver.get("https://www.google.com/"); // Navigate to Google

		WebElement element = driver.findElement(By.name("q")); // find searchbox element
		element.sendKeys("Selenium Tutorials"); // Type the following word “Selenium Tutorials”

		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		element2.click(); // click on Google search button

		// Validate the title of the search results page.
		String title = driver.getTitle();
		System.out.println(title);
		Assert.assertTrue(title.contains("Selenium Tutorials"), "Failed testing");

		// Close the browser
		driver.quit();

	}

	// Post Condition:
	public void close() {
		// Close the browser
		driver.quit();

	}

}
