package com.bridgelabz.selenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest
{
    // Creating a new instance of the Chrome driver
    WebDriver driver;

    @BeforeMethod(description = "Test to run driver")
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterMethod(description = "Test to close driver")
    public void testCloseDriver()
    {
        driver.close();;
    }
}
