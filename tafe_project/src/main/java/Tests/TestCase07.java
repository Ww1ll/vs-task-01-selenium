package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase07 {
    public static WebDriver driver;
    public static WebDriverWait wait;

    @BeforeTest
    public void abrirNavegador(){
        String caminhoDriver = "driver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.automationexercise.com/");

        driver.manage().window().maximize();
    }


    @Test
    public void deveAcessarTestCasePageComSucesso(){

        String btnTestCase = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnTestCase)));
        driver.findElement(By.cssSelector(btnTestCase)).click();

    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }
}