package com.bridgelabz.selenium;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class WebDriverCommands extends BaseTest
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
    public void testMethods()
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
}
