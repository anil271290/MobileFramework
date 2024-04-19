package page;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.support.PageFactory;

public class    StartPage {
    public AppiumDriver driver;

    @AndroidFindBy(id = "com.commonfriend:id/imgPlayButton")
    public WebElement clickImoji;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']/../*[7]")
    public WebElement secondImoji;

    @AndroidFindBy(id = "com.commonfriend:id/btnCancel")
    public WebElement crossBtn;

    @AndroidFindBy(xpath = "//*[@text='People looking to get married.']")
    public WebElement ringTextXpath;
    @AndroidFindBy(xpath = "//*[@text='Usual turnaround time is 72 hours.']")
    public WebElement timeMeterXpath;
    @AndroidFindBy(xpath = "//*[@text='To maintain a balanced gender ratio\n" +
            "and ensure genuine profiles.']")
    public WebElement dollorTextXpath;
    @AndroidFindBy(xpath = "//*[@text='We are new! We want your support\n" +
            "and patience. ']")
    public WebElement namasteTextXpath;
    @AndroidFindBy(xpath = "//*[@text='Who is it for?']")
    public WebElement startPageScreenTitle;
    @AndroidFindBy(xpath = "//*[@text='If required, I shall use this number\n" +
            "to get in touch.']")
    public WebElement startPageMiniTitle;
    @AndroidFindBy(xpath = "//*[@text='I will send you a text with a verification code.']")
    public WebElement verificationText;
    @AndroidFindBy(xpath = "//*[@text=\"By login in you agree to my 'Term' and 'Privacy Policy'\"]")
    public WebElement privacyPolicyText;

    @AndroidFindBy(id = "btnNext")
    public WebElement firstButton;

    @AndroidFindBy(xpath = "//*[@text='%s' and @resource-id='com.commonfriend:id/txtCulture']/../android.widget.ImageView")
    public WebElement selectCity;

    public StartPage(AppiumDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void clickButton() {
        firstButton.click();
    }
}
