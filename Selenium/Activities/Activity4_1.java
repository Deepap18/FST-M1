package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://www.training-support.net");
        String pagetitle = driver.getTitle();
        System.out.println("Webpage title is : "+pagetitle);
        driver.findElement(By.xpath("//a[@id='about-link']")).click();
        System.out.println("title of the next page is  : "+driver.getTitle());

        driver.close();
    }
}
