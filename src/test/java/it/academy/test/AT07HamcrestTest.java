package it.academy.test;

import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AT07HamcrestTest {

    WebDriver driver;

    @Test
    public void test() {
//        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://op.akademijait.vtmc.lt/index.php?route=account/forgotten");
        driver.findElement(By.id("wishlist-total")).click();
        //TODO: (1) Change it to compare size using is() matcher
        System.out.println("Number of Search Box/es:" + driver.findElements(By.id("search")).size());
        int actualSize = driver.findElements(By.id("search")).size();
        assertThat("Unexpected number of Search Box/es", actualSize, is(1));

        String listElement = driver.findElement(By.id("wishlist-total")).getText();
        //TODO: (2) Change it to compare text using is(equalTo()) matcher and compare with expected "Wish List (0)" (Hamcrest)
        System.out.println("Element name is: " + listElement);

        WebElement emailElement = driver.findElement(By.id("input-email"));
        String email = "testing123";
        emailElement.sendKeys(email);
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        emailElement = driver.findElement(By.id("input-email"));
        //TODO: (3) Change it to use allOf( is(equalTo()) and containsString()) matchers
        System.out.println("Password field text is: " + emailElement.getText());

        boolean cartElement = driver.findElement(By.id("cart")).isDisplayed();
        //TODO: (4) Change it to compare boolean value with is() matcher
        System.out.println("Is Cart button displayed: " + cartElement);

        driver.findElement(By.linkText("Register")).click();

        boolean agreeElement = driver.findElement(By.name("agree")).isSelected();
        //TODO: (5) Change it to is(not()) matcher
        System.out.println("Is Agree checkbox selected: " + agreeElement);
        driver.close();
    }
}
