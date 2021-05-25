package Academy.E2EProject;

import java.io.IOException;
//import java.util.logging.Logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;
//this is a test codes

public class ValidateTitle extends base {

	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	@Test
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		log.info("driver is initialised");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to home page");

	}
	
	public void basePageNavigation() throws IOException
	{
		//String text;
		LandingPage lp = new LandingPage(driver);
		String co = lp.gettitle().getText();
		System.out.println(co);
		
		log.info("successfully validated text message");

		}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
}

