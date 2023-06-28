package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.ThreadLocalRandom;

public class AT05LocatorsXpathTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.manage().window().maximize();

    }

    @Test
    public void testExercise() {

        driver.findElement(By.cssSelector("#top-links > ul > li.dropdown")).click();
        driver.findElement(By.xpath("//a[.=\"Register\"]")).click();
        driver.findElement(By.xpath("//*[@id=\"input-firstname\"]")).sendKeys("firstname");
        driver.findElement(By.xpath("//*[@id=\"input-lastname\"]")).sendKeys("lastname");
        driver.findElement(By.xpath("//*[@id=\"input-email\"]")).sendKeys(generateRandomEmail());
        driver.findElement(By.xpath("//*[@id=\"input-telephone\"]")).sendKeys("868600000");
        driver.findElement(By.xpath("//*[@id=\"input-password\"]")).sendKeys("test");
        driver.findElement(By.xpath("//*[@id=\"input-confirm\"]")).sendKeys("test");
        driver.findElement(By.xpath("//input[@name='agree']")).click();
        //press button submit
        int inputFields = driver.findElements(By.xpath("//input[contains(concat(' ',normalize-space(@class),' '),' form-control ')]")).size();
        System.out.println("Input fields: " + inputFields);
        int inputFieldsPersonal = driver.findElements(By.xpath("//*[@id=\"account\"]//input[@class=\"form-control\"]")).size();
        System.out.println("Input fields in personal details: " + inputFieldsPersonal);
        int elementsFormControl = driver.findElements(By.xpath("//input[@class=\"form-control\"]")).size();
        System.out.println("Elements with class attribute = \"form-control\": " + elementsFormControl);
        driver.close();
    }

    private String generateRandomEmail() {
        int randomNum = ThreadLocalRandom.current().nextInt(1, 9999);
        return "random" + randomNum + "@Email.com";
    }

    @AfterEach
    public void closeDriver() {

        driver.quit();
    }

}
