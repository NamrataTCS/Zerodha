package TestNG_program;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Multibrowser1 {
	@Parameters("browsername")
	@Test
	public void TC(String browsername) {
		WebDriver driver=null;//rumtime polymorphism
		
		if(browsername.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if (browsername.equals("Firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}else if(browsername.equals("Microsoft Edge")) {
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		driver.get("https://kite.zerodha.com/");
		
	}
	
	
	
	

}
