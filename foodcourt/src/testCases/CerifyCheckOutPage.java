package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
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
import pages.LoginPage;
import utility.Helper;

public class CerifyCheckOutPage {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;
	
	@BeforeMethod
	public void checkO()
	{
		report=new ExtentReports("./Reports/myCartreports/myCart.html",true);
		
		logger=report.startTest("verify mycart");
        
		driver=BroserFactory.getBrowser("firefox");
		
		driver.get(DataProviderfactory.getConfig().getAppUrl());
		
		//logger.log(LogStatus.INFO, "Application is Up and Runing");
	
	
            LoginPage login=PageFactory.initElements(driver, LoginPage.class);
		   
			login.loginApplication(DataProviderfactory.getExcel().getData(1, 0, 0),DataProviderfactory.getExcel().getData(1, 0, 1));
		     
		
	
	}
	@Test
	public void testCheckoutPage()
	{
  
   CheckOutPage check=PageFactory.initElements(driver, CheckOutPage.class);
   
   
     check.verifyCheckOut();
     logger.log(LogStatus.INFO, "One product is selected");
     logger.log(LogStatus.INFO, "click on add to cart");
     logger.log(LogStatus.INFO, "product added to cart succesfully");
	
	logger.log(LogStatus.INFO,"mycart link is clicked");
	check.verifyCartLink();
	 logger.log(LogStatus.INFO, "product added to cart succesfully");
	logger.log(LogStatus.INFO, logger.addScreenCapture(Helper.captureScreenShot(driver, "checkOutpage")));
	
	logger.log(LogStatus.PASS, "continue shopping is presented");
	
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
