package factory;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BroserFactory {
	
	static WebDriver driver;
	
	public static WebDriver getBrowser(String BrowserName)
	{
		if(BrowserName.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", DataProviderfactory.getConfig().getChromePath());
			driver=new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver",DataProviderfactory.getConfig().getIEPath());
			driver=new InternetExplorerDriver();
		}
		
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
	}
	
	public static void closeBrowser(WebDriver ldriver)
	{
		ldriver.quit();
	}

}
