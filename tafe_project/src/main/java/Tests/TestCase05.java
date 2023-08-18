package Tests;

/*
* 1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'New User Signup!' is visible
6. Enter name and already registered email address
7. Click 'Signup' button
8. Verify error 'Email Address already exist!' is visible
*
* */


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static Tests.TestCase06.faker;


public class TestCase05 {
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
    public void deveRegistrarComEmailExistente(){

        String nome = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

        String nomeEmpresa = faker.name().fullName();


        String btnSignUp = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"signup-name\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys(nome);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"signup-email\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnSignUp)));
        driver.findElement(By.cssSelector(btnSignUp)).click();


        driver.findElement(By.cssSelector("#id_gender1")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"password\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"password\"]")).sendKeys(password);

        driver.findElement(By.cssSelector("#days")).sendKeys("10");

        driver.findElement(By.cssSelector("#months")).sendKeys("10");

        driver.findElement(By.cssSelector("#years")).sendKeys("2003");



    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }

}
