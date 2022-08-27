package Assert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_Not_equal {
	@Test
	public void TC2() {
		Reporter.log("Running TC2",true);
		String expt="Nilaksha";
		String act="sanu";
		Assert.assertNotEquals(expt, act);
		
	}

}
