package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

public class HomePage {
	
	WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(linkText="My Account")WebElement myaccountlink;
	@FindBy(linkText="Home")WebElement Homelink;
	@FindBy(linkText="Log In")WebElement Loginlink;
	

	public void ClickMyaccountLink()
	{
		myaccountlink.click();
	}
	
	public void ClickHomeLink()
	{
		Homelink.click();
	}
	public void ClickLoginLink()
	{
		Loginlink.click();
	}
	
	public String getAppTitle()
	
	{
	return	driver.getTitle();
	}
	
	
		
	
}
