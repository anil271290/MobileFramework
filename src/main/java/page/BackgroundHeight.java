package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class BackgroundHeight {
    public AppiumDriver driver;

    public BackgroundHeight(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//*[@text='How tall are you?']")
    public WebElement HeightScreenQueTitle;
    @AndroidFindBy(xpath = "//*[@text='Visible to your recommendations only']")
    public WebElement heightPrivacyText;
    @AndroidFindBy(xpath = "//*[@text='4/6']")
    public WebElement FourthPageNo;
    @AndroidFindBy(xpath = "//*[@text='Inches']")
    public WebElement HeightContainerText;


}
