package Academy.E2EProject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.Forgotpwd;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class HomePage extends base {

	public static Logger log = LogManager.getLogger(base.class.getName());

	
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	@Test(dataProvider="getData")
	public void basePageNavigation(String Username,String Password) throws IOException
	{
		driver.get(prop.getProperty("url"));
		//String text;
		LandingPage lp = new LandingPage(driver);
		LoginPage lg= lp.getLogin();
		lg.getEmail().sendKeys(Username);
		lg.password().sendKeys(Password);
		//System.out.println(text);
		log.info("test");

		lg.login().click();
		Forgotpwd fp = lg.forgtpwd();
		fp.getEmail().sendKeys("xxx");
		fp.sendmeinstructions().click();
		
		
		
	}
	
	@AfterTest
	public void teardown()
	{
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//row stands for how many different data types test should run
		Object[][] data = new Object[2][2];
		//0th row
		data[0][0]="nonrestricteduser";
		data[0][1]="123";
		//data[0][2]="Restricted user";
		//1st row
		data[1][0]="restricteduser";
		data[1][1]="123";
		//data[1][2]="Non-Restricted user";
		
		return data;
	}
}
