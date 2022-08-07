package testscripts;

import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_002 extends BaseTest {

    @Test
    public void TC_002(){

        LoginPage lp = new LoginPage(driver);
        lp.verifyValidLogin("TC_002");
    }
}
