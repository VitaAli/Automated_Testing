package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AT03SeleniumBasicsTest {

    private static WebDriver driver;

    @BeforeEach
    public void setUp() {

        driver = new ChromeDriver();
        driver.get("https://op.akademijait.vtmc.lt/");
        driver.manage().window().maximize();

    }

    @Test
    public void testExercise() {

        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MaxBook");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
        boolean isSearchDisplayed = driver.findElement(By.xpath("//*[@id=\"button-search\"]")).isDisplayed();
        System.out.println("The button search is displayed: " + isSearchDisplayed);
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).clear();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).sendKeys("MacBook");
        driver.findElement(By.xpath("//*[@id=\"search\"]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"search\"]/input")).clear();
        System.out.println("Number of searched elements: " + driver.findElements(By.cssSelector(".product-layout")).size());
        Select clickSortBy = new Select(driver.findElement(By.xpath("//*[@id=\"input-sort\"]")));
        clickSortBy.selectByIndex(3); //ask why cannot select next to new select
        String printSelected = new Select(driver.findElement(By.xpath("//*[@id=\"input-sort\"]")))
                .getFirstSelectedOption().getText();
        System.out.println("Selected option: " + printSelected);

    }

    @AfterEach
    public void quit() {

        driver.quit();

    }
}
