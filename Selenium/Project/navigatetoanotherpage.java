package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class navigatetoanotherpage {

    WebDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void launchBrowser(){

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 20);

        //System.out.println("Runs Before every Method");
    }

    @Test
    public void openURL(){

        driver.get("https://alchemy.hguy.co/jobs/");

    }

    @Test
    public void verifyJobPageTitle(){
         driver.findElement(By.xpath("//a[text()='Jobs']")).click();
        wait.until(ExpectedConditions.titleIs("Jobs – Alchemy Jobs"));
        String title = driver.getTitle();
        System.out.println("title is..."+title);
        Assert.assertEquals(title,"Jobs – Alchemy Jobs");
    }

    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }
}
