package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AT08AddHooksTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
    }

    @Test
    public void accountCanBeRegistered() {
//test
//TODO add account register logic

    }

    @Test
    public void unauthorizedUserCantOpenWishList() {
        driver.findElement(By.id("wishlist-total")).click();
        assertTrue(driver.findElement(By.cssSelector("#account-login")).isDisplayed());
    }

    @AfterEach
    public void close() {
        driver.close();
    }
}
