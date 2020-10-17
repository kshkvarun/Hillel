package Lesson25;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import static org.testng.Assert.assertTrue;


public class Task2 extends BaseClass {

    public String mainSearch = "search";
    public String mobilePhoneCategory = "//span[@class='categories-filter__link-title'] [contains(text(), 'Мобильные телефоны')]";
    public String appleId = "//label[contains(text(),'Apple')]";
    public String honorId = "//label[contains(text(),'Honor')]";
    public String samsungSeries = "//label[contains(text(), 'Galaxy Note')]";
    public String productTitle = "span.goods-tile__title";
    public String minPrice = "input[formcontrolname='min']";
    public String maxPrice = "input[formcontrolname='max']";
    public String okButton = "button.button.button_color_gray.button_size_small";
    public String itemPrice = "span.goods-tile__price-value";
    public String sideSearch = "h1.catalog-heading";


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

    @Test(description = "Task 2.2 filter price range")
    public void priceRange() throws InterruptedException {

        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        driver.findElement(By.name(mainSearch)).sendKeys("Samsung", Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory)));
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory))).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(sideSearch)));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.cssSelector("button.button.slider-filter__button")));
        driver.findElement(By.cssSelector(minPrice)).clear();
        driver.findElement(By.cssSelector(minPrice)).sendKeys("5000");
        driver.findElement(By.cssSelector(maxPrice)).clear();
        driver.findElement(By.cssSelector(maxPrice)).sendKeys("15000");
        driver.findElement(By.cssSelector(okButton)).click();

        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        int intPrice;
        String priceWithoutSpaces;
        List<WebElement> itemPrices = driver.findElements(By.cssSelector(itemPrice));
        for (WebElement lable : itemPrices) {
            priceWithoutSpaces = lable.getText().replaceAll("\\s+", "");
            intPrice = Integer.parseInt(priceWithoutSpaces);
            if (intPrice < 5000 || intPrice > 15000) {
                assertTrue(false);
            }
        }
    }

    @Test(description = "Task 2.1 filter series")
    public void searchBySeries() throws InterruptedException {

        wait.until(presenceOfElementLocated(By.xpath(itemComputersAndLaptops)));
        driver.findElement(By.name(mainSearch)).sendKeys("Samsung", Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory)));
        wait.until(visibilityOfElementLocated(By.xpath(mobilePhoneCategory))).click();
        wait.until(visibilityOfElementLocated(By.cssSelector(sideSearch)));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//span[@class='sidebar-block__toggle-title'] [contains(text(), 'Серия')]")));
        driver.findElement(By.xpath(samsungSeries)).click();

        new WebDriverWait(driver, 10).until(
                webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

        List<WebElement> productLabels = driver.findElements(By.cssSelector(productTitle));
        for (WebElement lable : productLabels) {
            System.out.println(productTitle);
            if (!lable.getText().contains("Galaxy Note")) {
                assertTrue(false);
            }
        }
    }
}

