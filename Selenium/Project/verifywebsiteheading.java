package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifywebsiteheading {

    WebDriver driver;
    @BeforeClass
    public void launchBrowser(){

        driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //System.out.println("Runs Before every Method");
    }

    @Test
    public void openURL(){

        driver.get("https://alchemy.hguy.co/jobs/");

    }

    @Test
    public void verifyHeading(){
        String websiteheading = driver.findElement(By.className("entry-title")).getText();
        System.out.println("websiteheading..."+websiteheading);
        Assert.assertEquals(websiteheading,"Welcome to Alchemy Jobs");
    }

    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }
}
