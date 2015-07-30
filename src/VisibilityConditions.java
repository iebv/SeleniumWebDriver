import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.*;

public class VisibilityConditions {
	
	private WebDriver driver;
	private String appUrl;
	
	@Before
	public void setUp() throws Exception {
		// objects and variables instantiation
		driver = new FirefoxDriver();
		appUrl = "https://google.com";
	}

	@Test
	public void test() throws Exception {
		// launch the firefox browser and open the application url
		driver.get(appUrl);

		// maximize the browser window
		driver.manage().window().maximize();

		// declare and initialize the variable to store the expected title of
		// the webpage.
		String expectedTitle = "Google";

		// fetch the title of the web page and save it into a string variable
		String actualTitle = driver.getTitle();

		// compare the expected title of the page with the actual title of the
		// page and print the result
		if (expectedTitle.equals(actualTitle)) {
			System.out
					.println("Verification Successful - The correct title is displayed on the web page.");
		} else {
			System.out
					.println("Verification Failed - An incorrect title is displayed on the web page.");
		}

		// verify if the “Google Search” button is displayed and print the
		// result
		boolean submitbuttonPresence = driver.findElement(
				By.cssSelector(".jhp input[type=" + "\"submit\"], .gbqfba"))
				.isDisplayed();
		System.out.println(submitbuttonPresence);

		// enter the keyword in the “Google Search” text box by which we would
		// want to make the request
		WebElement searchTextBox = driver.findElement(By.id("lst-ib"));
		searchTextBox.clear();
		searchTextBox.sendKeys("Selenium");

		// verify that the “Search button” is displayed and enabled
		boolean searchIconPresence = driver.findElement(By.name("btnG"))
				.isDisplayed();
		boolean searchIconEnabled = driver.findElement(By.name("btnG"))
				.isEnabled();

		if (searchIconPresence == true && searchIconEnabled == true) {
			// click on the search button
			WebElement searchIcon = driver.findElement(By.name("btnG"));
			searchIcon.click();
		}

		// close the web browser
		driver.close();
		Thread.sleep(1000);
		// driver.quit();
		// This is added instead to avoid the firefox 30 bug
		Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
		Thread.sleep(5000);
		Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
		Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
		
		System.out.println("Test script executed successfully.");

	}
}