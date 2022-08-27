package Assert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_true {
	@Test
	public void TC1() {
		Reporter.log("running frome tc1",true);
		boolean act=true;
		Assert.assertTrue(act);
	}

}
