package stepDefinitions;
import io.cucumber.java.en.And;
import stepDefinitions.BaseClass;

public class CloseBrowser extends BaseClass {
    @And("^Close The Browser$")
    public void closeTheBrowser(){
        driver.close();
    }
}
