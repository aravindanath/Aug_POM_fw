package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.JavaUtils;

import java.util.HashMap;

public class LoginPage extends BasePage{

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Object Repo

    @FindBy(xpath ="//input[@id='Email']" )
    WebElement usernameTextField;

    @FindBy(xpath ="//input[@id='Password']" )
    WebElement passwordTextField;

    @FindBy(xpath ="//button[text()='Log in']" )
    WebElement loginButton;

    @FindBy(xpath = "//div[text()='Login was unsuccessful. Please correct the errors and try again.']")
    WebElement invalidCredentialsMsg;

    @FindBy(xpath = "//div[@id='forgotPasswordLink']")
    WebElement forgotPasswordLinkButton;

    @FindBy(xpath = "//h1[contains(text(),'Dashboard')]")
    WebElement welcomeMsg;

    //Business Login

    HashMap<String, String> lp;


    public void verifyInvalidLogin(String tcid){
        lp = JavaUtils.readExcelData("Login",tcid);
        usernameTextField.clear();
        usernameTextField.sendKeys(lp.get("USERNAME"));

        passwordTextField.clear();

        passwordTextField.sendKeys(lp.get("PASSWORD"));
        loginButton.click();
        assertTitleContains(invalidCredentialsMsg,"Login was unsuccessful");
    }

    public void verifyValidLogin(String tcid){
        lp = JavaUtils.readExcelData("Login",tcid);
        usernameTextField.clear();
        usernameTextField.sendKeys(lp.get("USERNAME"));

        passwordTextField.clear();

        passwordTextField.sendKeys(lp.get("PASSWORD"));
        loginButton.click();
        assertTitleContains(welcomeMsg,"Dashboard");
    }

}
