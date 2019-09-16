package testautomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class TestBase  {
	
	static WebDriver driver;
	static String baseUrl = "http://thedemosite.co.uk";

	@BeforeClass
	public static void setupApplication()
	{
		Reporter.log("----BROWSER SESSION START----", true);
		
        System.setProperty("webdriver.chrome.driver",".\\Driver\\chromedriver.exe");
		driver=new ChromeDriver();
	    driver.manage().window().maximize();
		driver.navigate().to(baseUrl + "/login.php");
		
		Reporter.log("----Application Start----", true);

	}
	
	@AfterClass
	public static void closeApplication()
	{
		driver.quit();
		Reporter.log("----BROWSER SESSION END----", true);
	}
	
	//Locators
	public By usernameTxtBox = By.name("username");
	public By passwordTxtBox = By.name("password");
	public By loginButton = By.name("FormsButton2");
	public By loginStatus = By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b");
	
	//login informations
	public String correctUsername = "testuser";
	public String correctPassword = "testpass";
	public String incorrectUsername = "testt";
	public String incorrectPassword = "testt";
	
	//Login status
	public String successful = "**Successful Login**";
	public String failed = "**Failed Login**";
	
	//Alert messages on boundary tests
	public String shortUsernameWarning = "Username too short.  The username must be at least 4 characters in length.";
	public String shortPasswordWarning = "Password too short.  The password must be at least 4 characters in length.";
}
