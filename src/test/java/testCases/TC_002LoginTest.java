package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;


public class TC_002LoginTest extends BaseClass{

	@Test(groups={"Sanity","Master"})
	void Verifylogin()
	{
		try {
		logger.info("---test Started---");
		 
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		hp.clicklogin();
		LoginPage lp = new LoginPage(driver);
		lp.setemail(p.getProperty("email"));
		lp.setpassword(p.getProperty("password"));
		lp.clickLogin();
		MyAccountPage acc = new MyAccountPage(driver);
		Assert.assertTrue(acc.checkmsgheadingexist());
		
		logger.info("---test Completed---");
		
		acc.clickLogout();
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}
	
}
