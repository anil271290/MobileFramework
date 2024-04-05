package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class IntroLocations {

    public AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/rlSpinner")
    public WebElement locat;

    @AndroidFindBy(id = "com.commonfriend:id/btnDialogContinue")
    public WebElement conbutton;

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


    public IntroLocations(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clicklocation() {
        locat.click();
    }

    public void selectlocat() {

        // Interacting with elements
        for (WebElement location : locations) {
            System.out.println(location.getText());
            // Perform other actions if needed
        }

        // Using page object methods
        List<String> locationTexts = IntroLocations.getLocationTexts();
        for (String locationText : locationTexts) {
            System.out.println(locationText);


        }

        IntroLocations.clickLocation(0);// Click on the first location
        IntroLocations.clickLocation(1);
        IntroLocations.clickLocation(2);
        IntroLocations.clickLocation(3);
        IntroLocations.clickLocation(5);
        IntroLocations.clickLocation(7);
        conbutton.click();

    }
}




