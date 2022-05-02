package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement toggledcheckbox = driver.findElement(By.name("toggled"));
        System.out.println("is Toggled checkbox displayed : "+toggledcheckbox.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();

        System.out.println("is Toggled checkbox displayed : "+toggledcheckbox.isDisplayed());
    }
}
