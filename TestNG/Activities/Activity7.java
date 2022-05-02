package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Activity7 {
    WebDriver driver;
    @DataProvider(name="loginAuthentication")
    public static Object[][] logincredentials(){
        return new Object[][] { { "admin", "password" }};
    }
    @BeforeClass
    public void setUp(){
        driver = new FirefoxDriver();

        //Open the browser
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @Test(dataProvider = "loginAuthentication")
    public void login(String username, String password){
        WebElement usernameField = driver.findElement(By.id("username"));
        WebElement passwordField = driver.findElement(By.id("password"));


        usernameField.sendKeys(username);
        passwordField.sendKeys(password);


        driver.findElement(By.cssSelector("button[type='submit']")).click();


        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(loginMessage, "Welcome Back, admin");

    }
    @AfterClass
    public void cleanUp(){
        driver.close();
    }
}
