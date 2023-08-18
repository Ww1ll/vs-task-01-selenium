/**
 * 1. Launch browser
 * 2. Navigate to url 'http://automationexercise.com'
 * 3. Verify that home page is visible successfully
 * 4. Click on 'Products' button
 * 5. Verify user is navigated to ALL PRODUCTS page successfully
 * 6. Enter product name in search input and click search button
 * 7. Verify 'SEARCHED PRODUCTS' is visible
 * 8. Verify all the products related to search are visible
 */


package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase09 {

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
    public void testMustSearchProductSuccessfully() {

        String btnProducts = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String  titleAllProducts = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2";
        String  inputField = "#search_product";
        String  btnInput = "#submit_search > i";
        String product = "polo";
        String titleSearchedProducts = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2";
        String poloText = "body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div.col-sm-4 > div > div.single-products > div.productinfo.text-center > p";

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(btnProducts)));
        driver.findElement(By.cssSelector(btnProducts)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(titleAllProducts)));
        driver.findElement(By.cssSelector(inputField)).sendKeys(product);
        driver.findElement(By.cssSelector(btnInput)).submit();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(titleSearchedProducts)));

        WebElement element = driver.findElement(By.cssSelector(poloText));
        String elementText = element.getText();

        Assert.assertTrue(elementText.contains(product));

    }

}
