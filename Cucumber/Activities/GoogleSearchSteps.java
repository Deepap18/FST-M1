package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearchSteps {
    WebDriver driver;
    WebDriverWait wait;
    @Given("^ Statement set in Feature file for Given $")
    public void launchGooglePage() {
        driver = new FirefoxDriver();
        wait =  new WebDriverWait(driver, 20);
        driver.get("https://www.google.com/");
    }

    @When("^ Statement set in Feature file for When $")
    public void searchForCheese() {
        driver.findElement(By.name("q")).sendKeys("Cheese", Keys.RETURN);
    }

    @Then("^ Statement set in Feature file for Then $")
    public void thenFunctionName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("result-stats")));
        String resultStats = driver.findElement(By.id("result-stats")).getText();
        System.out.println("Number of results found: " + resultStats);
    }
    @And("^Close the browser$")
    public void closeTheBrowser() throws Throwable {
        driver.close();
    }
}
