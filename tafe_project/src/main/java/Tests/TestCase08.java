package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestCase08 {

    public static WebDriver driver;
    public static WebDriverWait wait;


    @BeforeTest
    public void abrirNavegador(){
        String caminhoDriver = "driver/chromedriver.exe";

        System.setProperty("webdriver.chrome.driver", caminhoDriver);

        driver = new ChromeDriver();

        wait = new WebDriverWait(driver, 40);

        driver.get("https://www.automationexercise.com");

        driver.manage().window().maximize();
    }


    @Test
    public void deveAcessarProdutoComSucesso(){

        String btnProducts = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a";
        String btnViewProduct = "#body > section:nth-child(4) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a";


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnProducts)));
        driver.findElement(By.cssSelector(btnProducts)).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnViewProduct)));
        driver.findElement(By.cssSelector(btnViewProduct)).click();

    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }

}