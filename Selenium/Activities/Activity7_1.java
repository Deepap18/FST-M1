package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement username = driver.findElement(By.xpath("//input[starts-with(@class,'username')]"));
        WebElement password = driver.findElement(By.xpath("//input[starts-with(@class,'password-')]"));
        username.sendKeys("admin");
        password.sendKeys("password");
        password.getAttribute("class");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("action-confirmation"))));

        String loginMessage = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login message: " + loginMessage);

        driver.close();

        String confirmation_msg = driver.findElement(By.id("action-confirmation")).getText();
        System.out.println("Login confirmation message : "+confirmation_msg);

        driver.close();
    }
}
