package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class loginbackendwebsite {
    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "authentication")
    public static Object[][] authentication() {
        return new Object[][] {
                { "root", "pa$$w0rd"}

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

        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

    }
    @Test(dataProvider = "authentication",dependsOnMethods = "openURL")
    public void loginToBackendWebsite(String username, String password){
        String title = driver.getTitle();
        wait.until(ExpectedConditions.titleIs(title));
        driver.findElement(By.id("user_login")).sendKeys(username);
        driver.findElement(By.id("user_pass")).sendKeys(password);
        driver.findElement(By.id("wp-submit")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Dashboard']"))));

        String loginsuccessful = driver.findElement(By.xpath("//h1[text()='Dashboard']")).getText();

        System.out.println("Loging successful ......."+loginsuccessful);

    }
    @AfterClass
    public void closeBrowser(){

        driver.close();
    }

}
