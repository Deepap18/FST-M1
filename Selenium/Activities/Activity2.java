package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity2 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net");

        String pagetitle = driver.getTitle();

        System.out.println("Page Title..."+pagetitle);

        WebElement aboutususingid = driver.findElement(By.id("about-link"));

        System.out.println("aboutususingid value..."+aboutususingid.getText());

        WebElement aboutususingclsname = driver.findElement(By.className("green"));

        System.out.println("aboutususingclsname value..."+aboutususingclsname.getText());

        WebElement aboutususinglnktxt = driver.findElement(By.linkText("About Us"));

        System.out.println("aboutususinglnktxt value..."+aboutususinglnktxt.getText());

        WebElement aboutususingcsssel = driver.findElement(By.cssSelector(".green"));

        System.out.println("aboutususingcsssel value..."+aboutususingcsssel.getText());

        driver.close();
    }
}
