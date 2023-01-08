package ua.hillel.tests.seleniumLocators;

/*вивести на екран початковий стан чекбоксів (вибраний чи ні), потім вибрати обидва.*/

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class Checkboxes {
    WebDriver driver = new ChromeDriver();
    @Test
    public void CheckUncheck () {

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
        for(int i = 0; i < checkboxes.size(); i++)
            System.out.println("Checkbox #" + (i+1) + " is " + (checkboxes.get(i).isSelected() ? "selected" : "unselected"));
    }

    @Test (dependsOnMethods="CheckUncheck")
    public void allAreChecked() {

        List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@id='checkboxes']/input"));
        for (WebElement checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                System.out.println("ERROR: all checkboxes are selected");
            } else {
                checkbox.click();
            }
        }
    }
    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver.get("https://the-internet.herokuapp.com/checkboxes");

    }
    @AfterTest
    public void AfterTest() {
        driver.close();
    }
}
