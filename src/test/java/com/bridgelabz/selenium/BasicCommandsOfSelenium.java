package com.bridgelabz.selenium;
import com.bridgelabz.seleniumdriver.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.annotations.Test;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BasicCommandsOfSelenium extends BaseTest
{
    @Test(priority = 1)
    public void getTitle()
    {
        // Storing the Application Url in the String variable
        String webURL = "https://www.google.com";
        //Launch the Google WebSite
        driver.get(webURL);
        // Storing Title name in the String variable
        String title=driver.getTitle();
        System.out.println("Title of this page : "+title);
    }

    @Test
    public void testWebDriverMethods()
    {
        // Storing the Application Url in the String variable
        String webURL = "https://www.google.com";
        //Launch the Google WebSite
        driver.get(webURL);
        // Storing Title name in the String variable
        String title=driver.getTitle();
        System.out.println("Title of this page :" + title);
        // Storing URL in String variable
        String currentURL = driver.getCurrentUrl();
        System.out.println("The Current URL is : " + currentURL);
        // Storing Page Source in String variable
        String pageSource = driver.getPageSource();
        // Storing Page Source length in Int variable
        int pageSourceLength=pageSource.length();
        // Printing Page Source code on console
        System.out.println("The source code of this page is : " + pageSource);
        // Printing length of the Page Source on console
        System.out.println("The length of source code of this page is : "+pageSourceLength);
    }

    @Test
    public void savingScreenshots() throws IOException
    {
        // Storing the Application Url in the String variable
        String webURL = "https://www.google.com";
        //Launch the Google WebSite
        driver.get(webURL);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        String fileName =  new SimpleDateFormat("yyyy/MM/dd-hh:mm:ss'.png'").format(new Date());
        File destinationFile = new File("/home/admin1/SeleniumDemo/src/test/resources/Screenshots.png"+fileName);
        FileUtils.copyFile(sourceFile, destinationFile);
    }

    @Test
    public void browserNavigation() throws InterruptedException
    {
        // Storing the Application Url in the String variable
        String webURL="http://localhost8080/login.do";
        //Launch the Facebook Site
        driver.get(webURL);
        // Open Gmail web site
        driver.navigate().to("https://www.gmail.com");
        Thread.sleep(2000);
        //Go back to home page
        driver.navigate().back();
        Thread.sleep(2000);
        //Go forword to Registration page
        driver.navigate().forward();
        Thread.sleep(2000);
        //Refresh Browser
        driver.navigate().refresh();
    }

    @Test
    public void browserNavigationUsingFindElement() throws InterruptedException
    {
        // Storing the Application Url in the String variable
        String webURL="http://www.google.com";
        //Launch the Facebook Site
        driver.get(webURL);
        driver.findElement(By.xpath("//*[@id=\"gbw\"]/div/div/div[1]/div[1]/a")).click();
        Thread.sleep(2000);
        //Go back to home page
        driver.navigate().back();
        Thread.sleep(2000);
        //Go forword to Registration page
        driver.navigate().forward();
        Thread.sleep(2000);
        //Refresh Browser
        driver.navigate().refresh();
    }

    @Test
    public void handlingMouseAndKeyboardOperations() throws AWTException
    {
        // Storing the Application Url in the String variable
        String webURL="http://localhost8080/login.do";
        //Launch the Facebook Site
        driver.get(webURL);
        // Open Gmail web site
        driver.navigate().to("https://www.gmail.com");
        //Creating object of Robot class
        Robot robot=new Robot();
        //move the mouse by x and y coordinate
        robot.mouseMove(300,500);
        //Press Alt Key from Keyboard
        robot.keyPress(KeyEvent.VK_ALT);
        //Press F key from keyboard
        robot.keyPress(KeyEvent.VK_F);
        //Release F key from keyboard
        robot.keyRelease(KeyEvent.VK_F);
        //Release Alt key from keyboard
        robot.keyRelease(KeyEvent.VK_ALT);
    }

    @Test
    public void testLocatorsForWebDriver_ByTagName()
    {
        // Storing the Application Url in the String variable
        String webURL = "http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.name("firstname")).sendKeys("Deepali");
        driver.findElement(By.name("lastname")).sendKeys("Patil");
        //id locator for next button
        WebElement webElement = driver.findElement(By.tagName("button"));
        webElement.click();
    }


}
