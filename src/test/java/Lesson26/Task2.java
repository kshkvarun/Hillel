package Lesson26;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;

import static java.lang.Thread.sleep;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.AssertJUnit.assertEquals;

public class Task2 extends BaseClass {
    String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String userID = "1303";
    String password = "Guru99";
    String logInBtn = "input[name='btnLogin']";
    String logOutBtn = "a[href='Logout.php']";
    String userIdField = "input[name='uid']";
    String userPasswordField = "input[name='password']";


    @BeforeMethod
    public void getUrl() {
        driver.get(url);
    }

    @Test
    public void Task2() throws InterruptedException {
        driver.findElement(By.cssSelector(userIdField)).sendKeys(userID);
        driver.findElement(By.cssSelector(userPasswordField)).sendKeys(password);
        driver.findElement(By.cssSelector(logInBtn)).click();
        wait.until(presenceOfElementLocated(By.linkText("Log out")));
        cookies = driver.manage().getCookies();
        System.out.println(cookies);

        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
        wait.until(visibilityOfElementLocated(By.cssSelector(logOutBtn)));
    }
}
