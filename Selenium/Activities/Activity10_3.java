package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;
import java.time.Duration;

public class Activity10_3 {
    public static void main(String[] args) {
        //webdriver object
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //open browser
        driver.get("https://training-support.net/selenium/drag-drop");
        System.out.println("page title..."+driver.getTitle());

        //wait for ball to load
        wait.until(ExpectedConditions.elementToBeClickable(By.id("draggable")));

        WebElement ball = driver.findElement(By.xpath("//img[@id='draggable']"));

        WebElement dragball1 = driver.findElement(By.xpath("//div[@id='droppable']"));
        WebElement dragball2 = driver.findElement(By.xpath("//div[@id='dropzone2']"));

        Actions act = new Actions(driver);
        act.dragAndDrop(ball,dragball1).build().perform();

        wait.until(ExpectedConditions.attributeToBeNotEmpty(dragball1, "background-color"));
        System.out.println("ENTERED DROPZONE 1");

        act.dragAndDrop(dragball1,dragball2).build().perform();
        wait.until(ExpectedConditions.attributeToBeNotEmpty(dragball2, "background-color"));
        System.out.println("ENTERED DROPZONE 1");

        driver.close();

    }
}
