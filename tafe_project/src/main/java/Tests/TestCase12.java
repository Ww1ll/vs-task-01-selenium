package Tests;

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

public class TestCase12 {


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
    public void testVerifiyWithProductsCartSuccessfully() {

        String btnProducts = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String firstProduct = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div.product-image-wrapper > div.single-products > div.productinfo.text-center > a";
        String secondProduct = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > a";
        String addedButton = "#cartModal > div > div > div.modal-footer > button";
        String cartButton = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(3) > a";

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(btnProducts)));
        driver.findElement(By.cssSelector(btnProducts)).click();


        // não está passando, neste ponto está abrindo um iframe de propaganda do google, que não conseguimos eliminar
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(firstProduct))).perform();

        driver.findElement(By.cssSelector(firstProduct)).click();
        driver.findElement(By.cssSelector(addedButton)).click();

        actions.moveToElement(driver.findElement(By.cssSelector(secondProduct))).perform();

        driver.findElement(By.cssSelector(addedButton)).click();

        actions.moveToElement(driver.findElement(By.cssSelector(cartButton))).perform();
        driver.findElement(By.cssSelector(cartButton)).click();

        Assert.assertTrue(driver.findElement(By.id("product-2")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.id("product-2")).isDisplayed());
        Assert.assertNotNull(driver.findElement(By.id("#product-1 > td.cart_quantity")));
        Assert.assertNotNull(driver.findElement(By.id("#product-2 > td.cart_quantity")));


    }


}
