package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_3 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("page title..."+driver.getTitle());

        WebElement confirm = driver.findElement(By.id("prompt"));
        confirm.click();
        Alert alt = driver.switchTo().alert();
        alt.sendKeys("Yes, you are!");
        alt.accept();

        driver.close();
    }
}
