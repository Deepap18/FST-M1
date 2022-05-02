package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TagExample extends BaseClass {
    // Given statement
    @Given("^User is on TS homepage$")
    public void openTSHomepage() {
        driver.get("https://training-support.net");

    }

    @When("^User clicks About Us button$")
    public void clickAboutUSButton() {
        driver.findElement(By.id("about-link")).click();


    }
    @Then("^About Us page should open$")
    public void verifyAboutUSPage() {
        String pageTitle = driver.findElement(By.xpath("//h1[class='v1 header']")).getText();
        Assert.assertEquals("About Us", pageTitle);
    }
}
