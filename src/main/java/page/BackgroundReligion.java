package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class BackgroundReligion {

    public AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/txtLocationName")
    public WebElement selectreligion;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Hindu']")
    public WebElement tickreligion;
  /*  @AndroidFindBy(xpath = "//android.widget.TextView[@text='Muslim']")
    public WebElement tickreligion;
*/

    public BackgroundReligion(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void religion() {
        selectreligion.click();
    }

    public void checkreligion() {
        tickreligion.click();
    }

}
