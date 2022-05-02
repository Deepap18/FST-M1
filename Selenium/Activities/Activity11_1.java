package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("page title..."+driver.getTitle());

        driver.findElement(By.id("simple")).click();
        Alert alt = driver.switchTo().alert();
        System.out.println("Alert message : "+alt.getText());
        alt.accept();

        driver.close();

    }
}
