package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
	
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	By lnk_editaccount = By.xpath("//a[text()='Edit your account information']");
	By txt_email = By.xpath("//input[@id='input-email']");
	By txt_password = By.xpath("//input[@id='input-password']");
	By btn_login = By.xpath("//input[@value='Login']");
	
	
	public void clickeditaccount()
	{
		driver.findElement(lnk_editaccount).isDisplayed();
	}
	
	public void setemail(String uemail)
	{
		driver.findElement(txt_email).sendKeys(uemail);
	}
	
	public void setpassword(String pwd)
	{
		driver.findElement(txt_password).sendKeys(pwd);;
	}

	public void clickLogin()
	{
		driver.findElement(btn_login).click();
	}
	


}
