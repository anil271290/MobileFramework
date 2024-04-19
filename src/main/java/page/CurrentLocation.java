package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class CurrentLocation {
    public AppiumDriver driver;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement conti;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
    public WebElement gps;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_deny_button")
    public WebElement permissionDeny;
    @AndroidFindBy(xpath = "//*[@text='Approximate']")
    public WebElement approxRadioImage;
    @AndroidFindBy(xpath = "//*[@text='Precise']")
    public WebElement PreciseRadioImage;
    @AndroidFindBy(xpath = "//*[@text='Your location.']")
    public WebElement thirdPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement thirdPagePrivacyText;
    @AndroidFindBy(xpath = "//*[@text='3/6']")
    public WebElement ThirdPageNo;

    public CurrentLocation(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


}
