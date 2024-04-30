package page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class IntroName {
    public AppiumDriver driver;
    @AndroidFindBy(id = "com.commonfriend:id/btnAdd")
    public WebElement continue1;
    @AndroidFindBy(id = "com.commonfriend:id/txtTagLine")
    public WebElement IntroHomeTitleText;

    @AndroidFindBy(id = "com.commonfriend:id/edtFirstName")
    public WebElement fname;

    @AndroidFindBy(id = "com.commonfriend:id/edtLastName")
    public WebElement lname;

    @AndroidFindBy(id = "com.commonfriend:id/btnContinue")
    public WebElement cntn;

    @AndroidFindBy(xpath = "//*[@text='Sharma']")
    public WebElement lastNameText;
    @AndroidFindBy(xpath = "//*[@text='Visible to your matches only']")
    public WebElement privacyText;
    @AndroidFindBy(xpath = "//*[@text='Introduction']")
    public WebElement headerTitle;
    @AndroidFindBy(id = "com.commonfriend:id/btnLeft")
    public WebElement backArrow;
    @AndroidFindBy(xpath = "//*[@text='1/6']")
    public WebElement FirstPageNo;
    @AndroidFindBy(xpath = "//*[@text=\"What's your name?\"]")
    public WebElement firstPageQueTitle;

    public IntroName(AppiumDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void enterfirstname(String startname) {
        fname.sendKeys(startname);
    }

    public void enterlastname(String endname) {

        lname.sendKeys(endname);
    }

    public void clkcont() {
        cntn.click();
    }

}
