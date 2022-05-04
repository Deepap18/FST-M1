package liveproject;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleKeep {

    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RZ8M93DMJSZ");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.keep");
        caps.setCapability("appActivity", ".activities.BrowseActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

    }

    @Test
    public void addnote(){
        driver.findElementById("new_note_button").click();
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("editable_title")));
        //enter the title
        String notestitle = "NotesTitle";
        driver.findElementById("editable_title").sendKeys(notestitle);
        //enter the desc
        driver.findElementById("edit_note_text").sendKeys("Test Notes for mobile automation");

        //click on back button
        driver.findElementByAccessibilityId("Open navigation drawer").click();

        //wait for the notes to be added
        wait.until(ExpectedConditions.presenceOfElementLocated(MobileBy.id("index_note_title")));

        String notesadded = driver.findElementById("index_note_title").getText();
        //Assert to check if the notes added
        Assert.assertEquals(notesadded,notestitle);

    }
}
