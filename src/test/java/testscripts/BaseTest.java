package testscripts;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;
import utils.Generic;

import java.util.concurrent.TimeUnit;

public class BaseTest {

   protected WebDriver driver;
    protected ExtentTest test;
    protected ExtentReports report ;
    protected ExtentSparkReporter spark;

   @BeforeMethod
   public void reportSetup(){
       report = new ExtentReports();
       spark = new ExtentSparkReporter("./index.html");
       spark.config().setDocumentTitle("Automation Report");
       spark.config().setReportName("Arvind");
       spark.config().setTheme(Theme.STANDARD);
       report.attachReporter(spark);
   }



    @BeforeClass
    @Parameters("browser")
    public void setup(String browser){


        if(browser.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if(browser.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get(Generic.getValue("url"));
    }


    @AfterClass
    public void teardown(){
        driver.quit();


    }

    @AfterMethod
    public void reportFlush(){
        report.flush();
    }

}
