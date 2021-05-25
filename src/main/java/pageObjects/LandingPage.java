package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	private By login = By.cssSelector("a[href*='sign_in']");
	private By course = By.cssSelector("a[href*='.com/courses']");
	private By navigation = By.cssSelector("body > app-root > div > header > div.header-upper > div > div > div.nav-outer.clearfix > nav > div.navbar-collapse.collapse.clearfix");
	
	public LandingPage(WebDriver driver) {
		
		this.driver= driver;
		// TODO Auto-generated constructor stub
	}

	public LoginPage getLogin()
	{
		driver.findElement(login).click();
		LoginPage lg = new LoginPage(driver);
		return lg;

	}
	
	public WebElement gettitle()
	{
		return driver.findElement(course);
	}
	
	public WebElement getnavigation()
	{
		System.out.println("trying to identify navigation bar");
		return driver.findElement(navigation);
	}
}
