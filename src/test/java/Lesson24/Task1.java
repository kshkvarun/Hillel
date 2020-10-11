package Lesson24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;




public class Task1 {

    WebDriver driver = new ChromeDriver();
    WebDriverWait wait = new WebDriverWait(driver, 3);

    public String url = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";

    @AfterClass
    public void close() {
        driver.quit();
    }


    @Test(description = "Check for valid auth", priority = 1)
    public void validAuth() {
        driver.get(url);
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.name("btnLogin")).click();
        WebElement mess = wait.until(driver -> driver.findElement(By.className("heading3")));
        driver.findElement(By.xpath("/html/body/div[3]/div/ul/li[3]/a")).click();
        driver.switchTo().alert().accept();

    }

    @Test(description = "LogIn with empty UID", priority = 2)
    public void emptyUid() {
        WebElement mess = wait.until(driver -> driver.findElement(By.name("btnLogin")));
        driver.findElement(By.name("uid")).click();
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.id("message23")).isDisplayed();


    }

    @Test(description = "LogIn with empty password", priority = 3)
    public void emptyPassword() {
        WebElement mess = wait.until(driver -> driver.findElement(By.name("btnLogin")));
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.id("message18")).isDisplayed();
    }

    @Test(description = "LogIn with invalid login", priority = 4)
    public void invalidLogin() {
        driver.findElement(By.name("password")).sendKeys("Guru9999");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();


    }

    @Test(description = "LogIn with invalid password", priority = 5)
    public void invalidPassword() {
        WebElement mess = wait.until(driver -> driver.findElement(By.name("btnLogin")));
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99adsfg");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
    }

    @Test(description = "LogIn with empty login and password" , priority = 6)
    public void emptyLoginAndPassword () {
        WebElement mess = wait.until(driver -> driver.findElement(By.name("btnLogin")));
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
    }

    @Test(description = "Log in with only spaces in login and password", priority = 7)
    public void ValidAuth () {
        WebElement mess = wait.until(driver -> driver.findElement(By.name("btnLogin")));
        driver.findElement(By.name("uid")).sendKeys("    ");
        driver.findElement(By.name("password")).sendKeys("    ");
        driver.findElement(By.name("btnLogin")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(), "User or Password is not valid");
        driver.switchTo().alert().accept();
    }

}

