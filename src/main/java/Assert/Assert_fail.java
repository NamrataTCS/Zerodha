package Assert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_fail {
	@Test
	public void TC1() {
		Reporter.log("running tc1",true);
		Assert.fail();//verification 1
		
		System.out.println("i am after fail");//verification 2
	}
	@Test
	public void TC2() {
		Reporter.log("running tc2",true);
	
	}
}
