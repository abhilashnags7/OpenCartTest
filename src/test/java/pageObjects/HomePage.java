package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy; 

public class HomePage extends BasePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	//Locators
	@FindBy (xpath = "//a[text()='Qafox.com']") 
	WebElement mylogo;
	@FindBy (xpath = "//span[text()='My Account']") 
	WebElement my_Account;
	@FindBy (xpath = "//a[text()='Register']") 
	WebElement linkregister;
	@FindBy (xpath = "//a[text()='Login']") 
	WebElement linklogin;
	
//	By mylogo = By.xpath("//a[text()='Qafox.com']");
	
	//Actions
	public void mylogo()
	{
		//driver.findElement(mylogo);
		mylogo.isDisplayed();
	}
	public void clickmyAccount()
	{
		my_Account.click();
	}

	public void clickregister()
	{
		linkregister.click();
	}

	public void clicklogin()
	{
		linklogin.click();
	}


}
