package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;



public class TestCase05 {
    public static WebDriver driver;
    public static WebDriverWait wait;

    private static Faker faker = new Faker(new Locale("PT-BR"));

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
        String sobrenome = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();

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

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"first-name\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"first-name\"]")).sendKeys(nome);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"last-name\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"last-name\"]")).sendKeys(sobrenome);

        String nomeEmpresa = faker.name().fullName();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"company\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"company\"]")).sendKeys(nomeEmpresa);

        String primeiroEndereco = faker.address().fullAddress();
        String segundoEndereco = faker.address().fullAddress();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"address\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"address\"]")).sendKeys(primeiroEndereco);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"address2\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"address2\"]")).sendKeys(segundoEndereco);


        String estado = faker.address().state();
        String cidade = faker.address().city();
        String cep = faker.address().zipCode();
        String telefone = faker.phoneNumber().cellPhone();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"state\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"state\"]")).sendKeys(estado);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"city\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"state\"]")).sendKeys(cidade);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"zipcode\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"zipcode\"]")).sendKeys(cep);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"mobile_number\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"mobile_number\"]")).sendKeys(telefone);


        String btnCriarConta = "#form > div > div > div > div > form > button";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnCriarConta)));
        driver.findElement(By.cssSelector(btnCriarConta)).click();

        String btnContinuar = "#form > div > div > div > div > a";
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnContinuar)));
        driver.findElement(By.cssSelector(btnContinuar)).click();

        String btnLogout = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a";

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"signup-name\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-name\"]")).sendKeys(nome);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"signup-email\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"signup-email\"]")).sendKeys(email);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnSignUp)));
        driver.findElement(By.cssSelector(btnSignUp)).click();


    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }

}