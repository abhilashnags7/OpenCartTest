package testBase;
 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;//log4j
import org.apache.logging.log4j.Logger;   //log4j
 


public class BaseClass {
	
	public static WebDriver driver; 
	public Logger logger;
	public Properties p;
	
	@BeforeClass(groups = {"Sanity","Regression","Master","DataDriven"})
	@Parameters({"os","browser"} )
	public void setup(String os, String browser) throws IOException
	{ 
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p= new Properties();
		p.load(file);  


		logger=LogManager.getLogger(this.getClass());//Log4j
 
		switch(browser.toLowerCase())
		{
			case "chrome" : driver = new ChromeDriver();break;
			case "firefox" : driver = new FirefoxDriver();break;
			case "edge" : driver = new EdgeDriver();break;
			default : System.out.println("Invalid Browser");return;
		}
		 
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("appURL1"));
		driver.manage().window().maximize();
	}

	@AfterClass(groups = {"Sanity","Regression","Master","DataDriven"})
	public void teardown()
	{
		driver.quit();
	}
	
	public String randomString()
	{
		@SuppressWarnings("deprecation")
		String  alpstr =	RandomStringUtils.randomAlphabetic(5);
		return alpstr;
	}
	
	public String randomNumber()
	{
		@SuppressWarnings("deprecation")
		String  numstr =	RandomStringUtils.randomNumeric(10);
		return numstr;
	}
	
	public String randomAlphaNumber()
	{
		@SuppressWarnings("deprecation")
		String  alpstr =	RandomStringUtils.randomAlphabetic(3);
		String  numstr =	RandomStringUtils.randomNumeric(3);
		return (alpstr+"@"+numstr);
	}
	

	public String captureScreen(String tname) throws IOException {

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
		
		String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
		File targetFile=new File(targetFilePath);
		
		sourceFile.renameTo(targetFile);
			
		return targetFilePath;

	}

}
