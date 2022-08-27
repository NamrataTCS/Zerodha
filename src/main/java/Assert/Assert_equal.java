package Assert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_equal {
	@Test
	public void tc() {
		Reporter.log("Running tc",true);
		String act="Namrata";
		String expt="Namrata";
		Assert.assertEquals(act, expt);
	}

}
