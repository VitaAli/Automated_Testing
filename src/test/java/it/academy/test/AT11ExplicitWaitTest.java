package it.academy.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AT11ExplicitWaitTest {

    WebDriver driver;

    @Test
    public void testExercise() {


        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[2]")).click();

        //EXPLICIT LAUKIA KOL ELEMENTAS PASIDARYS VISABILITY
//        WebElement explicitWaiter = new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert-success")));

        new WebDriverWait(driver, Duration.ofSeconds(3)).until(dr -> ((Long) ((JavascriptExecutor) dr)
                .executeScript("return jQuery.active") == 0));
        WebElement successMessage = driver.findElement(By.cssSelector(".alert-success"));

        Assertions.assertTrue(successMessage.isDisplayed(), "No success message");

        driver.close();

    }
}
