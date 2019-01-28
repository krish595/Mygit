package testCases;

import java.nio.file.Path;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import factory.BroserFactory;
import factory.DataProviderfactory;
import pages.CheckOutPage;
import pages.HomePage;
import pages.LoginPage;
import utility.Helper;

public class VerifyLoginPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void setUp()
	{
		
		report=new ExtentReports("./Reports/Loginreports/login.html",true);
		
		logger=report.startTest("verify login test");
        
		driver=BroserFactory.getBrowser("firefox");
		
		driver.get(DataProviderfactory.getConfig().getAppUrl());
		
		logger.log(LogStatus.INFO, "Application is Up and Runing");
	}
	
	@Test
	public void testHomepage()
	{
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
	     
		String title=home.getAppTitle();
	
	    System.out.println("aap title is   "+title);
		
	    Assert.assertTrue(title.contains("Demo Store"));
	    
	    logger.log(LogStatus.PASS, "Home Page loaded succesfully and verified");
	    
	    home.ClickLoginLink();
	   
	    logger.log(LogStatus.INFO, "Click on sigIn link");
	    
		LoginPage login=PageFactory.initElements(driver, LoginPage.class);

		
		login.loginApplication(DataProviderfactory.getExcel().getData(1, 0, 0),DataProviderfactory.getExcel().getData(1, 0, 1));
		
		logger.log(LogStatus.INFO, "login to the application");
		
		login.verifySignOutLink();
		
		logger.log(LogStatus.INFO
				,logger.addScreenCapture(Helper.captureScreenShot(driver, "validation1")));
		
		logger.log(LogStatus.PASS, "signout link present");
		
	}
	  @AfterMethod
	  public void exitDriver(ITestResult result)
	  { 
		  if(result.getStatus()==ITestResult.FAILURE)
		  {
		     String path	=  Helper.captureScreenShot(driver, result.getName());
			  
			  logger.log(LogStatus.FAIL,logger.addScreenCapture(path)); 
		  }
		BroserFactory.closeBrowser(driver);
		
		report.endTest(logger);
		report.flush();
		
	  }
	
	  

}
