package Lesson26;
import org.openqa.selenium.By;
import static org.openqa.selenium.support.ui.ExpectedConditions.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Task3 extends BaseClass {
    String demoUrl = "http://demo.guru99.com/Agile_Project/Agi_V1/index.php";
    String playButton = "div[id='playBtn']";
    String pauseButton = "div[id='playBtn']";
    String loginField = "input[name='uid']";

    @BeforeMethod
    public void getUrl() {
        driver.get(demoUrl);
    }

    @Test
    public void Task1() throws InterruptedException {
        wait.until(presenceOfElementLocated(By.cssSelector(playButton))).click();
        actions.moveToElement(driver.findElement(By.cssSelector(pauseButton))).build().perform();
        wait.until(visibilityOfElementLocated(By.cssSelector(pauseButton)));
        actions.moveToElement(driver.findElement(By.cssSelector(loginField))).click();
        wait.until(invisibilityOfElementLocated(By.cssSelector(pauseButton)));
    }
}