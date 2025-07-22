package testCases;
   
import org.testng.Assert; 
import org.testng.annotations.Test; 
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass; 

public class TC_001AccountRegistrationTest extends BaseClass {
	 
	@Test(groups={"Regression","Master"})
	void verify_Accoutnregistration()  
	{
		logger.info("--------Starting Test Case--------");
		
		try 
		{
		HomePage hp = new HomePage(driver); 
		hp.clickmyAccount();
		logger.info("Click My Account");
		
		hp.clickregister();
		logger.info("Click Register");
		
		AccountRegistrationPage rp = new AccountRegistrationPage(driver);
		
		logger.info("Providing details in Registration page");
		rp.setFirstName(randomString().toUpperCase());
		rp.setLastName(randomString().toUpperCase());
		rp.setEmail(randomString().toUpperCase()+"@gmail.com");
		rp.setTelephone(randomNumber());
		
		String pwd = randomAlphaNumber();
		rp.setPassword(pwd);
		rp.setConfirmPassword(pwd);
		
		rp.clickAagreeterms();
		rp.clickContinue();
		String confmsg = rp.getmsgconfitmation();
		
		logger.info("Validating the message");
		
			if (confmsg.equals("Your Account Has Been Created!"))
				{
					Assert.assertTrue(true);
				}
			else
				{
					logger.error("Test is failed");
					logger.debug("Debug Logs");
					Assert.assertTrue(false);
				} 
		}
		catch(Exception e)
		{
			logger.error("Test is failed");
			logger.debug("Test is failed");
			Assert.fail();
		}
		
		logger.info("-------Completed TC_001AccountRegistrationTest-------");
		
	}
	
	
}
