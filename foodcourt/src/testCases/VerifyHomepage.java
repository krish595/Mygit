package testCases;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import factory.BroserFactory;
import factory.DataProviderfactory;
import pages.HomePage;

public class VerifyHomepage {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
        driver=BroserFactory.getBrowser("firefox");
		
		driver.get(DataProviderfactory.getConfig().getAppUrl());
	}
	
	
	public void testHomepage()
	{
		
		
		HomePage home=PageFactory.initElements(driver, HomePage.class);
		
		String title=home.getAppTitle();
		
		System.out.println("aap title is   "+title);
		
		Assert.assertTrue(title.contains("Demo Store"));
		
		
	}
	  @AfterMethod
	  public void exitDriver()
	  {
		  
		BroserFactory.closeBrowser(driver);
		  }
}
