package testscripts;

import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TC_001 extends BaseTest {

    @Test
    public void TC_001(){

        LoginPage lp = new LoginPage(driver);
        test = report.createTest("TC_001");
        test.info("Page Title "+ driver.getTitle());
        lp.verifyInvalidLogin("TC_001");
        test.info("CUrrent url "+ driver.getCurrentUrl());
    }
}
