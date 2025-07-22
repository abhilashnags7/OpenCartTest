package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy (xpath = "//input[@placeholder='First Name']")
	WebElement txt_FirstName;
	@FindBy (xpath = "//input[@placeholder='Last Name']")
	WebElement txt_LastName;
	@FindBy (xpath = "//input[@placeholder='E-Mail']")
	WebElement txt_EMail;
	@FindBy (xpath = "//input[@placeholder='Telephone']")
	WebElement txt_Telephone;
	@FindBy (xpath = "//input[@placeholder='Password']")
	WebElement txt_Password;
	@FindBy (xpath = "//input[@placeholder='Password Confirm']")
	WebElement txt_confirmPassword;
	@FindBy (xpath = "//label[text()='No']")
	WebElement radbtn_No;
	@FindBy (xpath = "//input[@name='agree']")
	WebElement chk_agree;
	@FindBy (xpath = "//input[@value='Continue']")
	WebElement btn_Continue;
	
	@FindBy (xpath = "//h1[text()='Your Account Has Been Created!']")
	WebElement msgconfitmation;
	
	
	public void setFirstName(String firstname)
	{
		txt_FirstName.sendKeys(firstname);
	}
	
	public void setLastName(String lastname)
	{
		txt_LastName.sendKeys(lastname);
	}
	
	
	public void setEmail(String eMail)
	{
		txt_EMail.sendKeys(eMail);
	}
	
	
	public void setTelephone(String phonenumber)
	{
		txt_Telephone.sendKeys(phonenumber);
	}
	
	
	public void setPassword(String password)
	{
		txt_Password.sendKeys(password);
	}
	
	
	public void setConfirmPassword(String password)
	{
		txt_confirmPassword.sendKeys(password);
	}
	
	public void clickAagreeterms()
	{
		chk_agree.click();
	}
	
	public void clickContinue()
	{
		btn_Continue.click();
	}
	
	public String getmsgconfitmation()
	{
		try 
			{ 
				return (msgconfitmation.getText());
			}
		catch (Exception e)
			{
				return (e.getMessage());
			}
	}
}
