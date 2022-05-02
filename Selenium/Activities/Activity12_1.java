package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_1 {
    public static void main(String[] args) {
        //webdriver instance
        WebDriver driver = new FirefoxDriver();

        //wait object creation

        WebDriverWait wait = new WebDriverWait(driver,20);

        //open the URL
        driver.get("https://www.training-support.net/selenium/iframes");

        System.out.println("page title..."+driver.getTitle());

        driver.switchTo().frame(0);

        WebElement frame0 = driver.findElement(By.xpath("//div[@class='content']"));
        System.out.println("frame0 content : "+frame0.getText());

        WebElement frameclick = driver.findElement(By.id("actionButton"));
        frameclick.click();
        System.out.println("frame1 text : "+frameclick.getText());
        System.out.println("frame1 button colour : "+frameclick.getCssValue("background-color"));

        driver.switchTo().defaultContent();

        driver.switchTo().frame(1);

        WebElement frame1 = driver.findElement(By.xpath("//div[@class='content']"));
        System.out.println("frame0 content : "+frame1.getText());
        WebElement frameclick1 = driver.findElement(By.id("actionButton"));
        frameclick1.click();
        System.out.println("frame0 text : "+frameclick1.getText());
        System.out.println("frame0 button colour : "+frameclick1.getCssValue("background-color"));

        driver.close();
    }
}
