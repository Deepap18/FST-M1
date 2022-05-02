package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/simple-form");
        String pagetitle = driver.getTitle();
        System.out.println("Webpage title is : "+pagetitle);
        WebElement firstname = driver.findElement(By.id("firstName"));
        firstname.sendKeys("Deepa");
        WebElement lastname = driver.findElement(By.id("lastName"));
        lastname.sendKeys("Patil");
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("abc@xyz.com");
        WebElement phone = driver.findElement(By.id("number"));
        phone.sendKeys("1234567894");
        driver.findElement(By.cssSelector(".ui.green.button")).click();
        driver.close();


    }
}
