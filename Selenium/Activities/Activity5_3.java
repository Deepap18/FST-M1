package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement textbox = driver.findElement(By.id("dynamicText"));
        System.out.println("is textbox enabled : "+textbox.isEnabled());

        driver.findElement(By.id("toggleInput")).click();

        System.out.println("is textbox enabled : "+textbox.isEnabled());

        driver.close();
    }
}
