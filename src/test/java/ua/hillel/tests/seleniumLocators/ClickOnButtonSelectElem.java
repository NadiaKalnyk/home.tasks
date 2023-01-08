package ua.hillel.tests.seleniumLocators;

/*потрібно знайти і клікнути по кожній кнопці, після чого
вибрати всі значення з 4го стовбця таблиці і вивести їх на екран*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class ClickOnButtonSelectElem {
    WebDriver driver = new ChromeDriver();
    @Test
    public void clickOnButtonsAndShowElemOf4Colum() {
        driver.findElement(By.cssSelector("div a:nth-of-type(1).button")).click();
        driver.findElement(cssSelector(".button.alert")).click();
        driver.findElement(cssSelector(".button.success")).click();


        List<Integer> list = new ArrayList<>();
        int numberOfElements = driver.findElements(By.xpath("//table/tbody/tr/td[4]")).size();
        for (int i = 1; i <= numberOfElements; i++) {
            WebElement elements = driver.findElement(cssSelector("tbody tr:nth-of-type(" + i + ") td:nth-of-type(4)"));
            System.out.println(elements.getText());
        }
    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://the-internet.herokuapp.com/challenging_dom ");

        }
    @AfterTest
    public void AfterTest() {
        driver.close();
    }
}
