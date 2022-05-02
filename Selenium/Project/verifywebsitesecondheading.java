package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifywebsitesecondheading {

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
        String secondwebsitehead = driver.findElement(By.xpath("//h2[text()='Quia quis non']")).getText();
        System.out.println("website image URL..."+secondwebsitehead);
        Assert.assertEquals(secondwebsitehead,"Quia quis non");
    }

    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }
}
