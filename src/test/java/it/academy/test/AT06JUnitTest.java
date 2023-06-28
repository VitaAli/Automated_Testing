package it.academy.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.*;

public class AT06JUnitTest {

    WebDriver driver;

    @Test
    public void test() {
//        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://op.akademijait.vtmc.lt/");

        driver.findElement(By.id("wishlist-total")).click();
//        TODO: (1) Change it to AssertSame
        int expectedSearch = 1;
        int actualSearch = driver.findElements(By.id("search")).size();
        assertSame(expectedSearch, actualSearch, "Unexpected number of Search Box/es");

        String actualText = driver.findElement(By.id("wishlist-total")).getText();
//        TODO: (2) Change it to AssertEquals and compare with expected "Wish List (0)"
        String expectedText = "Wish List (0)";
        assertEquals(expectedText, actualText, "Unexpected Wish List text");

        WebElement emailElement = driver.findElement(By.id("input-email"));
        String email = "";
        emailElement.sendKeys(email);
//        TODO: (3) Change it to AssertNotNull
        assertNotNull(emailElement.getAttribute("value"), "E-mail address cannot be null");

        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
//        TODO: (4) Change it to AssertTrue
        assertTrue(cartElement, "Cart button is not displayed");

        driver.findElement(By.linkText("Register")).click();
        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
        //TODO: (5) Change it to AssertFalse
        assertFalse(agreeElement, "Agree checkbox is selected");
        driver.quit();
    }
}
