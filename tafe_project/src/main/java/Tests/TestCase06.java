package Tests;


import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.util.Locale;


public class TestCase06 {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static Faker faker = new Faker(new Locale("PT-BR"));

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
    public void deveEntrarEmContatoComSucesso(){


        String btnContato = "#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(8) > a";
        String btnFicheiro = "#contact-us-form > div:nth-child(6) > input";
        String btnSubmit = "#contact-us-form > div:nth-child(7) > input";


        String nome = faker.name().firstName();
        String email = faker.internet().emailAddress();
        String subject = faker.twinPeaks().character();
        String message = faker.twinPeaks().quote();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnContato)));
        driver.findElement(By.cssSelector(btnContato)).click();


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"name\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"name\"]")).sendKeys(nome);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"email\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"email\"]")).sendKeys(email);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"subject\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"subject\"]")).sendKeys(subject);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[data-qa=\"message\"]")));
        driver.findElement(By.cssSelector("input[data-qa=\"message\"]")).sendKeys(message);

        WebElement fileInput = driver.findElement(By.cssSelector(btnFicheiro));

        String filePath = getClass().getClassLoader().getResource("uploads/arquivo.txt").getPath();

        fileInput.sendKeys(filePath);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(btnSubmit)));
        driver.findElement(By.cssSelector(btnSubmit)).click();


    }

    @AfterTest
    public void finalizarNavegador(){
        driver.quit();
    }


}
