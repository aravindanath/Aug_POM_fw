package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BasePage {

    protected WebDriver driver;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }


    public void assertTitle(WebElement element, String text){
        String actul = element.getText();
        Assert.assertEquals(actul,text,"Title mismatch");
    }

    public void assertTitleContains(WebElement element,String text){
        String actul = element.getText();
        Assert.assertEquals(actul.contains(text),true,"Title mismatch");
    }

}
