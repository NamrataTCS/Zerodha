package TestNG_program;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class KiteLogin2 {
	@FindBy(xpath="//input[@id='pin']")private WebElement PIN;
	@FindBy(xpath="//button[@class='button-orange wide']")private WebElement CNT;
	public KiteLogin2(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void enterPIN(String LoginPIN) {
		PIN.sendKeys(LoginPIN);
	}
	public void clickCNT() {
		CNT.click();
	}

}
