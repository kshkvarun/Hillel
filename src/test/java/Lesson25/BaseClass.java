package Lesson25;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import javax.swing.*;

public class BaseClass {

    WebDriverWait wait;
    WebDriver driver;
    Actions action;

    @BeforeClass
    public void newDriver(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        action = new Actions(driver);
        //Or it opens mobile version with different buttons
        driver.manage().window().setSize(new Dimension(1300, 1000));
    }

    @AfterClass
    public void closeBrowser(){
        driver.quit();
    }

}
