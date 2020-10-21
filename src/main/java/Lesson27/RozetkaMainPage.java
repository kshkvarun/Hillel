package Lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RozetkaMainPage {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;


    public RozetkaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public By itemMonitors = By.xpath("//fat-menu/div/ul/li[1]/div/div[2]/div[1]/div[2]/ul[2]/li/ul/li[1]");
    public By itemComputersAndLaptops = By.xpath("//sidebar-fat-menu//a[contains(text(), 'Ноутбуки и компьютеры')]");

    public void cursorMoveToElement(By linkText) {
        action = new Actions(driver);
        action.moveToElement(driver.findElement(linkText)).build().perform();
    }

    public void clickOnProductCategory(){
        driver.findElement(itemMonitors).click();
    }


}
