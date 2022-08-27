package TestNG_program;


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
	
	public void checkID(String exptID) {
		String actID=ID.getText();
		Reporter.log(actID);
		if(actID.equals(exptID)) {
			System.out.println("TC is pass");
		}else {
			System.out.println("TC is fail");
		}
		}
	public void clickUSER() {
		CLICKUSER.click();
	}
	public void clickLogout() {
		for(WebElement ele:LIST) {
			if(ele.getAttribute("innerHTML").contains("Logout")) {
				ele.click();
			}
		}
	}
		
		
	}



