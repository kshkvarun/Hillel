package Lesson25;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Locatable;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;
import static org.testng.Assert.assertTrue;
import static org.testng.Assert.fail;

public class Task2 extends BaseClass {

    public String mainSearch = "search";
    public String mobilePhoneCategory = "//span[@class='categories-filter__link-title'] [contains(text(), 'Мобильные телефоны')]";
    public String appleId = "//label[contains(text(),'Apple')]";
    public String honorId = "//label[contains(text(),'Honor')]";
    public String productTitle = "span.goods-tile__title";
    public JavascriptExecutor js = ((JavascriptExecutor) driver);

    @BeforeMethod
    public void getUrl() {
        driver.get(rozetkaUrl);
    }


    @Test(description = "Task 2.1 filter by brand")
    public void filter() {

        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        driver.findElement(By.name(mainSearch)).sendKeys("Samsung", Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory))).click();
        wait.until(visibilityOfElementLocated((By.xpath("//label[contains(text(), 'Apple')]"))));
        driver.findElement(By.xpath(appleId)).click();
        driver.findElement(By.xpath(honorId)).click();

        List<WebElement> productLabels = driver.findElements(By.cssSelector(productTitle));
        for (WebElement lable : productLabels) {

            if (!lable.getText().contains("Samsung")) {
                if (!lable.getText().contains("Honor")) {
                    if (!lable.getText().contains("Apple")) {
                        assertTrue(false);
                    }
                }
            }
        }
    }

    @Test(description = "Task 2.1 filter by brand")
    public void priceRange() throws InterruptedException {

        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        driver.findElement(By.name(mainSearch)).sendKeys("Samsung", Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory)));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("button.button.slider-filter__button")));
        sleep(10000);

    }

}
