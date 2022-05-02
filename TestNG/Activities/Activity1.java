package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;
        @BeforeMethod
    public void setup(){
             driver = new FirefoxDriver();
            driver.get("https://www.training-support.net");
        }
        @Test
    public void openURL(){
            String pageURL = driver.getTitle();
            System.out.println("Page URL : "+pageURL);
            Assert.assertEquals(pageURL,"Training Support");
            driver.findElement(By.id("about-link")).click();
            String newpageURL = driver.getTitle();
            System.out.println("Page URL : "+newpageURL);
        }
        @AfterMethod
    public void cleanUp(){
            driver.close();
        }
}
