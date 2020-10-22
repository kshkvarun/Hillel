package Lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class RozetkaResultPage {

    WebDriver driver;


    @FindBy(css = "span.goods-tile__price-value")
//    By prices = By.cssSelector("span.goods-tile__price-value");
    List <WebElement> prices;
    @FindBy(css = "span.goods-tile__title")
    List <WebElement> products;
//    By products = By.cssSelector("span.goods-tile__title");


    public RozetkaResultPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    public int getProductPrice(int productPrice){
        int firstPrice = 0;
        String firstPriceWithoutSpaces;
        int counter = 0;
        List<WebElement> priceList = prices;
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
        List<WebElement> priceList = prices;
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
        List<WebElement> productList = products;
        return productList.get(priceIndex).getText();
    }


}
