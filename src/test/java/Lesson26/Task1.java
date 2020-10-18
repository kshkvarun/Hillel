package Lesson26;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;


public class Task1 extends BaseClass {
    String gmailUrl = "https://mail.google.com/";
    String inputEmail = "input[id=identifierId]";
    String inputPassword = "input[name='password']";
    String email = "konstantynshkvarun@gmail.com";
    String password = "Moneyfor1989";
    String newEmailButton = "div[gh='cm'][role='button']";
    String toField = "textarea[name='to']";
    String topic = "input[name='subjectbox']";
    String newMessagePopUpTitle = "//div[@aria-label='Тело письма']";
    String sendButton = "//div[@role='button'][contains(text(), 'Отправить')]";
    String addFiles = "div[command='Files']";
    String letterBodyText = "Am I good QA?";
    String letterBodyLocator = "//div[contains(text(), '" + letterBodyText + "' )]";

    @BeforeMethod
    public void navigateToUrl() {
        driver.get(gmailUrl);
    }

    @Test
    public void Task1() throws InterruptedException, AWTException {
        wait.until(visibilityOfElementLocated(By.cssSelector(inputEmail))).sendKeys(email + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(inputPassword))).sendKeys(password + Keys.ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector(newEmailButton))).click();
        wait.until(visibilityOfElementLocated(By.xpath(newMessagePopUpTitle)));
        driver.findElement(By.cssSelector(toField)).sendKeys(email);
        String topicText = "Are you smoking a lot of something ?";
        driver.findElement(By.cssSelector(topic)).sendKeys(topicText);
        driver.findElement(By.xpath(newMessagePopUpTitle)).sendKeys(letterBodyText);
        driver.findElement(By.cssSelector(addFiles)).click();
        StringSelection ss = new StringSelection("/home/kostya/Desktop/Log");
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
        wait.until(visibilityOfElementLocated(By.cssSelector("div[aria-label='Удалить прикрепленный файл']")));
        driver.findElement(By.xpath(sendButton)).click();
        wait.until(visibilityOfElementLocated(By.xpath("//span[contains(text(), 'Письмо отправлено.')]")));

        List<WebElement> emailsList = driver.findElements(By.xpath("//span[contains(text(), '" + topicText + "')] [@data-legacy-last-non-draft-message-id]"));
        assertThat(emailsList.get(1).getText(), equalTo(topicText));
        emailsList.get(1).click();

        wait.until(visibilityOfElementLocated(By.xpath("//h2[contains(text(), '" + topicText + "' )]")));
        wait.until(visibilityOfElementLocated(By.xpath("//span[text()='Log']")));
        assertThat(driver.findElement(By.xpath(letterBodyLocator)).getText(), equalTo(letterBodyText));
    }
}



