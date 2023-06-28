package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AT09ParametrizedTest {
    WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    @ParameterizedTest
    @ValueSource(strings = {"Desktops", "Cameras"})
    public void isDisplayed(String item) {
        String formatted = String.format("//a[normalize-space()='%s']", item);
        boolean elementDisplayed = driver.findElement(By.xpath(formatted)).isDisplayed();
        assertTrue(elementDisplayed);
    }

//    Helper - https://www.baeldung.com/string/format
}
