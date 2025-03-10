package testautomation;

import org.junit.AfterClass;
import org.junit.BeforeClass;
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
	

}
