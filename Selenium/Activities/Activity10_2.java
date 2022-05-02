package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity10_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();

        WebDriverWait wait = new WebDriverWait(driver, 20);

        //open browser
        driver.get("https://www.training-support.net/selenium/input-events");
        System.out.println("page title..."+driver.getTitle());

        Actions act = new Actions(driver);

        WebElement pressedKey = driver.findElement(By.id("keyPressed"));
        Action sendchar = act.sendKeys("D").build();
        sendchar.perform();

        String charpassed;
        charpassed = pressedKey.getText();
        System.out.println("Char passed is : "+charpassed);

        Action copyandpastetext = act.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build();
        copyandpastetext.perform();

        charpassed = pressedKey.getText();

        System.out.println("text copy paste is : "+charpassed);
    }
}
