package Lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RozetkaComparePage {

    WebDriver driver;

    public RozetkaComparePage(WebDriver driver) {
        this.driver = driver;
    }

    @FindBy(css = "li.products-grid__cell")
    List <WebElement> product;
    By productTitleInCompare = By.cssSelector("a.product__heading");


    public void checkIfTwoProductsInCompare(){
        List<WebElement> compareList = product;
        assertThat(2, equalTo(compareList.size()));
    }

    public List<WebElement> compareProductsList() {
        return driver.findElements(By.cssSelector("div.product"));
    }

    public void checkProductsNames(String firstProductName, String secondProductName){
        assertThat(compareProductsList().get(0).findElement(productTitleInCompare).getText(), equalTo(firstProductName));
        assertThat(compareProductsList().get(1).findElement(productTitleInCompare).getText(), equalTo(secondProductName));
    }

    public void checkProductPrice(int firstPrice, int secondPrice){
        String firstPriceInCompare = compareProductsList().get(0).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intFirstPriceInCompare = Integer.parseInt(firstPriceInCompare);
        String secondPriceInCompare = compareProductsList().get(1).findElement(By.cssSelector("div.product__price.product__price--red")).getText().replaceAll("\\s+", "").substring(5, 9);
        int intSecondPriceInCompare = Integer.parseInt(secondPriceInCompare);
        assertThat(intFirstPriceInCompare, equalTo(firstPrice));
        assertThat(intSecondPriceInCompare, equalTo(secondPrice));
    }


}
