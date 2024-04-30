package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class CheckList {

    public AppiumDriver driver;

    @AndroidFindBy(id = "btnSave")
    public WebElement savechecklistbutton;
    @AndroidFindBy(uiAutomator = "new UiSelector().text(\"Vegan\")")
    public WebElement scrolllling;



    public CheckList(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void checklistsave() {
        savechecklistbutton.click();
    }

    public void scroll() {
        scrolllling.getText();
    }


}
