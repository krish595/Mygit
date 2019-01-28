package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.ExpectedExceptions;

public class LoginPage {
	
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	@FindBy(linkText="Log In")WebElement loginlink;
	@FindBy(id="account_sign_in_form_email_id")WebElement username;
	@FindBy(id="account_sign_in_form_passwd_id")WebElement password;
	
	
	@FindBy(id="send2")WebElement signInButton;
	By signuot=By.linkText("Log Out");
	
    
	public void loginApplication(String email,String pass)
	
	{
		loginlink.click();
		username.sendKeys(email);
		password.sendKeys(pass);
		signInButton.click();
		
	}
	
	public void verifySignOutLink()
	{
		WebDriverWait wait=new WebDriverWait(driver, 30);
		
		WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(signuot));
		
		String text=ele.getText();
		Assert.assertEquals(text,"Log Out","assert link is not verified properly");
	}
}
