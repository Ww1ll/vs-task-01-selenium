package Tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


import java.util.Locale;

public class TestCase03 {

    private static Faker faker = new Faker(new Locale("PT-BR"));

    @Test
    public void LoginUserWithIncorrectEmailAndPassword(){
        String caminho = "driver/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", caminho);
        WebDriver browser = new ChromeDriver();
        browser.navigate().to("https://automationexercise.com/");

        browser.findElement(By.tagName("body")).isDisplayed();

        browser.findElement(By.xpath("//a[@href=\"/login\"]")).click();

        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/h2")).isDisplayed();

        String email = faker.internet().emailAddress();
        String senha = faker.internet().password();
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]")).sendKeys(email);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]")).sendKeys(senha);
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button")).click();
        browser.findElement(By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/p")).isDisplayed();

        browser.quit();
    }
}