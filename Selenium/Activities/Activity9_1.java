package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Activity9_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://www.training-support.net/selenium/selects");

        WebElement value_selected = driver.findElement(By.id("single-value"));
        WebElement single_select = driver.findElement(By.id("single-select"));
        Select select = new Select(single_select);

        select.selectByVisibleText("Option 2");
        System.out.println("2nd value selected by visible text : "+value_selected.getText());

        select.selectByIndex(3);
        System.out.println("3rd value selected by Index : "+value_selected.getText());

        select.selectByValue("4");
        System.out.println("4th value selected by value : "+value_selected.getText());

        List<WebElement> alldropdownvalues = select.getOptions();
        for(WebElement drpvalues : alldropdownvalues){
            System.out.println("All dropdown values : "+drpvalues.getText());
        }

        driver.close();
    }
}
