package com.bridgelabz.selenium;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
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
        Date date = new Date();
        String date1 = date.toString();
        System.out.println(date1);
        String date2 = date1.replaceAll(":", "-");
        System.out.println(date2);
        // Storing the Application Url in the String variable
        String webURL = "https://www.google.com";
        //Launch the Google WebSite
        driver.get(webURL);
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
        File destinationFile = new File("/home/admin1/SeleniumDemo/src/test/resources/screenshot/Screenshots.png");
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
}
