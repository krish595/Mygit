

package utility;

import java.io.File;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;



public class Helper {
	
	public static String captureScreenShot(WebDriver driver,String screenShotName)
	{
		TakesScreenshot ts=(TakesScreenshot)driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		String destination="E:\\krish mem\\java progroms\\foodcourt\\ScreenShots\\"+screenShotName+System.currentTimeMillis()+".png";
		
		try
		{
		FileUtils.copyFile(src, new File(destination));
		}catch(Exception e)
		{
			System.out.println(" failed to take screenshot" +e.getMessage());
			
		}
		return destination;
	}
	
	

}
