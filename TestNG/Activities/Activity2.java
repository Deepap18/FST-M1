package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @Test
    public void getTitle(){
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertEquals(title, "Target Practice");
    }
    @Test
    public void blackButton(){
        WebElement blackbutton = driver.findElement(By.xpath("//button[text()='Black']"));
        Assert.assertTrue(blackbutton.isDisplayed());
        Assert.assertEquals(blackbutton.getText(),"black");
    }
    @Test(enabled = false)
    public void skipbyEnable(){
        System.out.println("This method skips but does not print on console");
    }
    @Test
    public void skipException(){
        throw new SkipException("This testcase will be skipped and printed on console");
    }
    @AfterClass
    public void clean(){
        driver.close();
    }
}
