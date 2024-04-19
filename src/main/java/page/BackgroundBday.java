package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.pagefactory.*;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.TouchAction;

import java.time.Duration;


public class BackgroundBday {
    public AppiumDriver driver;


    @AndroidFindBy(xpath = "//(android.widget.NumberPicker)[3]")
    public WebElement year;
    @AndroidFindBy(xpath = "//(android.widget.NumberPicker)[2]")
    public WebElement date;

    @AndroidFindBy(xpath = "//(android.widget.NumberPicker)[1]")
    public WebElement month;
    @AndroidFindBy(id = "com.commonfriend:id/date_Picker")
    public WebElement container;
    @AndroidFindBy(xpath = "//*[@text=\"When's your birthday?\"]")
    public WebElement bdayQueTitle;

    @AndroidFindBy(xpath = "//*[@text='Background']")
    public WebElement ThirdPageHeaderTitle;
    @AndroidFindBy(xpath = "//*[@text='3/6']")
    public WebElement ThirdPageNo;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement thirdPagePrivacyText;

  //public  WebElement container = driver.findElement(MobileBy.id("com.commonfriend:id/date_Picker"));



    public BackgroundBday(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }



}








