package com.bridgelabz.selenium;
import com.bridgelabz.seleniumdriver.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FacebookSeleniumTest extends BaseTest
{
    @Test
    public void testLocatorsForWebDriver_UsingByIDLocator_Login()
    {
        // Storing the Application Url in the String variable
        String webURL="http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.id("email")).sendKeys("8412989861");
        driver.findElement(By.id("pass")).sendKeys("8412989861");
        //id locator for next button
        WebElement webElement=driver.findElement(By.id("loginbutton"));
        webElement.click();
    }

    @Test
    public void testLocatorsForWebDriver_UsingByNameLocator_Logout() throws InterruptedException
    {
        // Storing the Application Url in the String variable
        String webURL = "http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.name("email")).sendKeys("8412989861");
        driver.findElement(By.name("pass")).sendKeys("lokesh@84");
        //id locator for next button
        WebElement loginbutton = driver.findElement(By.id("loginbutton"));
        loginbutton.click();
        Thread.sleep(2000);
        WebElement dragDownToLogoutButton = driver.findElement(By.xpath("//div[@id='userNavigationLabel']"));
        dragDownToLogoutButton.click();
        WebElement logoutButton = driver.findElement(By.xpath("//li[@class='_54ni navSubmenu _6398 _64kz __MenuItem']"));
        logoutButton.click();
    }

    @Test
    public void testLocatorsForWebDriver_ByLinkText()
    {
        // Storing the Application Url in the String variable
        String webURL="http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.name("email")).sendKeys("8412989861");
        driver.findElement(By.linkText("Forgotten account?")).click();
    }

    @Test
    public void testFacebookCheckBox() {
        // Storing the Application Url in the String variable
        String webURL = "http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.name("firstname")).sendKeys("Deepali");
        driver.findElement(By.name("lastname")).sendKeys("Patil");
        WebElement radioButton=driver.findElement(By.id("u_0_9"));
        radioButton.click();
        WebElement webElement = driver.findElement(By.tagName("button"));
        webElement.click();
    }

    @Test
    public void testFacebookRadioButtonForBirthDate() {
        // Storing the Application Url in the String variable
        String webURL = "http://login.facebook.com";
        //Launch the Facebook Site
        driver.get(webURL);
        //id locator for text box
        driver.findElement(By.name("firstname")).sendKeys("Deepali");
        driver.findElement(By.name("lastname")).sendKeys("Patil");
        WebElement date=driver.findElement(By.xpath("//select[@id='day']"));
        date.click();
        driver.findElement(By.id("day")).sendKeys("02");
        /*driver.findElement(By.id("day")).sendKeys("02");
        driver.findElement(By.id("month")).sendKeys("05");
        driver.findElement(By.id("year")).sendKeys("1994");*/
        WebElement radioButton=driver.findElement(By.id("u_0_9"));
        radioButton.click();
        WebElement webElement = driver.findElement(By.tagName("button"));
        webElement.click();
    }
}
