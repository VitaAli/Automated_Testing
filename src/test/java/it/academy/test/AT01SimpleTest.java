package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AT01SimpleTest {

    WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.manage().window().maximize();

    }

    @Test
    public void isEnabledSearchField() {

        WebElement isSearchEnable = driver.findElement(By.cssSelector("#search > input"));
        assertTrue(isSearchEnable.isEnabled(), "The search field is not enabled");

    }

    @Test
    public void isDisplayedSearchField() {

        WebElement isSearchDisplayed = driver.findElement(By.cssSelector("#search > input"));
        assertTrue(isSearchDisplayed.isDisplayed(), "The search field is not displayed");

    }

    @Test
    public void isDisplayedSearchButton() {

        WebElement searchButton = driver.findElement(By.xpath("//span/button"));
        assertTrue(searchButton.isDisplayed(), "The search button is not displayed");

    }

    @AfterEach
    public void closeDriver() {

        driver.quit();

    }


}
