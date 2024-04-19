package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.FieldDecorator;

public class BackgroundReligion {

    public AppiumDriver driver;
    @AndroidFindBy(xpath = "//*[@text='Background']")
    public WebElement FirstPageHeaderTitle;
    @AndroidFindBy(xpath = "//*[@text='1/6']")
    public WebElement FirstPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement firstPagePrivacyText;
    @AndroidFindBy(xpath = "//*[@text='What religion do you follow?']")
    public WebElement FirstPageQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Select religion']")
    public WebElement dropDownPlaceHolderText;
    @AndroidFindBy(xpath = "//androidx.recyclerview.widget.RecyclerView/*")
    public WebElement allReligionXpath;
    @AndroidFindBy(xpath = "//*[@resource-id='com.commonfriend:id/btnCancel']")
    public WebElement downArrowButton;

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


}
