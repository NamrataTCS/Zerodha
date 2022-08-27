package Assert;

import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_assert {
	@Test
	public void TC1() {
		Reporter.log("running tc1",true);
		String expt="Hii";
		String act="Hello";
		SoftAssert soft=new SoftAssert();
		soft.assertEquals(expt, act);
		System.out.println("I am after failed");
		soft.assertAll();// if we are not writing no value for program
		}
	 @Test
	public void TC2() {
		Reporter.log("running tc2",true);
	 }
}
