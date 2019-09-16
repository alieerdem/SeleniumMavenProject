package testautomation;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.loginPageObjects;

import static org.junit.Assert.assertEquals;

public class Login extends TestBase {
	
	@Test
	public void LoginFail1()
	{
		//Enter incorrect username and correct password
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.incorrectUsername);
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.correctPassword);
		driver.findElement(loginPageObjects.loginButton).click();
		
		String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
			
		assertEquals(loginPageObjects.failed, loginStatusText);
	}
	
	@Test
	public void LoginFail2()
	{
		//Enter correct username and incorrect password
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.correctUsername);
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.incorrectPassword);
		driver.findElement(loginPageObjects.loginButton).click();
		
		String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
		
		
		assertEquals(loginPageObjects.failed, loginStatusText);
	}
	
	@Test
	public void SuccessfulLogin() throws InterruptedException
	{
		//Enter correct username and correct password
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.correctUsername);
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.correctPassword);
		driver.findElement(loginPageObjects.loginButton).click();
				
        WebDriverWait wait = new WebDriverWait(driver, 3);
        wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(loginPageObjects.loginStatus), loginPageObjects.successful));
		
		String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
        assertEquals(loginPageObjects.successful, loginStatusText);
	}
	
	@Test
	public void BoundaryTestForUsername1()
	{
		//Enter 3 characters on username field.
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys("abc");
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.incorrectPassword);
		driver.findElement(loginPageObjects.loginButton).click();
		
		
		if (isAlertPresent())
		{
			String alertText = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			assertEquals(alertText, loginPageObjects.shortUsernameWarning);
		}
		else
	         System.out.println("Alert didn't show up!");
	}
	
	@Test
	public void BoundaryTestForUsername2()
	{
		//Enter 4 characters on username field.
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys("abcd");
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.incorrectPassword);
		driver.findElement(loginPageObjects.loginButton).click();
		
		if (!isAlertPresent())
		{
			String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
			assertEquals(loginStatusText, loginPageObjects.failed);
		}
		else
	         System.out.println("Alert showed up!");
	}
	
	@Test
	public void BoundaryTestForUsername3()
	{
		//Enter 16 characters on username field.
		for(int i=1; i<=16; i++)
		{
			driver.findElement(loginPageObjects.usernameTxtBox).sendKeys("a");
		}
		
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(loginPageObjects.incorrectPassword);
		driver.findElement(loginPageObjects.loginButton).click();
		
		if (!isAlertPresent())
		{
			String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
			assertEquals(loginStatusText, loginPageObjects.failed);
		}
		else
	         System.out.println("Alert showed up!");
	}
	
	@Test
	public void BoundaryTestForUsername4()
	{
		//Try to enter 17 characters on username field.
		
		String character="a";
		for(int i=1; i<=17; i++)
		{
			driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(character);
		}
			
		int length = driver.findElement(loginPageObjects.usernameTxtBox).getText().length();
		assertEquals(16, length);
	}
	
	@Test
	public void BoundaryTestForPassword1()
	{
		//Enter 3 characters on password field.
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.incorrectUsername);
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys("abc");
		driver.findElement(loginPageObjects.loginButton).click();
		
		
		if (isAlertPresent())
		{
			String alertText = driver.switchTo().alert().getText();
			driver.switchTo().alert().accept();
			assertEquals(alertText, loginPageObjects.shortPasswordWarning);
		}
		else
	         System.out.println("Alert didn't show up!");
	}
	
	@Test
	public void BoundaryTestForPassword2()
	{
		//Enter 4 characters on password field.
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.incorrectUsername);
		driver.findElement(loginPageObjects.passwordTxtBox).sendKeys("abcd");
		driver.findElement(loginPageObjects.loginButton).click();
		
		if (!isAlertPresent())
		{
			String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
			assertEquals(loginStatusText, loginPageObjects.failed);
		}
		else
	         System.out.println("Alert showed up!");
	}
	
	@Test
	public void BoundaryTestForPassword3()
	{
		//Enter 8 characters on password field.
		driver.findElement(loginPageObjects.usernameTxtBox).sendKeys(loginPageObjects.incorrectUsername);

		String character="a";
		for(int i=1; i<9; i++)
		{
			driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(character);
		}
		
		driver.findElement(loginPageObjects.loginButton).click();
		
		if (!isAlertPresent())
		{
			String loginStatusText = driver.findElement(loginPageObjects.loginStatus).getText();
			assertEquals(loginStatusText, loginPageObjects.failed);
		}
		else
	         System.out.println("Alert showed up!");
	}
	
	@Test
	public void BoundaryTestForPassword4()
	{
		//Try to enter 9 characters on password field.
		
		String character="a";
		for(int i=1; i<=9; i++)
		{
			driver.findElement(loginPageObjects.passwordTxtBox).sendKeys(character);
		}
				
		int length = driver.findElement(By.name("password")).getText().length();
		assertEquals(8, length);
	}
	
	//Check if an alert is presented for boundry value analysis
	public boolean isAlertPresent()
	{
	    try
	    {
	        WebDriverWait wait = new WebDriverWait(driver, 2);
	        wait.until(ExpectedConditions.alertIsPresent());
	        driver.switchTo().alert();
	        return true;
	    }
	    
	    catch (Exception e)
	    {
	        return false;
	    }
	}

	
}
