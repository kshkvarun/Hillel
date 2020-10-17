package Lesson25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task1 extends BaseClass {

    private String rozetkaUrl = "https://rozetka.com.ua/";
    String itemComputersAndLaptops = "//sidebar-fat-menu//a[contains(text(), 'Ноутбуки и компьютеры')]";
    String itemMonitors = "//fat-menu/div/ul/li[1]/div/div[2]/div[1]/div[2]/ul[2]/li/ul/li[1]";
//    Лично у меня не хотело искать по этим локаторам, у гих они работали, поэтому так коряво сделал
//    String itemMonitors = "//a[contains(text(),'Мониторы')]";
//    String itemMonitors1 = "//fat-menu//a[[text()=' Мониторы ']";
    String goodPicture = "a.goods-tile__picture";
    String prices = "span.goods-tile__price-value";
    String products = "span.goods-tile__title";
    String addToCompare = "button.compare-button";
    String productCompareCounter = "//span[@class='header-actions__button-counter']";
    String productTitleInCompare = "a.product__heading";
    String compareProductsButton = "button.header-actions__button";
    String compareLink = "a.comparison-modal__link";





//  String menuCatalog = "//a[contains(text(), 'Ноутбуки и компьютеры')]";

    @BeforeMethod
    public void getUrl() {
        driver.get(rozetkaUrl);
    }

    @Test
    public void comparison() throws InterruptedException {
        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        action.moveToElement(driver.findElement(By.xpath(itemComputersAndLaptops))).build().perform();
        wait.until(visibilityOfElementLocated(By.xpath(itemMonitors)));
        driver.findElement(By.xpath(itemMonitors)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodPicture)));

        int firstPrice = 0;
        int firstPriceIndex = 0;
        String firstPriceWithoutSpaces;
        int counter = 0;
        List<WebElement> priceList = driver.findElements(By.cssSelector(prices));
        for (WebElement firstItemPrice : priceList) {
            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);

            if (firstPrice < 3000) {
                firstPriceIndex = priceList.indexOf(firstItemPrice);
                counter++;
            }
            if (counter > 0) {
                break;
            }
        }


        List<WebElement> productList = driver.findElements(By.cssSelector(products));
        System.out.println(firstPriceIndex);
        String firstProductName = productList.get(firstPriceIndex).getText();
        System.out.println(firstProductName);

        String productTitle = "//span[@class='goods-tile__title'] [contains(text(), '" + firstProductName + "')]";
        driver.findElement(By.xpath(productTitle)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(addToCompare))).click();
        wait.until(visibilityOfElementLocated(By.xpath(productCompareCounter)));
        Assert.assertTrue(driver.findElement(By.xpath(productCompareCounter)).getText().contains("1"));
        driver.navigate().back();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodPicture)));


        int secondPrice = 0;
        int secondPriceIndex = 0;
        String secondPriceWithoutSpaces;
        int counter1 = 0;
        List<WebElement> secondPriceList = driver.findElements(By.cssSelector(prices));
        for (WebElement secondItemPrice : secondPriceList) {
            secondPriceWithoutSpaces = secondItemPrice.getText().replaceAll("\\s+", "");
            secondPrice = Integer.parseInt(secondPriceWithoutSpaces);

            if (secondPrice < firstPrice) {
                secondPriceIndex = secondPriceList.indexOf(secondItemPrice);
                counter1++;
            }
            if (counter1 > 0) {
                break;
            }
        }

        List<WebElement> productList2 = driver.findElements(By.cssSelector(products));
        System.out.println(secondPriceIndex);
        String secondProductName = productList2.get(secondPriceIndex).getText();
        System.out.println(secondProductName);

        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondProductName + "')]")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(addToCompare))).click();
        wait.until(textToBe(By.xpath(productCompareCounter), "2"));

        Assert.assertTrue(driver.findElement(By.xpath(productCompareCounter)).getText().contains("2"));

        driver.findElement(By.cssSelector(compareProductsButton)).click();
        driver.findElement(By.cssSelector(compareLink)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));
//        sleep(5000);


        List<WebElement> compareList = driver.findElements(By.cssSelector("li.products-grid__cell"));
        assertThat(2, equalTo(compareList.size()));

        List<WebElement> checkList = driver.findElements(By.cssSelector("div.product"));
        assertThat(checkList.get(0).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(firstProductName));
        assertThat(checkList.get(1).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(secondProductName));

        String firstPriceInCompare = checkList.get(0).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intFirstPriceInCompare = Integer.parseInt(firstPriceInCompare);
        String secondPriceInCompare = checkList.get(1).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intSecondPriceInCompare = Integer.parseInt(secondPriceInCompare);


        assertThat(intFirstPriceInCompare, equalTo(firstPrice));
        assertThat(intSecondPriceInCompare, equalTo(secondPrice));


    }
}





