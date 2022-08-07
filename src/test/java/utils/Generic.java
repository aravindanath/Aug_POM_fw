package utils;

import com.github.javafaker.Faker;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Locale;
import java.util.Properties;

public class Generic {


    public static String getValue(String key) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
        String value = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Properties prop = new Properties(); // object of Properties claSS
            prop.load(fis);
            value = prop.getProperty(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }


    public static void setValue(String key, String value) {
        String path = System.getProperty("user.dir") + File.separator + "src" + File.separator + "main" + File.separator + "resources" + File.separator + "config.properties";
        try {
            FileOutputStream fos = new FileOutputStream(path, true);
            Properties prop = new Properties(); // object of Properties claSS
            prop.setProperty(key, value);
            prop.store(fos, "Test Data");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void mouseHover(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }


    public static void click(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.click(element).build().perform();
    }


    public static void dragAndDrop(WebDriver driver, WebElement element1, WebElement element2) {
        Actions actions = new Actions(driver);
        actions.dragAndDrop(element1, element2).build().perform();
    }


    public static void rightClick(WebDriver driver, WebElement element) {
        Actions actions = new Actions(driver);
        actions.contextClick(element).build().perform();
    }


    public static void scroll(WebDriver driver, WebElement element) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public static void takescreenshot(WebDriver driver) {
        try {
            TakesScreenshot srcShot = (TakesScreenshot) driver;
            File src = srcShot.getScreenshotAs(OutputType.FILE);
            File dest = new File("./screenshot.png");
            FileUtils.copyFile(src, dest);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void selectByValue(WebElement element, String value) {
        Select select = new Select(element);
        select.selectByValue(value);
    }


    public static void selectByIndex(WebElement element, int index) {
        Select select = new Select(element);
        select.selectByIndex(index);
    }

    public static void selectByText(WebElement element, String text) {
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }


    public static void acceptAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.accept();
    }


    public static void dismissAlert(WebDriver driver) {
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
    }


    public static void acceptAlert(WebDriver driver, String text) {
        Alert alert = driver.switchTo().alert();
        alert.sendKeys(text);
        alert.accept();
    }


    public static String getFullName() {
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().fullName();
        return fn;
    }

    public static String getEmail() {
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.name().fullName().replace(" ", "").replace(".", "") + "@testmail.com";
        return fn;
    }

    public static String getMobileNumber() {
        Faker faker = new Faker(new Locale("en-IND"));
        String fn = faker.number().digits(10);
        return fn;
    }

}
