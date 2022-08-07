package testscripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_001 extends BaseTest {

    @Test
    public void TC_001(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyInvalidLogin("TC_001");
    }
}
