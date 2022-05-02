package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class backendjoblisting {

    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "authentication")
    public static Object[][] authentication() {
        return new Object[][] {
                { "root", "pa$$w0rd"}

        };
    }

    @DataProvider(name = "jobformfilldata")
    public static Object[][] jobformfilldata() {
        return new Object[][] {
                { "jobposition1","mnb@tyu.com", "comp@comp.com", "comptwitr@comptwitr.com", "April 8,2022", "Bangalore", "IBM", "abcdefgh" }

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
    @Test(dataProvider = "jobformfilldata",dependsOnMethods = "loginToBackendWebsite")
    public void addNewJob(String position,String appemail,String company_website, String company_twitter, String job_expires, String job_location, String company_name, String company_tagline) throws InterruptedException {

        System.out.println("Inside  addNewJob method.......");

        Actions act = new Actions(driver);

        WebElement menu = driver.findElement(By.xpath("//div[text()='Job Listings ']"));
        act.moveToElement(menu).perform();

        System.out.println("menu element ....    "+menu.getText());

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='All Jobs']"))));
        WebElement submenu = driver.findElement(By.xpath("//a[text()='All Jobs']"));
        act.moveToElement(submenu).perform();
        act.click().build().perform();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='page-title-action']")));
        //Thread.sleep(3000);

        driver.findElement(By.xpath("//a[@class='page-title-action']")).click();

        //Thread.sleep(3000);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@aria-label='Close dialog']//*[name()='svg']")));
        driver.findElement(By.xpath("//button[@aria-label='Close dialog']//*[name()='svg']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Job Data']")));

        driver.findElement(By.xpath("//textarea[@id='post-title-0']")).sendKeys(position);

        //driver.findElement(By.xpath("//p[normalize-space()='asdsfdsf']")).sendKeys(position);

        driver.findElement(By.xpath("//input[@id='_application']")).sendKeys(appemail);

        driver.findElement(By.xpath("//input[@id='_company_website']")).sendKeys(company_website);

        driver.findElement(By.xpath("//input[@id='_company_twitter']")).sendKeys(company_twitter);

        driver.findElement(By.xpath("//input[@id='_filled']")).click();

        driver.findElement(By.xpath("//input[@id='_job_expires']")).sendKeys(job_expires);

        driver.findElement(By.xpath("//input[@id='_job_location']")).sendKeys(job_location);

        driver.findElement(By.xpath("//input[@id='_company_name']")).sendKeys(company_name);

        driver.findElement(By.xpath("//input[@id='_company_tagline']")).sendKeys(company_tagline);

        driver.findElement(By.xpath("//input[@id='_company_video']")).sendKeys("C:\\Users\\DEEPAPATIL\\Desktop");

        driver.findElement(By.xpath("//button[contains(text(),'Publish…')]")).click();

       // driver.findElement(By.xpath("//button[contains(text(),'Publish…')]")).click();

        driver.findElement(By.xpath("//button[normalize-space()='Publish']")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='components-button is-secondary']")));

        driver.findElement(By.xpath("//a[@class='components-button is-secondary']")).click();

        String jobtitle = driver.findElement(By.xpath("//h1[@class='entry-title']")).getText();

        Assert.assertEquals(jobtitle,position);
    }
}
