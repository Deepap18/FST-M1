package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
public class Activity6_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://training-support.net/selenium/dynamic-controls");
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        WebElement checkbox = driver.findElement(By.xpath("//input[@name='toggled']"));
        WebElement checkboxbutton = driver.findElement(By.id("toggleCheckbox"));

        System.out.println("checkbox : "+checkbox.isDisplayed());
        System.out.println("checkbox : "+checkboxbutton.getText());
        checkboxbutton.click();
        wait.until(ExpectedConditions.invisibilityOf(checkbox));

        checkboxbutton.click();
        wait.until(ExpectedConditions.visibilityOf(checkbox));

        checkboxbutton.click();

        driver.close();

    }
}
