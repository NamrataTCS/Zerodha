package Method_Returntype;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class KiteHome {
	@FindBy(xpath="//span[@class='user-id']")private WebElement ID;
	@FindBy(xpath="//span[text()='DPG458']")private WebElement CLICKUSER;
	@FindBy(xpath="//ul[@class='list-flat dropdown-nav-list']//li/a")private List<WebElement> LIST;
	
	public KiteHome(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyuserID() {
		String actID=ID.getText();
		Reporter.log(actID);
		return actID;
		
		}
	public void click() {
		CLICKUSER.click();
	}
	public void logout() {
		for(WebElement alloption:LIST) {
			String text=alloption.getText();
			if(text.contains("Logout")) {
				alloption.click();
			}
		}
		
	}
	
	
	}
		
		
	



