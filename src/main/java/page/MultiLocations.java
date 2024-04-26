package page;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MultiLocations {

    public AppiumDriver driver;
    private static final Logger logger = LogManager.getLogger(IntroLocations.class);


    public MultiLocations(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.commonfriend:id/rlSpinner")
    public WebElement locat;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public WebElement conbutton;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public WebElement FourthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Where do you plan to settle?']")
    public WebElement fourthPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Add locations']")
    public WebElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//*[@text='Choose location to add here']")
    public WebElement belowAddLocationsText;
    public List<WebElement> getLocations() {
        return driver.findElements(AppiumBy.xpath("(//*[@resource-id=\"com.commonfriend:id/checkbox\"])"));
    }

    public void selectLocations(int... indices) {
        List<WebElement> locations = getLocations();
        for (int index : indices) {
            if (index >= 0 && index < locations.size()) {
                WebElement location = locations.get(index);
                logger.info("Selecting location: " + location.getText());
                location.click();
            } else {
                logger.warn("Invalid index: " + index);
            }
        }
    }
}
