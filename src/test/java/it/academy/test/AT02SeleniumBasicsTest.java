package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AT02SeleniumBasicsTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.manage().window().maximize();
    }

    @Test
    public void testExercise() {

        driver.findElement(By.cssSelector("#wishlist-total")).click();
        int wishSize = driver.findElements(By.cssSelector("#search")).size();
        System.out.println("Number of searches: " + wishSize);
        driver.findElement(By.cssSelector("#input-email")).sendKeys("email@email.com");
        driver.findElement(By.cssSelector("#input-email")).clear();
        driver.findElement(By.cssSelector("input[type=\"submit\"]")).click();
        driver.findElement(By.linkText("Continue")).click();
        System.out.println("The password field is enabled: " + driver.findElement(By.cssSelector("#input-password")).isEnabled());
        System.out.println("The password field is displayed: " + driver.findElement(By.cssSelector("#cart-total")).isDisplayed());
        System.out.println("The password field is selected: " + driver.findElement(By.cssSelector("input[name=\"agree\"]")).isSelected());
        driver.findElement(By.linkText("Desktops")).click();
        driver.findElement(By.linkText("Show All Desktops")).click();
        Select selectedItems25 = new Select(driver.findElement(By.cssSelector("#input-limit")));
        selectedItems25.selectByIndex(1);
        String printing2ndOp = new Select(driver.findElement(By.cssSelector("#input-limit"))).getFirstSelectedOption().getText();
        System.out.println("Selected option: " + printing2ndOp);
        Select selectedItems4th = new Select(driver.findElement(By.cssSelector("#input-limit")));
        selectedItems4th.selectByIndex(3);
        String printing4thOp = new Select(driver.findElement(By.cssSelector("#input-limit"))).getFirstSelectedOption().getText();
        System.out.println("Selected option: " + printing4thOp);

    }

    @AfterEach
    public void quit() {

        driver.quit();

    }
}
