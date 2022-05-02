package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity7_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://training-support.net/selenium/dynamic-attributes");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement username = driver.findElement(By.xpath("//input[contains(@class, '-username')]"));
        WebElement password = driver.findElement(By.xpath("//input[contains(@class, '-password')]"));

        username.sendKeys("Deepa");
        password.sendKeys("Patil");

        WebElement confirmpassword = driver.findElement(By.xpath("//label[text()='Confirm Password']/following::input"));
        confirmpassword.sendKeys("Patil");

        WebElement email = driver.findElement(By.xpath("//input[starts-with(@class,'email-')]"));
        email.sendKeys("abc@def.com");

        driver.findElement(By.xpath("//button[@onclick='signUp()']")).click();


    }
}
