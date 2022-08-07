package testscripts;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_002 extends BaseTest {

    @Test
    public void TC_002(){

        LoginPage lp = new LoginPage(driver);
        test = report.createTest("TC_002");
        lp.verifyValidLogin("TC_002");
        test.info("Page Title "+ driver.getTitle());
        test.info("CUrrent url "+ driver.getCurrentUrl());
    }


}
