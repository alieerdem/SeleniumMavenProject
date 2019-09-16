package pageObject;

import org.openqa.selenium.By;

public class loginPageObjects {
	//Locators
	public static By usernameTxtBox = By.name("username");
	public static By passwordTxtBox = By.name("password");
	public static By loginButton = By.name("FormsButton2");
	public static By loginStatus = By.xpath("/html/body/table/tbody/tr/td[1]/big/blockquote/blockquote/font/center/b");
	
	//login informations
	public static String correctUsername = "testuser";
	public static String correctPassword = "testpass";
	public static String incorrectUsername = "testt";
	public static String incorrectPassword = "testt";
	
	//Login status
	public static String successful = "**Successful Login**";
	public static String failed = "**Failed Login**";
	
	//Alert messages on boundary tests
	public static String shortUsernameWarning = "Username too short.  The username must be at least 4 characters in length.";
	public static String shortPasswordWarning = "Password too short.  The password must be at least 4 characters in length.";

}
