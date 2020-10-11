package Lesson24;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.security.Key;
import java.util.List;

import static java.lang.Thread.sleep;

public class Task2 {
    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 5);

    @Test
    public void openGoogle() throws InterruptedException {

        driver.get("https://google.com/ncr");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).sendKeys("Iphone киев купить");
        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);


        for (int i = 1; i < 5; i++) {
            List<WebElement> elements = driver.findElements(By.cssSelector("div.g"));
            for (WebElement element : elements) {
                if (element.getText().contains("stylus.ua")) {
                    System.out.println("STYLUS.UA has been found on page " + i);
                }
            }
            driver.findElement(By.id("pnnext")).click();
        }
    }
}



