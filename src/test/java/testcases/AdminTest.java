package testcases;

import org.testng.annotations.Test;

import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;
import pages.MyInfoPage;

import testbase.Base;
import testbase.TestBase;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;

public class AdminTest {
	
	private static final Logger logger = (Logger)LogManager.getLogger(AdminTest.class);
			
	private TestBase tb;
	private WebDriver dr;
	private LoginPage lp;
	private DashboardPage dp;
	private AdminPage ap;
	
	
	@Test(description =" Search User and Role", enabled =true )
	public void Verify_The_Admin_User_And_Role_In_Table_TC007() throws IOException, InterruptedException{
		
		boolean act = ap.verifyTheUser("chandra.rippin", "Admin");
		
		Assert.assertEquals(act, true);
		tb.attachScreenshot();
		
	}
	
	
	    @BeforeMethod
	    
	    public void beforeMethod() throws IOException{
	    	
	    	tb = new TestBase();
	    	dr = tb.getDriverInstance();
	    	lp = new LoginPage(dr);
	    	dp= new DashboardPage(dr);
	    	ap=	new AdminPage(dr);
	    	tb.attachScreenshot();
	    	logger.info("Login to application");
	    	lp.LoginToApplication("Admin", "admin123");
	    	
	    	Assert.assertEquals(dp.isUsernameDisplayed(), true);
	    	tb.attachScreenshot();
	    	logger.info("Dashboard Displayed");
			dp.clickOnAdmin();
			Assert.assertEquals(ap.isAdminPageDisplayed(), true);
			logger.info("Admin page displayed");
			tb.attachScreenshot();	    	
		
	}
	    
	    @AfterMethod
	    public void afterMethod() {
	  	  dp.logout();
	  	  dr.quit();
	    }

	    @BeforeTest(alwaysRun=true)
	    public void beforeTest()
	    {
	  	logger.info("Before Test"); 
	  	Reporter.log("Before Test"); 
	  	System.out.println("Before Test"); 
	    }
	    
	    @BeforeTest(alwaysRun=true)
	    public void afterTest()
	    {
	  	  logger.info("After Test");
	  	  Reporter.log("After Test"); 
	  	  System.out.println("After Test"); 
	    }
	
	
	
	
	
}
