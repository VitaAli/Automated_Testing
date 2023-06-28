package it.academy.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AT12ImplicitWaitTest {

    WebDriver driver;

    @Test
    public void testExercise() {

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("(//span[contains(text(),'Add to Cart')])[2]")).click();
        driver.close();

    }
}
