package testcases;

import  org.testng.annotations.Test;
import pages.DashboardPage;
import pages.ForgotPasswordPage;
import pages.LoginPage;
import testbase.Base;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import java.io.IOException;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class LoginTest {
	
	
	private static final Logger logger = (Logger)LogManager.getLogger(LoginTest.class);
	private WebDriver dr;
	private TestBase tb;
	private LoginPage lp;
	private DashboardPage dp;
	private ForgotPasswordPage fgp;
	
	
  @Test(priority =1, description = "Login successful with valid credentials", groups = "Sanity")
  public void Verify_Login_Successful_TC001() throws IOException {
	  
	  tb.attachScreenshot();
	  lp.LoginToApplication("Admin", "admin123");
	  boolean act = dp.isUsernameDisplayed();
	  tb.attachScreenshot();
	  logger.info("Actual"+ act+ "-->Expected"+ true);
	  Assert.assertEquals(act, true);
	  dp.logout();
	  Assert.assertEquals(isLogoutSuccessful(), true);
	  tb.attachScreenshot();  
	  
  }


  
	  @Test(priority = 2,description = "verify unsuccessful credentials")
	  public void Verify_Login_Unsuccessful_Wrong_Credentials_TC002() throws IOException {
		  
		      tb.attachScreenshot();
		      lp.LoginToApplication("Admin", "admin1234");
		      boolean act = lp.isErrorDisplayed();
		      tb.attachScreenshot();
		      logger.info("Actual"+ act+ "-->Expected"+ true);
			  Assert.assertEquals(act, true);
		        
	  }
	  
	  /*@Test(priority=3,description="Verify Cancel feature in Reset Password",groups="Sanity")
		public void Verify_Forgot_Password_Cancel_TC004() throws IOException
		{
			lp.clickOnForgotPassword();
			tb.attachScreenshot();
			boolean d = fgp.isForgotPasswordPageDisplayed();
			Assert.assertEquals(d, true);
			tb.attachScreenshot();
			fgp.enterUsername("Admin");
			fgp.clickOnCancelButton();
			boolean act = lp.isLoginPageDisplayed();
			tb.attachScreenshot();
			Assert.assertEquals(act, true);
			
		}*/
	
	
	private Boolean isLogoutSuccessful() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	@BeforeMethod(alwaysRun=true)
	public void beforeMethod() throws IOException {
		logger.info("Before Method");
		tb = new TestBase();
		dr = tb.getDriverInstance();
		lp = new LoginPage(dr);
		dp = new DashboardPage(dr);
		fgp = new ForgotPasswordPage(dr);

	}

	@AfterMethod(alwaysRun=true)
	public void afterMethod() {
		logger.info("After Method");
		dr.quit();
	}


}

