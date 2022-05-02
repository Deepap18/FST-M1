package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity6_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://training-support.net/selenium/ajax");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        driver.findElement(By.xpath("//button[text()='Change Content']")).click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h1[text()='HELLO!']"))));

        String ajaxtext = driver.findElement(By.xpath("//h1[text()='HELLO!']")).getText();

        System.out.println("ajaxtext is : "+ajaxtext);

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));

        String latetext = driver.findElement(By.id("ajax-content")).getText();

        System.out.println("latetext is : "+latetext);

        driver.close();
    }
}
