package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Activity12_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        //open the URL
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        System.out.println("page title..."+driver.getTitle());
        //switch to the parent frame
        driver.switchTo().frame(0);
        //switch to the inner first frame
        driver.switchTo().frame(0);

        WebElement innerframe0 = driver.findElement(By.xpath("//div[@class='content']"));
        System.out.println("innerframe0 content is : "+innerframe0.getText());

        WebElement frame0button = driver.findElement(By.id("actionButton"));
        frame0button.click();
        System.out.println("innerframe0 content is : "+frame0button.getText());
        System.out.println("innerframe0 content is : "+frame0button.getCssValue("background-color"));

        //switch to the parent frame
        driver.switchTo().defaultContent();

        //switch to 1st frame
        driver.switchTo().frame(0);
        //switch to 2nd frame
        driver.switchTo().frame(1);
        WebElement innerframe1 = driver.findElement(By.xpath("//div[@class='content']"));
        System.out.println("innerframe1 content is : "+innerframe1.getText());

        WebElement frame1button = driver.findElement(By.id("actionButton"));
        frame1button.click();
        System.out.println("innerframe1 content is : "+frame1button.getText());
        System.out.println("innerframe1 content is : "+frame1button.getCssValue("background-color"));


        driver.switchTo().defaultContent();

        driver.close();


    }
}
