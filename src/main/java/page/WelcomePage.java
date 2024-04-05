package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class WelcomePage {

    public AppiumDriver driver;

    @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
    public WebElement allow;

    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement continue1;

    public WelcomePage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void permission1() {
        allow.click();
    }

    public void clikcontnu1() {
        continue1.click();
    }
}
