package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import test.TestClass;

import java.util.ArrayList;
import java.util.List;

public class IntroLocations {

    public AppiumDriver driver;
    protected static final Logger logger = LogManager.getLogger(IntroLocations.class);

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
    @AndroidFindByAllSet(value = {@AndroidFindAll(value = {@AndroidBy(xpath = "//android.widget.TextView[@resource-id='com.commonfriend:id/txtCulture']")})})
    public static List<WebElement> locations;

    public static List<String> getLocationTexts() {
        List<String> locationTexts = new ArrayList<>();
        for (WebElement location : locations) {
            locationTexts.add(location.getText());
        }
        return locationTexts;
    }

    public static void clickLocation(int index) {
        if (index >= 0 && index < locations.size()) {
            locations.get(index).click();
        } else {
            System.out.println("Invalid index.");
        }
    }
    //For Only 1 city you want to select



    public IntroLocations(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }


    public void selectlocat() {

        // Interacting with elements
        for (WebElement location : locations) {
           // System.out.println(location.getText());
            logger.info(location.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> locationTexts = IntroLocations.getLocationTexts();
        for (String locationText : locationTexts) {
            logger.info(locationText);


        }

        IntroLocations.clickLocation(0);// Click on the first location
        IntroLocations.clickLocation(1);
        IntroLocations.clickLocation(2);
        IntroLocations.clickLocation(3);
        IntroLocations.clickLocation(5);
        IntroLocations.clickLocation(7);


    }
    /*
    below code is for select only 1 city with textName
     */
    public static void selectionOfLocation(String LocationText) {
        for (WebElement location : locations) {
            System.out.println(location.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> locationTexts = IntroLocations.getLocationTexts();
        for (String locationText : locationTexts) {
            System.out.println(locationText);
        }
        IntroLocations.selectionOfLocation("Mumbai");

    }
}




