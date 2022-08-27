package Method_Returntype;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.io.FileInputStream;

import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass_kite {
	WebDriver driver;
	KiteLogin1 login1;
	KiteLogin2 login2;
	KiteHome home;
	 Sheet sh;
	
	@BeforeClass
	public void browseropen() throws Throwable {
		FileInputStream file=new FileInputStream("C:\\Users\\namra\\Downloads\\zerodha.xlsx");
	    sh = WorkbookFactory.create(file).getSheet("zerodha");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://kite.zerodha.com/");
		Reporter.log("browser open",true);
		driver.manage().window().maximize();
		//create object of class
		 login1=new KiteLogin1(driver);
		 login2=new KiteLogin2(driver);
		 home=new KiteHome(driver);
		 
	}
	@BeforeMethod
	public void login() {
		
		String username = sh.getRow(0).getCell(0).getStringCellValue();
		String password = sh.getRow(0).getCell(1).getStringCellValue();

	    login1.enterUN(username);
	    login1.enterPWD(password);
	    login1.clickLOGIN();
	    String LoginPIN = sh.getRow(0).getCell(2).getStringCellValue();
	   login2.enterPIN(LoginPIN);
	    login2.clickCNT();
	   }
	@Test
	public void verifyUID() throws Throwable {
		Reporter.log("verify userid",true);
	   String expID = sh.getRow(0).getCell(3).getStringCellValue();
	 // home.checkID(expID);
	   String actID=home.verifyuserID();
	  Assert.assertEquals(actID, expID);
	   }
	@AfterMethod
	public void logoutApp() {
		Reporter.log("logout the application",true);
		
	}
	@AfterClass
	public void closebrowser() {
		home.click();
		home.logout();
		Reporter.log("browser closed",true);
		}
	

	    
} 
	    
	    
	    
	    
	


