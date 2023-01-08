package ua.hillel.tests.seleniumLocators;

/*написати 2 тести на коректний та некоректний логін. В першому випадку перевірити,
що відображається повідомлення "You logged into a secure area!", в другому випадку -
що відображається повідомлення про неправильний логін/пароль*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.openqa.selenium.By.cssSelector;

public class Login {
    WebDriver driver = new ChromeDriver();
    @Test
    public void validLogin() {

        driver.findElement(By.xpath("//label[text()='Username']/../input")).click();
        driver.findElement(By.xpath("//label[text()='Username']/../input")).sendKeys("tomsmith");
        driver.findElement(By.xpath("//label[text()='Password']/../input")).click();
        driver.findElement(By.xpath("//label[text()='Password']/../input")).sendKeys("SuperSecretPassword!");

        driver.findElement(cssSelector(".fa")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".success")).getText().contains("You logged into a secure area!"));

    }

    @Test
    public void invalidLogin() {
        driver.findElement(By.xpath("//label[text()='Username']/../input")).click();
        driver.findElement(By.xpath("//label[text()='Username']/../input")).sendKeys("invalidUsername");
        driver.findElement(By.xpath("//label[text()='Password']/../input")).click();
        driver.findElement(By.xpath("//label[text()='Password']/../input")).sendKeys("invalidPassword");

        driver.findElement(cssSelector(".fa")).click();

        Assert.assertTrue(driver.findElement(By.cssSelector(".error")).getText().contains("Your username is invalid!"));
    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterTest
    public void AfterTest() {
        driver.close();
    }
}
