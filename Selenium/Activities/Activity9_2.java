package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://www.training-support.net/selenium/selects");

        WebElement option_selected = driver.findElement(By.id("multi-value"));
        WebElement multiselect = driver.findElement(By.id("multi-select"));

        Select mulselect = new Select(multiselect);
        if(mulselect.isMultiple()){

            mulselect.selectByVisibleText("Javascript");
            System.out.println(option_selected.getText());

            mulselect.selectByValue("node");
            System.out.println(option_selected.getText());

            for(int i=4; i<=6; i++) {
                mulselect.selectByIndex(i);
            }
            System.out.println(option_selected.getText());

            mulselect.deselectByValue("node");
            System.out.println(option_selected.getText());

            mulselect.deselectByIndex(7);
            System.out.println(option_selected.getText());

            List<WebElement> selectedOptions = mulselect.getAllSelectedOptions();
            for(WebElement selectedOption : selectedOptions) {
                System.out.println("Selected option: " + selectedOption.getText());
            }

            mulselect.deselectAll();
            System.out.println(option_selected.getText());
        }


    }
}
