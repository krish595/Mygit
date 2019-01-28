package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CheckOutPage {
	
	WebDriver driver;
	
	public CheckOutPage(WebDriver driver)
	{
		this.driver=driver;
	}
	@FindBy(xpath=".//*[@id='pt_custommenu']/div[2]/div[1]/a/span")WebElement pizza;
	@FindBy(xpath=".//*[@id='ProductForm_171']/a/img")WebElement item;
	@FindBy(xpath=".//*[@id='product_addtocart_form']/div[2]/div[6]/ul/li[1]/button")WebElement addtoCartBTN;
    @FindBy(className="top-link-cart")WebElement mycartLink;
    By continoueBtn=By.xpath(".//*[@id='shopping-cart-table']/tfoot/tr/td");


     public void verifyCheckOut(){
    	 pizza.click();
    	 item.click();
    	 addtoCartBTN.click();
    	 mycartLink.click();
     }

public void verifyCartLink()
{
	WebDriverWait wait=new WebDriverWait(driver, 30);
	
	WebElement ele=wait.until(ExpectedConditions.presenceOfElementLocated(continoueBtn));
	
	String text=ele.getText();
	Assert.assertEquals(text,"Continue Shopping","assert link is not verified properly");
}
}