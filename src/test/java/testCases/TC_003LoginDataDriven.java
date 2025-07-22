package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

/*Data is valid  - login success - test pass  - logout
Data is valid -- login failed - test fail

Data is invalid - login success - test fail  - logout
Data is invalid -- login failed - test pass
*/

public class TC_003LoginDataDriven extends BaseClass{
	
	@Test(dataProvider="Logindata",dataProviderClass = DataProviders.class,groups= {"DataDriven","Master"})
	void Verifylogin_DataDriven(String email,String pwd, String exp)
	{
		logger.info("---test Started---");
		HomePage hp = new HomePage(driver);
		hp.clickmyAccount();
		hp.clicklogin();
		
		
		LoginPage lp = new LoginPage(driver);
		lp.setemail(email);
		lp.setpassword(pwd);
		lp.clickLogin();
		
		
		MyAccountPage acc = new MyAccountPage(driver);
		boolean trgaccpgmsg =acc.checkmsgheadingexist();
		
		if(exp.equalsIgnoreCase("valid"))
		{
			if(trgaccpgmsg==true)
			{
				Assert.assertTrue(true);
				acc.clickLogout();
			}
			else
			{
				Assert.assertTrue(false); 
			}
		}
		if(exp.equalsIgnoreCase("invalid"))
		{
			if(trgaccpgmsg==true)
			{
				acc.clickLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true); 
			}
		}
		
		logger.info("---test completed---");
	}
	 
}
