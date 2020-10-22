package Lesson27;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RozetkaProductPage {

    WebDriver driver;

    public By addToCompare = By.cssSelector("button.compare-button");
    public By productCompareCounter = By.xpath("//span[@class='header-actions__button-counter']");

    @FindBy(css = "button.header-actions__button")
    WebElement compareProductsButton;
    @FindBy(css = "a.comparison-modal__link")
    WebElement compareLink;






    public RozetkaProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void findFirstProduct(String firstProductName){
        By productTitle = By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + firstProductName + "')]");
        driver.findElement(productTitle).click();
    }

    public void findSecondProduct(String secondProductName){
        driver.findElement(By.xpath("//span[@class='goods-tile__title'] [contains(text(), '" + secondProductName + "')]")).click();
    }

    public void compareProductsClick() {
        compareProductsButton.click();
    }

    public void compareLinkClick(){
        compareLink.click();
    }

}
