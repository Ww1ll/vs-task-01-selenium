/**
 * 1. Launch browser
 * 2. Navigate to url 'http://automationexercise.com'
 * 3. Verify that home page is visible successfully
 * 4. Click 'Cart' button
 * 5. Scroll down to footer
 * 6. Verify text 'SUBSCRIPTION'
 * 7. Enter email address in input and click arrow button
 * 8. Verify success message 'You have been successfully subscribed!' is visible
 */

package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase11 {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador() {
        String caminhoDriver= "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminhoDriver);
        driver= new ChromeDriver();
        wait = new WebDriverWait(driver, 40);
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void finalizarNavegador() {
        driver.quit();
    }

    @Test
    public void testSubscriptionInCartPageSuccessfully() {

        Faker faker = new Faker();
        String cartButton = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a";
        String subscription = "#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2";
        String inputButton = "#susbscribe_email";
        String subscribeButton = "#subscribe";

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(cartButton)));
        driver.findElement(By.cssSelector(cartButton)).click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(subscription))).perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputButton)));
        driver.findElement(By.cssSelector(inputButton)).sendKeys(faker.internet().emailAddress());

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(subscribeButton)));
        driver.findElement(By.cssSelector(subscribeButton)).click();

        Assert.assertEquals("You have been successfully subscribed!", driver.findElement(By.cssSelector("#success-subscribe > div")).getText());

    }


}
