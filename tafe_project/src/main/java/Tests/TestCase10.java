/**
 * 1. Launch browser
 * 2. Navigate to url 'http://automationexercise.com'
 * 3. Verify that home page is visible successfully
 * 4. Scroll down to footer
 * 5. Verify text 'SUBSCRIPTION'
 * 6. Enter email address in input and click arrow button
 * 7. Verify success message 'You have been successfully subscribed!' is visible
 */

package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestCase10 {

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
    public void testSubscriptionInHomePageSuccessfully() {

        String subscription = "#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2";
        String inputButton = "#susbscribe_email";
        String subscribeButton = "#subscribe";

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(subscription))).perform();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(inputButton)));
        driver.findElement(By.cssSelector(inputButton)).sendKeys("qa@gmail.com");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(subscribeButton)));
        driver.findElement(By.cssSelector(subscribeButton)).click();

       // try {
       //     Thread.sleep(10000); // Aguarda por 2 segundos
       // } catch (InterruptedException e) {
       //     e.printStackTrace();
       // }
        // esta mensagem aparece por poucos segundos, não consigo pegar o seletor...
        // 7. Verify success message 'You have been successfully subscribed!' is visible

    }

}
