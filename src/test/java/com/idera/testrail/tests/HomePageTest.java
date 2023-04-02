package com.idera.testrail.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;


public class HomePageTest {

    public static WebDriver driver;

    @BeforeMethod
    void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--window-size=1920,1080");
        options.addArguments("--start-maximized");
        options.addArguments("--no-proxy-server");
        options.addArguments("disable-infobars"); // disabling infobars
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-extensions"); // disabling extensions
        options.addArguments("--disable-dev-shm-usage"); // overcome limited resource problems
        options.addArguments("--no-sandbox"); // Bypass OS security model
        driver = new ChromeDriver(options);
        driver.navigate().to("https://www.gurock.com/testrail");
    }

    @Test
    public void verifyTitleOfHomePage() {
        assertTrue(driver.getTitle().contains("TestRail"));
    }

    @Test
    void verifyPresenceOfDemoLinkOnHomePage() {
        By demoButtonSelector = By.linkText("Get a Demo");
        WebElement demoButton = driver.findElement(demoButtonSelector);
        assertTrue(demoButton.isDisplayed());
    }

    @Test
    void invalidTest() {
        assertTrue(driver.getTitle().contains("WRONG TITLE"));
    }


    @AfterMethod
    void tearDown() {
        driver.quit();
    }
}
