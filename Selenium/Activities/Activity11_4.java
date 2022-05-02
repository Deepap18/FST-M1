package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class Activity11_4 {
    //main function
    public static void main(String[] args) {
        //webdriver instance
        WebDriver driver = new FirefoxDriver();

        //wait object creation

        WebDriverWait wait = new WebDriverWait(driver,20);

        //open the URL
        driver.get("https://www.training-support.net/selenium/tab-opener");

        System.out.println("page title..."+driver.getTitle());

        //wait for visibility of the element
        wait.until(ExpectedConditions.elementToBeClickable(By.id("launcher")));

        //parent window handle
        String parentwindow = driver.getWindowHandle();

        System.out.println("Parent Window..."+parentwindow);
        //identify the element
        WebElement clkmebut = driver.findElement(By.className("blue"));

        //click the button
        clkmebut.click();

        //wait for the 2nd window to open
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        Set<String> windowids = driver.getWindowHandles();
        System.out.println("All window Handle..."+windowids);

        for(String multiplewindows : windowids){

            driver.switchTo().window(multiplewindows);
        }

        //print current window handle
        System.out.println("Current window Handle..."+driver.getWindowHandle());

        wait.until(ExpectedConditions.titleIs("Newtab"));

        //print the title
        System.out.println("current window title..."+driver.getTitle());

        String Newtabtext = driver.findElement(By.cssSelector("div.content")).getText();
        System.out.println("New tab text..."+Newtabtext);



    }
}
