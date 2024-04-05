package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroGender {

    public AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Male']")
    public WebElement Male;
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Female']")
    public WebElement Female;

    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement conti;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement gps;

    public IntroGender(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void selectgender(WebElement element) {
        element.click();
    }

    public void currentlocation() {
        gps.click();
    }
}






