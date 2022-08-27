package Assert;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class Assert_false {
@Test
public void TC1() {
	Reporter.log("running from tc1",true);
	boolean act=false;
	boolean expt=true;
	Assert.assertFalse(act);
	Assert.assertTrue(expt);
}
}
