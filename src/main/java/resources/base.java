package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class base {

	public Properties prop; 
	public WebDriver driver;
	public WebDriver initializeDriver() throws IOException
	{
	
		prop = new Properties();
		FileInputStream fis = new FileInputStream("src/main/java/resources/data.properties");
		
		prop.load(fis);
		//mvn test -Dbrowser=chrome

		String browserName = System.getProperty("browser");
		 //= prop.getProperty("browser");
		if(browserName.equals("chrome"))
		{
			//System.setProperty("webdriver.chrome.driver","E:\\chromedriver.exe" );
			WebDriverManager.chromedriver().setup();
		    driver = new ChromeDriver();
			
		}
		
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver","E:\\geckodriver.exe" );
			//WebDriver driver = new GeckoDriver();	
		}
		
		if(browserName.equals("IE"))
		{
			//execute in IE
		}
		
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		return driver;
	}
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\"+ testCaseName+".png";
		FileUtils.copyFile(source,new File(destinationFile));
		return destinationFile;
	}

}
