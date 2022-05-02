package liveproject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class createnewjoblisting {

    WebDriver driver;
    WebDriverWait wait;

    @DataProvider(name = "newjobdetails")
    public static Object[][] newjobdetails() {
        return new Object[][] {
                { "abc@jhgft3.com", "TestAutomationSpecialist","Bangalore","abcd egf","test@test.com","xyz","http://xyz.com","abc sdf ghy","http://video.com","twitterusername" }

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
    @Test(dataProvider = "newjobdetails",dependsOnMethods = "openURL")
    public void createNewJob(String email, String jobtitle, String loc, String desc, String appemail, String compnme, String website, String tagline, String videourl, String twirunme){
        //WebElement searchkeywordtextbox = driver.findElement(By.id("search_keywords"));
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[text()='Post a Job']"))));
//
        driver.findElement(By.xpath("//a[text()='Post a Job']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='Post a Job']"))));

        driver.findElement(By.id("create_account_email")).sendKeys(email);

        driver.findElement(By.id("job_title")).sendKeys(jobtitle);
//
        driver.findElement(By.id("job_location")).sendKeys(loc);

        WebElement jbtyp = driver.findElement(By.id("job_type"));

        Select jobtype = new Select(jbtyp);

        jobtype.selectByVisibleText("Internship");

        driver.switchTo().frame("job_description_ifr");

        driver.findElement(By.id("tinymce")).sendKeys(desc);

        driver.switchTo().defaultContent();

        driver.findElement(By.id("application")).sendKeys(appemail);

        driver.findElement(By.id("company_name")).sendKeys(compnme);

        driver.findElement(By.id("company_website")).sendKeys(website);

        driver.findElement(By.id("company_tagline")).sendKeys(tagline);

        driver.findElement(By.id("company_video")).sendKeys(videourl);

        driver.findElement(By.id("company_twitter")).sendKeys(twirunme);

        driver.findElement(By.id("company_logo")).sendKeys("C:\\\\Users\\\\DEEPAPATIL\\\\Desktop\\\\Ford_Motor_Company-logo-CCFFCF5685-seeklogo.com.png");

        driver.findElement(By.name("submit_job")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.id("job_preview_submit_button")));

        driver.findElement(By.id("job_preview_submit_button")).click();

        driver.findElement(By.xpath("//a[text()='Jobs']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("search_keywords"))));

        driver.findElement(By.id("search_keywords")).sendKeys(jobtitle);

        driver.findElement(By.id("search_location")).sendKeys(loc);
    }

    @Test(dependsOnMethods = "createNewJob")
    public void searchjob() throws InterruptedException {

        Thread.sleep(3000);
        String jobtitleadded = driver.findElement(By.xpath("//h3[text()='TestAutomationSpecialist']")).getText();

        System.out.println("New job title added...."+jobtitleadded);
    }
    @AfterClass
    public void closeBrowser(){

        driver.close();

        //System.out.println("Runs Before every Method");
    }

}
