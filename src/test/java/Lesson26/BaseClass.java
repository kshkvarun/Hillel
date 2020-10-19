package Lesson26;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.Set;

public class BaseClass {


    WebDriver driver;
    WebDriverWait wait;
    Actions actions ;
    Set<Cookie> cookies;


    @BeforeClass
    public void driverPreset() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        actions = new Actions(driver);
    }


    @AfterClass
    public void driverClose() {
        driver.quit();
    }
}

