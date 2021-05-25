package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Forgotpwd {

	public WebDriver driver;
	
	By email = By.cssSelector("input[type='email']");
	By sendmeinstructions = By.cssSelector("[type='submit']");
	
	
	public Forgotpwd(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement sendmeinstructions()
	{
		return driver.findElement(sendmeinstructions);
	}
	
}