package Lesson26;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertTrue;

public class Task4 extends BaseClass {
    String mainUrl = "http://demo.guru99.com/test/drag_drop.html";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(mainUrl);
    }

    @Test

    public void Task1() throws InterruptedException {


        WebElement bank  = driver.findElement(By.xpath("//*[@id='credit2']/a"));
        WebElement sales = driver.findElement(By.xpath("//*[@id='credit1']/a"));
        WebElement debMoney = driver.findElement(By.xpath("//li[@id='fourth']"));
        WebElement credMoney = driver.findElement(By.xpath("//li[@id='fourth']"));

        WebElement debitAccount = driver.findElement(By.xpath("//*[@id='bank']/li"));
        WebElement debitAmount = driver.findElement(By.xpath("//*[@id='amt7']/li"));
        WebElement creditAccount = driver.findElement(By.xpath("//*[@id='loan']/li"));
        WebElement creditAmount = driver.findElement(By.xpath("//*[@id='amt8']/li"));

        actions.dragAndDrop(bank, debitAccount).build().perform();
        actions.dragAndDrop(debMoney, debitAmount).build().perform();
        actions.dragAndDrop(sales, creditAccount).build().perform();
        actions.dragAndDrop(credMoney, creditAmount).build().perform();

        assertThat(driver.findElement(By.cssSelector("a[class='button button-green']")).getText(), equalTo("Perfect!"));
    }
}
