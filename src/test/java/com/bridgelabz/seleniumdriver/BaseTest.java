package com.bridgelabz.seleniumdriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

public class BaseTest
{
    public static final String FILE_PATH="/home/admin1/SeleniumDemo/src/test/resources/EmployeeData.xlsx";
    // Import excel sheet
    public static final String LOGIN_DATA_XLSX ="/home/admin1/SeleniumDemo/src/test/resources/LoginData.xlsx";
    // Creating a new instance of the Chrome driver
   public WebDriver driver;
   ChromeOptions chromeOptions=new ChromeOptions();
    @BeforeMethod(description = "Test to run driver")
    public void setUp()
    {
        chromeOptions.addArguments("--disable-notifications");
        System.setProperty("webdriver.chrome.driver", "Driver/chromedriver");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @AfterMethod(description = "Test to close driver")
    public void testCloseDriver()
    {
        //driver.close();;
    }
}
