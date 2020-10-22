package Lesson25;

import Lesson27.RozetkaComparePage;
import Lesson27.RozetkaMainPage;
import Lesson27.RozetkaProductPage;
import Lesson27.RozetkaResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class Task1 extends BaseClass {

    public String addToCompare = "button.compare-button";
    public String productCompareCounter = "//span[@class='header-actions__button-counter']";
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
        wait.until(visibilityOfElementLocated(rozetkaMainPage.goodPicture));


//        Search for first price less then 3000 and remember price
        RozetkaResultPage rozetkaResultPage = new RozetkaResultPage(driver);
        firstPrice = rozetkaResultPage.getProductPrice(firstPoductPriceLimit);
        firstPriceIndex = rozetkaResultPage.getProductIndex(firstPoductPriceLimit);

//        Remember name of product with price less then 3000
        firstProductName = rozetkaResultPage.getProductName(firstPriceIndex);

//        Add to compare first product
        RozetkaProductPage rozetkaProductPage = new RozetkaProductPage(driver);
        rozetkaProductPage.findFirstProduct(firstProductName);
        wait.until(visibilityOfElementLocated(rozetkaProductPage.addToCompare)).click();
        wait.until(visibilityOfElementLocated(rozetkaProductPage.productCompareCounter));
        Assert.assertTrue(driver.findElement(rozetkaProductPage.productCompareCounter).getText().contains("1"));
//        GO back to products overview

        driver.navigate().back();
        wait.until(visibilityOfElementLocated(rozetkaMainPage.goodPicture));

//        Searching for second product which has price less the first one and remember price of product
        secondPrice = rozetkaResultPage.getProductPrice(firstPrice);
        secondPriceIndex = rozetkaResultPage.getProductIndex(firstPrice);

//        Remember name of second product
        secondProductName = rozetkaResultPage.getProductName(secondPriceIndex);

//        Add to compare and check if it was added
        rozetkaProductPage.findSecondProduct(secondProductName);
        wait.until(visibilityOfElementLocated(By.cssSelector(addToCompare))).click();
        wait.until(textToBe(By.xpath(productCompareCounter), "2"));
        Assert.assertTrue(driver.findElement(By.xpath(productCompareCounter)).getText().contains("2"));

//        Go to compare page
        rozetkaProductPage.compareProductsClick();
        rozetkaProductPage.compareLinkClick();
        wait.until(visibilityOfElementLocated(By.cssSelector("h1.comparison__heading")));

//        Check if compare page has only two products
        RozetkaComparePage rozetkaComparePage = new RozetkaComparePage(driver);
        rozetkaComparePage.checkIfTwoProductsInCompare();

//        Check name of products
        rozetkaComparePage.checkProductsNames(firstProductName, secondProductName);

//        Check price of products
        rozetkaComparePage.checkProductPrice(firstPrice, secondPrice);


    }
}





