package Lesson26;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {


    WebDriver driver;
    WebDriverWait wait;


    @BeforeClass
    public void driverPreset() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
    }

    @AfterClass
    public void driverClose() {
        driver.quit();
    }
}

