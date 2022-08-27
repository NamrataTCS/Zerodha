package TestNG_program;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestClass_kite {
	WebDriver driver;
	FileInputStream file;
	@BeforeClass
	public void browseropen() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://kite.zerodha.com/");
		Reporter.log("browser open",true);
	}
	@BeforeMethod
	public void login() throws Throwable {
		file=new FileInputStream("C:\\Users\\namra\\Downloads\\zerodha.xlsx");
	    Sheet sh = WorkbookFactory.create(file).getSheet("zerodha");
	    String username = sh.getRow(0).getCell(0).getStringCellValue();
	    String password = sh.getRow(0).getCell(1).getStringCellValue();
	    String LoginPIN = sh.getRow(0).getCell(2).getStringCellValue();
	    
	    KiteLogin1 home=new KiteLogin1(driver);
	    home.enterUN(username);
	    home.enterPWD(password);
	    Thread.sleep(3000);
	    home.clickLOGIN();
	    
	    KiteLogin2 home2=new KiteLogin2(driver);
	    home2.enterPIN(LoginPIN);
	    home2.clickCNT();
	    Thread.sleep(3000);
	    Reporter.log("login successful",true);
	}
	@Test
	public void verifyUID() throws Throwable {
		file=new FileInputStream("C:\\Users\\namra\\Downloads\\zerodha.xlsx");
	    Sheet sh = WorkbookFactory.create(file).getSheet("zerodha");
	   Sheet sh1 = WorkbookFactory.create(file).getSheet("zerodha");
	   String expID = sh1.getRow(0).getCell(3).getStringCellValue();
	   KiteHome login=new KiteHome(driver);
	   Thread.sleep(5000);
	   login.checkID(expID);
	   }
	@AfterMethod
	public void userLogout() {
		KiteHome logout=new KiteHome(driver);
		logout.clickUSER();
		logout.clickLogout();
		Reporter.log("User logout successfully",true);
	}
	@AfterClass
	public void closebrowser() {
		
		driver.quit();
		Reporter.log("browser closed",true);
		}
	

	    
} 
	    
	    
	    
	    
	


