package Lesson25;

import Lesson27.RozetkaMainPage;
import Lesson27.RozetkaResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task1 extends BaseClass {

    public String goodPicture = "a.goods-tile__picture";
    public String addToCompare = "button.compare-button";
    public String productCompareCounter = "//span[@class='header-actions__button-counter']";
    public String productTitleInCompare = "a.product__heading";
    public String compareProductsButton = "button.header-actions__button";
    public String compareLink = "a.comparison-modal__link";
    //  String menuCatalog = "//a[contains(text(), 'Ноутбуки и компьютеры')]";
    String secondProductName;
    int firstPriceIndex;
    int secondPriceIndex;
    int firstPrice;
    int secondPrice;
    int firstPoductPriceLimit = 3000;
    String firstProductName;

    By linkText = By.linkText("Ноутбуки и компьютеры");

    @BeforeMethod
    public void getUrl() {
        driver.get(rozetkaUrl);
    }

    @Test
    public void comparison() throws InterruptedException {
        RozetkaMainPage rozetkaMainPage = new RozetkaMainPage(driver);
        wait.until(presenceOfElementLocated(rozetkaMainPage.itemComputersAndLaptops));
        rozetkaMainPage.cursorMoveToElement(linkText);
        wait.until(visibilityOfElementLocated(rozetkaMainPage.itemMonitors));
        rozetkaMainPage.clickOnProductCategory();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodPicture)));


//        Search for first price less then 3000 and remember price
        RozetkaResultPage rozetkaResultPage = new RozetkaResultPage(driver);
        firstPrice = rozetkaResultPage.getProductPrice(firstPoductPriceLimit);
        firstPriceIndex = rozetkaResultPage.getProductIndex(firstPoductPriceLimit);
//        Remember name of product with price less then 3000
        firstProductName = rozetkaResultPage.getProductName(firstPriceIndex);


//        Add to compare first product
        String productTitle = "//span[@class='goods-tile__title'] [contains(text(), '" + firstProductName + "')]";
        driver.findElement(By.xpath(productTitle)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(addToCompare))).click();
        wait.until(visibilityOfElementLocated(By.xpath(productCompareCounter)));
        Assert.assertTrue(driver.findElement(By.xpath(productCompareCounter)).getText().contains("1"));
//        GO back to products overview
        driver.navigate().back();
        wait.until(visibilityOfElementLocated(By.cssSelector(goodPicture)));

//        Searching for second product which has price less the first one and remember price of product
        secondPrice = rozetkaResultPage.getProductPrice(firstPrice);
        secondPriceIndex = rozetkaResultPage.getProductIndex(firstPrice);

//        Remember name of second product

        secondProductName = rozetkaResultPage.getProductName(secondPriceIndex);

//        List<WebElement> productList2 = driver.findElements(rozetkaResultPage.products);
//        secondProductName = productList2.get(secondPriceIndex).getText();



//        Add to compare and check if it was added
        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondProductName + "')]")).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(addToCompare))).click();
        wait.until(textToBe(By.xpath(productCompareCounter), "2"));
        Assert.assertTrue(driver.findElement(By.xpath(productCompareCounter)).getText().contains("2"));

//        Go to compare page
        driver.findElement(By.cssSelector(compareProductsButton)).click();
        driver.findElement(By.cssSelector(compareLink)).click();
        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));

//        Check if compare page has only two products
        List<WebElement> compareList = driver.findElements(By.cssSelector("li.products-grid__cell"));
        assertThat(2, equalTo(compareList.size()));

//        Check name of products
        List<WebElement> checkList = driver.findElements(By.cssSelector("div.product"));
        assertThat(checkList.get(0).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(firstProductName));
        assertThat(checkList.get(1).findElement(By.cssSelector(productTitleInCompare)).getText(), equalTo(secondProductName));

//        Check price of products
        String firstPriceInCompare = checkList.get(0).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intFirstPriceInCompare = Integer.parseInt(firstPriceInCompare);
        String secondPriceInCompare = checkList.get(1).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intSecondPriceInCompare = Integer.parseInt(secondPriceInCompare);
        assertThat(intFirstPriceInCompare, equalTo(firstPrice));
        assertThat(intSecondPriceInCompare, equalTo(secondPrice));


    }
}





