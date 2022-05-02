package liveproject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class verifytitle {

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

    @Test(dependsOnMethods = {"openURL"})
    public void verifyTitle(){

        String title = driver.getTitle();
        Assert.assertEquals(title,"Alchemy Jobs – Job Board Application");
    }

    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }
}
