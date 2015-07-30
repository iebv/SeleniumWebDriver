
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIdeTest {
  private WebDriver driver;
  private String baseUrl;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://accounts.google.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test() throws Exception {
    driver.get(baseUrl);
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys("iebvidea");
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys("91060409442");
    driver.findElement(By.id("signIn")).click();
    driver.findElement(By.cssSelector("span.gb_d.gbii")).click();
    driver.findElement(By.id("gb_71")).click();
  }

  @After
  public void tearDown() throws Exception {
	driver.close();
	Thread.sleep(1000);
    //driver.quit();
	//This is added instead to avoid the firefox 30 bug
	Runtime.getRuntime().exec("taskkill /F /IM firefox.exe");
	Thread.sleep(5000);
	Runtime.getRuntime().exec("taskkill /F /IM plugin-container.exe");
	Runtime.getRuntime().exec("taskkill /F /IM WerFault.exe");
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }


}
