package Lesson25;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

public class Task1 extends BaseClass {

    private String rozetkaUrl = "https://rozetka.com.ua/" ;
    String itemComputersAndLaptops = "//sidebar-fat-menu//a[contains(text(), 'Ноутбуки и компьютеры')]";
    String itemMonitors = "//a[text()=' Мониторы ']";
    String goodPicture = "a.goods-tile__picture";
//  String menuCatalog = "//a[contains(text(), 'Ноутбуки и компьютеры')]";

    @BeforeMethod
    public void getUrl(){
        driver.get(rozetkaUrl);
    }

    @Test
    public void comparison (){
        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        action.moveToElement(driver.findElement(By.xpath(itemComputersAndLaptops))).build().perform();
        wait.until(presenceOfElementLocated(By.xpath(itemMonitors)));
        driver.findElement(By.xpath(itemMonitors)).isDisplayed();
        driver.findElement(By.xpath(itemMonitors)).click();
        wait.until((presenceOfElementLocated(By.cssSelector(goodPicture))));

    }


}
