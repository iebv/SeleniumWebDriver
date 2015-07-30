import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Gmail_Login {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// objects and variables instantiation
		WebDriver driver = new FirefoxDriver();
		String appUrl = "https://accounts.google.com";

		// launch the firefox browser and open the application url
		driver.get(appUrl);

		// maximize the browser window
		driver.manage().window().maximize();

		// declare and initialize the variable to store the expected title of
		// the webpage.
		String expectedTitle = " Sign in - Google Accounts ";

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

		// enter a valid username in the email textbox
		WebElement username = driver.findElement(By.id("Email"));
		username.clear();
		username.sendKeys("iebvidea");

		
		// click on the Sign in button
		WebElement NextButton = driver.findElement(By.id("next"));
		NextButton.click();
		
		//wait for next page to appear
		WebDriverWait myWait = new WebDriverWait(driver, 45);
	    ExpectedCondition<Boolean> conditionToCheck = new ExpectedCondition<Boolean>() {
	        @Override
	        public Boolean apply(WebDriver input) {
	            return (input.findElements(By.id("Passwd")).size() > 0);
	        }
	    };
	    myWait.until(conditionToCheck);
		
		// enter the password
		WebElement password = driver.findElement(By.id("Passwd"));
		password.clear();
		password.sendKeys("91060409442");
		
		//Click Sign in
		WebElement signInButton = driver.findElement(By.id("signIn"));
		signInButton.click();
		
		// close the web browser
		driver.close();
		System.out.println("Test script executed successfully.");

		// terminate the program
		System.exit(0);
	}
}