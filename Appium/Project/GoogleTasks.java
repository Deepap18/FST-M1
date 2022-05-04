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
import java.util.List;

public class GoogleTasks {

    WebDriverWait wait;
    AndroidDriver<MobileElement> driver = null;

    @BeforeClass
    public void beforeClass() throws MalformedURLException {
        // Set the Desired Capabilities
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "RZ8M93DMJSZ");
        caps.setCapability("platformName", "android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.tasks");
        caps.setCapability("appActivity", ".ui.TaskListsActivity");
        caps.setCapability("noReset", true);

        // Instantiate Appium Driver
        URL appServer = new URL("http://0.0.0.0:4723/wd/hub");
        driver = new AndroidDriver<MobileElement>(appServer, caps);
        wait = new WebDriverWait(driver, 10);

        // Open page
        //driver.get("https://www.training-support.net/selenium");
    }

    @Test
    public void newtasks(){
        //click on new tasks button
        driver.findElementById("tasks_fab").click();
        //wait for the edit text box
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        //enter the text
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Tasks");
        //click on save
        driver.findElementById("add_task_done").click();

        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        //get the text of the task is added
        String task1 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Tasks\"]/android.view.ViewGroup/android.widget.TextView").getText();

        Assert.assertEquals(task1,"Complete Activity with Google Tasks");
        //wait for the edit text box
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        //enter the text
        driver.findElementById("add_task_title").sendKeys("Complete the second Activity Google Keep");
        //click on save
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        String task2 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete the second Activity Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();

        Assert.assertEquals(task2,"Complete the second Activity Google Keep");

        //wait for the edit text box
        driver.findElementById("tasks_fab").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("add_task_title")));

        //enter the text
        driver.findElementById("add_task_title").sendKeys("Complete Activity with Google Keep");
        //click on save
        driver.findElementById("add_task_done").click();
        wait.until(ExpectedConditions.elementToBeClickable(MobileBy.id("tasks_fab")));
        String task3 = driver.findElementByXPath("//android.widget.FrameLayout[@content-desc=\"Complete Activity with Google Keep\"]/android.view.ViewGroup/android.widget.TextView").getText();

        Assert.assertEquals(task3,"Complete Activity with Google Keep");

        //String task1name = driver.findElementById("task_name").getText();
//        int count = 0;
//        List<MobileElement> textItems = driver.findElementsByClassName("android.widget.TextView");
//        for(MobileElement textItem : textItems) {
//            if(textItem.getText().equalsIgnoreCase("Complete Activity with Google Tasks")){
//                count = +count;
//            }
//            System.out.println(textItem.getText());
//
//        }

        //Assert.assertEquals(task1name,"Complete Activity with Google Tasks");

    }
}
