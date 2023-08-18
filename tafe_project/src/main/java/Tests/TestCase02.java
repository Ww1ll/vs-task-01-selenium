package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Locale;

public class TestCase02 {

    private static Faker faker = new Faker(new Locale("PT-BR"));
    public WebDriver browser;

    @BeforeTest
    public void abrirNavegador(){
        String caminho = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminho);
        browser = new ChromeDriver();
        browser.navigate().to("https://automationexercise.com/");
    }

    @Test
    public void LoginUserWithCorrectEmailAndPassword(){
        browser.findElement(By.xpath("//a[@href=\"/login\"]")).click();

        String password = faker.internet().password();
        String email = faker.internet().emailAddress();
        String name = faker.name().nameWithMiddle();
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]")).sendKeys(name);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]")).sendKeys(email);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button")).click();
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/h2")).isDisplayed();

        //Clicar no radio
        browser.findElement(By.xpath("//*[@id=\"id_gender1\"]")).click();

        browser.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys(password);

        //Data do nascimento
        browser.findElement(By.xpath("//*[@id=\"days\"]")).sendKeys("8");
        browser.findElement(By.xpath("//*[@id=\"months\"]")).sendKeys("10");
        browser.findElement(By.xpath("//*[@id=\"years\"]")).sendKeys("1996");

        //Clicando nos radios
        browser.findElement(By.xpath("//*[@id=\"newsletter\"]")).click();
        browser.findElement(By.xpath("//*[@id=\"optin\"]")).click();

        //Infos da empresa
        String primeiroNome = faker.name().firstName();
        String ultimoNome= faker.name().lastName();
        String empresa = faker.name().fullName();
        browser.findElement(By.xpath("//*[@id=\"first_name\"]")).sendKeys(primeiroNome);
        browser.findElement(By.xpath("//*[@id=\"last_name\"]")).sendKeys(ultimoNome);
        browser.findElement(By.xpath("//*[@id=\"company\"]")).sendKeys(empresa);

        //Endereço:
        String enderecoUm = faker.address().fullAddress();
        String enderecoDois = faker.address().fullAddress();
        browser.findElement(By.xpath("//*[@id=\"address1\"]")).sendKeys(enderecoUm);
        browser.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys(enderecoDois);

        browser.findElement(By.xpath("//*[@id=\"address2\"]")).sendKeys("Israel");

        //Localidade
        String estado = faker.address().state();
        String cidade = faker.address().city();
        String cep = faker.toString();
        String cel = faker.phoneNumber().cellPhone();
        browser.findElement(By.xpath("//*[@id=\"state\"]")).sendKeys(estado);
        browser.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys(cidade);
        browser.findElement(By.xpath("//*[@id=\"zipcode\"]")).sendKeys(cep);
        browser.findElement(By.xpath("//*[@id=\"mobile_number\"]")).sendKeys(cel);

        //Clicar no botão
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/div/form/button")).click();
        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a")).click();
        browser.findElement(By.tagName("body")).isDisplayed();
        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]")).click();
        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a")).click();


        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed();

        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(password);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();

        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a")).isDisplayed();

        browser.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")).click();
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div/h2")).isDisplayed();
    }

    @AfterTest
    public void fechar(){
        browser.quit();
    }
}
