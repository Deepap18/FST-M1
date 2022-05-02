package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver,20);
        driver.get("https://training-support.net/selenium/tables");

        List<WebElement> rows = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr"));
        List<WebElement> columns = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[1]/td"));
        System.out.println("no of rows in the table : "+rows.size());
        System.out.println("no of columns in the table : "+columns.size());

        List<WebElement> thirdcell = driver.findElements(By.xpath("//table[contains(@class,'striped')]/tbody/tr[3]/td"));

        for(WebElement thirdcellvalues : thirdcell){
            System.out.println("3rd cell values : "+thirdcellvalues.getText());
        }

        WebElement secrowseccolm = driver.findElement(By.xpath("//table[contains(@class, 'striped')]/tbody/tr[2]/td[2]"));
        System.out.println("Second row, second column value: " + secrowseccolm.getText());

        //Close browser
        driver.close();

    }
}
