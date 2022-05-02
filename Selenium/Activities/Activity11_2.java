package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity11_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //open browser
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        System.out.println("page title..."+driver.getTitle());

        WebElement confirm = driver.findElement(By.id("confirm"));
        confirm.click();
        Alert alt = driver.switchTo().alert();
        System.out.println("Alert message : "+alt.getText());
        alt.accept();

        confirm.click();
        Alert alt2 = driver.switchTo().alert();
        alt2.dismiss();

        driver.close();
    }
}
