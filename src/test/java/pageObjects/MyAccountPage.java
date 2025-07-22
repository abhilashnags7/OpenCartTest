package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage extends BasePage {
	 
	public  MyAccountPage(WebDriver driver)
	{
		super(driver);
	}


	By msg_Heading = By.xpath("//h2[text()='My Account']");
	By lnk_Logout = By.xpath("//div[@class='list-group']/a[text()='Logout']");
	
	public boolean checkmsgheadingexist()
	{
		try
			{
			return(driver.findElement(lnk_Logout).isDisplayed());
			}
		catch(Exception e)
			{
				return false;
			}
	}
	
	public void clickLogout()
	{
		driver.findElement(lnk_Logout).click();
	}
}
