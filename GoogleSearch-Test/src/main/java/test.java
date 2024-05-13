import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver;
		driver = new ChromeDriver(); // Open Chrome Browser
		driver.get("https://www.google.com/"); // Navigate to Google

		WebElement element = driver.findElement(By.name("q")); // find searchbox element
		element.sendKeys("Selenium Tutorials"); // Type the following word “Selenium Tutorials”

		WebDriverWait wait = new WebDriverWait(driver, 10); // Wait up to 10 seconds
		WebElement element2 = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		element2.click(); // click on Google search button

		// Validate the title of the search results page.
		String title = driver.getTitle();
		System.out.println(title);
		if (title.contains("Selenium Tutorials")) {
			System.out.println("Title of the search results page contains Selenium Tutorials");
		} else {
			System.out.println("Title of the search results page does not contain Selenium Tutorials");
		}

		// Close the browser
		driver.quit();

	}

}
