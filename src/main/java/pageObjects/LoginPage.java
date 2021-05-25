package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	
	By email = By.cssSelector("input[type='email']");
	By password = By.id("user_password");
	By login = By.cssSelector("input[value='Log In']");
	By forgotpwd = By.cssSelector("a[href*='/new']");
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public Forgotpwd forgtpwd()
	{
		driver.findElement(forgotpwd).click();
		return new Forgotpwd(driver);
	}
	public WebElement password()
	{
		return driver.findElement(password);
	}
	
	public WebElement login()
	{
		return driver.findElement(login);
	}
}
