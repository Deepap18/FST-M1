package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class applytojob {

    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "jobsearch")
    public static Object[][] credentials() {
        return new Object[][] {
                { "TestPosition", "Bangalore" }

        };
    }
    @BeforeClass
    public void launchBrowser(){

        driver = new FirefoxDriver();

        wait = new WebDriverWait(driver, 30);

        //System.out.println("Runs Before every Method");
    }
    @Test
    public void openURL(){

        driver.get("https://alchemy.hguy.co/jobs/");

    }
    @Test(dataProvider = "jobsearch",dependsOnMethods = "openURL")
    public void verifyJobPage(String position, String location){

        driver.findElement(By.xpath("//a[text()='Jobs']")).click();
       //WebElement searchkeywordtextbox = driver.findElement(By.id("search_keywords"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_keywords"))));

        driver.findElement(By.id("search_keywords")).sendKeys(position);

        driver.findElement(By.id("search_location")).sendKeys(location);

        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();

    }
    @Test(dependsOnMethods = "verifyJobPage")
    public void entervalueforsearch() throws InterruptedException {

       // wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//h3[text()='TestPosition']"))));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h3[text()='TestPosition']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("entry-title"))));

        driver.findElement(By.xpath("//input[@value='Apply for job']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.className("job_application_email"))));

        String emailtext = driver.findElement(By.className("job_application_email")).getText();

        System.out.println("emailtext value is......"+emailtext);

    }

    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }
}
