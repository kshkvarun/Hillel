package Lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaResultPage {

    WebDriver driver;
    Actions action;
    WebDriverWait wait;

    By prices = By.cssSelector("span.goods-tile__price-value");
    public By products = By.cssSelector("span.goods-tile__title");



    public RozetkaResultPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getProductPrice(int productPrice){
        int firstPrice = 0;
        String firstPriceWithoutSpaces;
        int counter = 0;
        List<WebElement> priceList = driver.findElements(prices);
        for (WebElement firstItemPrice : priceList) {
            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);

            if (firstPrice < productPrice) {
                counter++;
            }
            if (counter > 0) {
                break;
            }
        }
        return firstPrice;
    }

    public int getProductIndex(int productPrice){
        int firstPrice;
        int firstPriceIndex = 0;
        String firstPriceWithoutSpaces;
        int counter = 0;
        List<WebElement> priceList = driver.findElements(prices);
        for (WebElement firstItemPrice : priceList) {
            firstPriceWithoutSpaces = firstItemPrice.getText().replaceAll("\\s+", "");
            firstPrice = Integer.parseInt(firstPriceWithoutSpaces);

            if (firstPrice < productPrice) {
                firstPriceIndex = priceList.indexOf(firstItemPrice);
                counter++;
            }
            if (counter > 0) {
                break;
            }
        }
        return firstPriceIndex;
    }

    public String getProductName(int priceIndex) {
        List<WebElement> productList = driver.findElements(products);
        String productName = productList.get(priceIndex).getText();
        return productName;
    }

}
